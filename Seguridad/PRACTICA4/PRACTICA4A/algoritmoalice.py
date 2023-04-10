import funciones_rsa
import funciones_aes
from socket_class import SOCKET_SIMPLE_TCP
from Crypto.Hash import HMAC, SHA256
from Crypto.Random import get_random_bytes
import json

# Cargo la clave pública de Bob y la clave privada de Alice
Pub_B = funciones_rsa.cargar_RSAKey_Publica("rsa_bob.pub")
Pri_A = funciones_rsa.cargar_RSAKey_Privada("rsa_alice.pem", "alice")

# Genero las dos claves
K1 = funciones_aes.crear_AESKey()
K2 = funciones_aes.crear_AESKey()



# Cifro K1 y K2 con Pub_B
K1_cif = funciones_rsa.cifrarRSA_OAEP_BIN(K1, Pub_B)
K2_cif = funciones_rsa.cifrarRSA_OAEP_BIN(K2, Pub_B)

# Firmo la concatenación de K1 y K2 con Pri_A
K1K2_fir = funciones_rsa.firmarRSA_PSS(K1 + K2, Pri_A)

# Conectamos con el servidor y enviamos a Bob a través del socket
socketclient = SOCKET_SIMPLE_TCP('127.0.0.1', 5551)
socketclient.conectar()


socketclient.enviar(K1_cif)
socketclient.enviar(K2_cif)
socketclient.enviar(K1K2_fir)


#####################
#####################

# Genero el json con el nombre de Alice y un nonce nA
nonceA=get_random_bytes(16) # Genero un nonce de 16 bytes
mensaje = [] # Array vacio
mensaje.append("Alice")
mensaje.append(nonceA.hex()) # Conversion de Bytes a Hexadecimal
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
socketclient.enviar(jStr_cif)
socketclient.enviar(nonce)
socketclient.enviar(mac)

#####################
#####################

# Recibo el mensaje, junto con el nonce del AES CTR, y el mac del HMAC
jStr_cif = socketclient.recibir()
nonce = socketclient.recibir()
mac = socketclient.recibir()

# Descifro el mensaje
aes_descifrado = funciones_aes.iniciarAES_CTR_descifrado(K1, nonce)
jStr = funciones_aes.descifrarAES_CTR(aes_descifrado, jStr_cif)

# Verifico el mac
h = HMAC.new(K2, digestmod=SHA256)
h.update(jStr_cif)
try:
    h.verify(mac)
    print("El mensaje es auténtico")
except ValueError:
    print("El mensaje no es auténtico")


# Visualizo la identidad del remitente y compruebo si los campos enviados son los mismo que los recibidos
mensaje2 = json.loads(jStr)
print("El mensaje es de: " + mensaje2[0])
if mensaje[0] == mensaje2[1] and mensaje[1] == mensaje2[2]:
    print("Los campos enviados son los mismos que los recibidos")
else:
    print("Los campos enviados no son los mismos que los recibidos")
#####################

# Intercambio de información NUMERO 1. Al utilizar K1, reutilizo el canal de comunicaciones aes_cifrado


# Aplico HMAC


# Envío el json cifrado junto con el nonce del AES CTR, y el mac del HMAC


# Intercambio de información NUMERO 2. Al utilizar K1, reutilizo el canal de comunicaciones aes_cifrado


# Aplico HMAC


# Envío el json cifrado junto con el nonce del AES CTR, y el mac del HMAC


# Cierro el socket
socketclient.cerrar()