
from Crypto.Hash import SHA256, HMAC
import base64
import json
import sys
from socket_class import SOCKET_SIMPLE_TCP
import funciones_aes
from Crypto.Random import get_random_bytes

# Paso 0: Inicializacion
########################

# (A realizar por el alumno/a...)
KAT = open("KAT.bin", "rb").read()

# Crear el socket de conexion con T (7771)
print("Creando conexion con T...")
socket = SOCKET_SIMPLE_TCP('127.0.0.1', 7771)
socket.conectar()

# Paso 3) A->T: KAT(Alice, Na) en AES-GCM
#########################################

# (A realizar por el alumno/a...)
t_n_origen = get_random_bytes(16)

# Codifica el contenido (los campos binarios en una cadena) y contruyo el mensaje JSON
msg_TE = []
msg_TE.append("Alice")
msg_TE.append(t_n_origen.hex())
json_TE = json.dumps(msg_TE)
print("A -> T (descifrado): " + json_TE)

# Cifra los datos con AES GCM
aes_engine = funciones_aes.iniciarAES_GCM(KAT)
cifrado, cifrado_mac, cifrado_nonce = funciones_aes.cifrarAES_GCM(aes_engine,json_TE.encode("utf-8"))

# Envia los datos
socket.enviar(cifrado)
socket.enviar(cifrado_mac)
socket.enviar(cifrado_nonce)

# Paso 4) T->A: KAT(K1, K2, Na) en AES-GCM
##########################################

# (A realizar por el alumno/a...)
cifrado = socket.recibir()
cifrado_mac = socket.recibir()
cifrado_nonce = socket.recibir()

# Descifro los datos con AES GCM
descifrado = funciones_aes.descifrarAES_GCM(KAT, cifrado_nonce, cifrado, cifrado_mac)

# Decodifica el contenido: k1, k2, na
json_TE = descifrado.decode("utf-8" ,"ignore")
print("T -> A (descifrado): " + json_TE)
msg_TE = json.loads(json_TE)
K1, K2, Na = msg_TE
K1 = bytearray.fromhex(K1)
K2 = bytearray.fromhex(K2)
Na = bytearray.fromhex(Na)

# Cerramos el socket entre A y T, no lo utilizaremos mas
socket.cerrar()
#compruebo que el nonce es el mismo
if Na != t_n_origen:
    print("Error en el nonce")
    sys.exit()

# Paso 5) A->B: KAB(Nombre) en AES-CTR con HMAC
###############################################

# (A realizar por el alumno/a...)
# Crear el socket de conexion con B (7772)
print("Creando conexion con B...")
socket = SOCKET_SIMPLE_TCP('127.0.0.1', 5551)
socket.conectar()

# Codifica el contenido (los campos binarios en una cadena) y contruyo el mensaje JSON
msg_AB = []
msg_AB.append("Alice")
json_AB = json.dumps(msg_AB)
print("A -> B (descifrado): " + json_AB)

# Cifra los datos con AES CTR
aes_engine, cifrado_nonce = funciones_aes.iniciarAES_CTR_cifrado(K1)
cifrado = funciones_aes.cifrarAES_CTR(aes_engine, json_AB.encode("utf-8"))

h = HMAC.new(K2, digestmod=SHA256)
h.update(cifrado)

# Envia los datos
socket.enviar(cifrado)
socket.enviar(h.hexdigest().encode("utf-8"))
socket.enviar(cifrado_nonce)

# (A realizar por el alumno/a...)

# Paso 6) B->A: KAB(Apellido) en AES-CTR con HMAC
#################################################

# (A realizar por el alumno/a...)
cifrado = socket.recibir()
cifrado_nonce = socket.recibir()
cifrado_mac = socket.recibir()

# Compruebo el HMAC
h = HMAC.new(K2, digestmod=SHA256)
h.update(cifrado)
try:
    h.hexverify(cifrado_mac)
    print("El mensaje es autentico")
except ValueError:
    print("El mensaje no es autentico")

# Descifro los datos con AES CTR
aes_engine= funciones_aes.iniciarAES_CTR_descifrado(K1, cifrado_nonce)
jStr = funciones_aes.descifrarAES_CTR(aes_engine, cifrado)
jStr = jStr.decode("utf-8" ,"ignore")

print("B -> A (descifrado): " + jStr)
msg_AB = json.loads(jStr)
apellido = msg_AB[1]

# Paso 7) A->B: KAB(END) en AES-CTR con HMAC
############################################

# (A realizar por el alumno/a...)
# Codifica el contenido (los campos binarios en una cadena) y contruyo el mensaje JSON
msg_AB = []
msg_AB.append("END")
json_AB = json.dumps(msg_AB)
print("A -> B (descifrado): " + json_AB)

# Cifra los datos con AES CTR
aes_engine, cifrado_nonce = funciones_aes.iniciarAES_CTR_cifrado(K1)
cifrado = funciones_aes.cifrarAES_CTR(aes_engine, json_AB.encode("utf-8"))


h = HMAC.new(K2, digestmod=SHA256)
h.update(cifrado)

# Envia los datos
socket.enviar(cifrado)
socket.enviar(h.hexdigest().encode("utf-8"))
socket.enviar(cifrado_nonce)

# Cerramos el socket entre A y B, no lo utilizaremos mas
socket.cerrar()