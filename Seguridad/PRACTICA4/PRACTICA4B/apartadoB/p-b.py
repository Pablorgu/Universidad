

from Crypto.Hash import SHA256, HMAC
import base64
import json
import sys
from socket_class import SOCKET_SIMPLE_TCP
import funciones_aes
from Crypto.Random import get_random_bytes

# Paso 0: Inicializacion
########################

# Lee clave KBT
KBT = open("KBT.bin", "rb").read()

# Paso 1) B->T: KBT(Bob, Nb) en AES-GCM
#######################################

# Crear el socket de conexion con T (5551)
print("Creando conexion con T...")
socket = SOCKET_SIMPLE_TCP('127.0.0.1', 5551)
socket.conectar()

# Crea los campos del mensaje
t_n_origen = get_random_bytes(16)

# Codifica el contenido (los campos binarios en una cadena) y contruyo el mensaje JSON
msg_TE = []
msg_TE.append("Bob")
msg_TE.append(t_n_origen.hex())
json_ET = json.dumps(msg_TE)
print("B -> T (descifrado): " + json_ET)

# Cifra los datos con AES GCM
aes_engine = funciones_aes.iniciarAES_GCM(KBT)
cifrado, cifrado_mac, cifrado_nonce = funciones_aes.cifrarAES_GCM(aes_engine,json_ET.encode("utf-8"))

# Envia los datos
socket.enviar(cifrado)
socket.enviar(cifrado_mac)
socket.enviar(cifrado_nonce)

# Paso 2) T->B: KBT(K1, K2, Nb) en AES-GCM
##########################################

# (A realizar por el alumno/a...)
cifrado = socket.recibir()
cifrado_mac = socket.recibir()
cifrado_nonce = socket.recibir()

# Descifro los datos con AES GCM
datos_descifrado_ET = funciones_aes.descifrarAES_GCM(KBT, cifrado_nonce, cifrado, cifrado_mac)

# Decodifica el contenido: k1, k2, nb
json_ET = datos_descifrado_ET.decode("utf-8" ,"ignore")
print("T -> B (descifrado): " + json_ET)
msg_ET = json.loads(json_ET)
K1, K2, Nb = msg_ET
K1 = bytearray.fromhex(K1)
K2 = bytearray.fromhex(K2)
Nb = bytearray.fromhex(Nb)
# Cerramos el socket entre B y T, no lo utilizaremos mas
socket.cerrar() 

#compruebo que el nonce es el mismo
if Nb != t_n_origen:
    print("Nonce no coincide")
    sys.exit()

# Paso 5) A->B: KAB(Nombre) en AES-CTR con HMAC
###############################################

# (A realizar por el alumno/a...)
# Crear el socket de conexion con A (5552)
print("Creando conexion con A...")
socket = SOCKET_SIMPLE_TCP('127.0.0.1', 5551)
socket.escuchar() 

# Recibo los datos
cifrado = socket.recibir()
cifrado_mac = socket.recibir()
cifrado_nonce = socket.recibir()

h = HMAC.new(K2, digestmod=SHA256)
h.update(cifrado)
try:
    h.hexverify(cifrado_mac)
    print("El mensaje es autentico")
except ValueError:
    print("El mensaje no es autentico")

# Descifro los datos con AES CTR
aes_engine = funciones_aes.iniciarAES_CTR_descifrado(K1, cifrado_nonce)
jStr = funciones_aes.descifrarAES_CTR(aes_engine, cifrado)

# Decodifica el contenido: nombre
jStr = jStr.decode("utf-8" ,"ignore")
print("A -> B (descifrado): " + jStr)
msg_EA = json.loads(jStr)
nombre = msg_EA[0]


# Paso 6) B->A: KAB(Apellido) en AES-CTR con HMAC
#################################################

# (A realizar por el alumno/a...)

#Codifico el contenido (los campos binarios en una cadena) y contruyo el mensaje JSON
msg_BA= []
msg_BA.append(nombre)
msg_BA.append("Guerrero")
json_BA = json.dumps(msg_BA)
print("B -> A (descifrado): " + json_BA)

# Cifro los datos con AES CTR
aes_engine, cifrado_nonce = funciones_aes.iniciarAES_CTR_cifrado(K1)
cifrado = funciones_aes.cifrarAES_CTR(aes_engine, json_BA.encode("utf-8"))

h = HMAC.new(K2, digestmod=SHA256)
h.update(cifrado)

# Envio los datos
socket.enviar(cifrado)
socket.enviar(cifrado_nonce)
socket.enviar(h.hexdigest().encode("utf-8"))

# Paso 7) A->B: KAB(END) en AES-CTR con HMAC
############################################

# (A realizar por el alumno/a...)

# Recibo los datos
cifrado = socket.recibir()
cifrado_mac = socket.recibir()
cifrado_nonce = socket.recibir()

h = HMAC.new(K2, digestmod=SHA256)
h.update(cifrado)
try:
    h.hexverify(cifrado_mac)
    print("El mensaje es autentico")
except ValueError:
    print("El mensaje no es autentico")

# Descifro los datos con AES CTR
aes_engine = funciones_aes.iniciarAES_CTR_descifrado(K1, cifrado_nonce)
jStr = funciones_aes.descifrarAES_CTR(aes_engine, cifrado)

# Decodifica el contenido: nombre
jStr = jStr.decode("utf-8" ,"ignore")
print("A -> B (descifrado): " + jStr)
msg_EA = json.loads(jStr)
end = msg_EA[0]

# Cerramos el socket entre A y B, no lo utilizaremos mas
socket.cerrar()