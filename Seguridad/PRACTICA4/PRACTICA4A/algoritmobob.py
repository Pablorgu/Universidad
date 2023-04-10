import funciones_rsa
import funciones_aes
from socket_class import SOCKET_SIMPLE_TCP
from Crypto.Hash import HMAC, SHA256
import json

# Cargo la clave pública de Alice y la clave privada de Bob
Pub_A = funciones_rsa.cargar_RSAKey_Publica("rsa_alice.pub")
Pri_B = funciones_rsa.cargar_RSAKey_Privada("rsa_bob.pem", "bob")

# Creamos el servidor para Bob y recibimos las claves y la firma
socketserver = SOCKET_SIMPLE_TCP('127.0.0.1', 5551)
socketserver.escuchar()
print("Esperando conexión de Alice...")

K1_cif = socketserver.recibir()
K2_cif = socketserver.recibir()
K1K2_fir = socketserver.recibir()

# Descifro las claves K1 y K2 con Pri_B
K1 = funciones_rsa.descifrarRSA_OAEP_BIN(K1_cif, Pri_B)
K2 = funciones_rsa.descifrarRSA_OAEP_BIN(K2_cif, Pri_B)

# Compruebo la validez de la firma con Pub_A
if funciones_rsa.comprobarRSA_PSS(K1+K2,K1K2_fir,Pub_A):
    print("Firma de K1||K2 válida")
else:
    print("Firma de K1||K2 NO válida")

#####################
#####################

# Recibo el mensaje, junto con el nonce del AES CTR, y el mac del HMAC
jStr_cif = socketserver.recibir()
nonce = socketserver.recibir()
mac = socketserver.recibir()
# Descifro el mensaje
aes_descifrado = funciones_aes.iniciarAES_CTR_descifrado(K1, nonce)
jStr = funciones_aes.descifrarAES_CTR(aes_descifrado, jStr_cif).decode("utf-8")

# Verifico el mac
h = HMAC.new(K2, digestmod=SHA256)
h.update(jStr_cif)
try:
    h.verify(mac)
    print("El mensaje es auténtico")
except ValueError:
    print("El mensaje no es auténtico")

# Visualizo la identidad del remitente
mensaje = json.loads(jStr)
alice, nonceA = mensaje
print("El mensaje es de: " + mensaje[0])

#####################
#####################

# Genero el json con el nombre de Bob, el de Alice y el nonce nA Genero un nonce de 16 bytes
mensaje = [] # Array vacio
mensaje.append("Bob")
mensaje.append(alice)
mensaje.append(nonceA) # Conversion de Bytes a Hexadecimal
jStr = json.dumps(mensaje) # Convertimos un Array Python a string
print(jStr)

# Cifro el json con K1
aes_cifrado, nonce = funciones_aes.iniciarAES_CTR_cifrado(K1)
jStr_cif = funciones_aes.cifrarAES_CTR(aes_cifrado, jStr.encode("utf-8"))

# Aplico HMAC
h = HMAC.new(K2, digestmod=SHA256)
h.update(jStr_cif)
mac = h.digest()

# Envío el json cifrado junto con el nonce del AES CTR, y el mac del HMAC
socketserver.enviar(jStr_cif)
socketserver.enviar(nonce)
socketserver.enviar(mac)

#####################
#####################

# Recibo el primer mensaje de Alice

# Descifro el mensaje


# Verifico el mac

# Muestro el mensaje


# Recibo el segundo mensaje de Alice

# Descifro el mensaje


# Verifico el mac

# Muestro el mensaje


# Cierro el socket
socketserver.cerrar()
