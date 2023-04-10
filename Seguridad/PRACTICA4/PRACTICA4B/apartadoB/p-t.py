from Crypto.Hash import SHA256, HMAC
import base64
import json
import sys
from socket_class import SOCKET_SIMPLE_TCP
import funciones_aes

# Paso 0: Crea las claves que T comparte con B y A
##################################################

# Crear Clave KAT, guardar a fichero
KAT = funciones_aes.crear_AESKey()
FAT = open("KAT.bin", "wb")
FAT.write(KAT)
FAT.close()

# Crear Clave KBT, guardar a fichero
KBT = funciones_aes.crear_AESKey()
FBT = open("KBT.bin", "wb")
FBT.write(KBT)
FBT.close()

# Paso 1) B->T: KBT(Bob, Nb) en AES-GCM
#######################################

# Crear el socket de escucha de Bob (5551)
print("Esperando a Bob...")
socket_Bob = SOCKET_SIMPLE_TCP('127.0.0.1', 5551)
socket_Bob.escuchar()

# Crea la respuesta para B y A: K1 y K2
K1 = funciones_aes.crear_AESKey()
K2 = funciones_aes.crear_AESKey()

# Recibe el mensaje
cifrado = socket_Bob.recibir()
cifrado_mac = socket_Bob.recibir()
cifrado_nonce = socket_Bob.recibir()

# Descifro los datos con AES GCM
datos_descifrado_ET = funciones_aes.descifrarAES_GCM(KBT, cifrado_nonce, cifrado, cifrado_mac)

# Decodifica el contenido: Bob, Nb
json_ET = datos_descifrado_ET.decode("utf-8" ,"ignore")
print("B->T (descifrado): " + json_ET)
msg_ET = json.loads(json_ET)

# Extraigo el contenido
t_bob, t_nb = msg_ET
t_nb = bytearray.fromhex(t_nb)

# Paso 2) T->B: KBT(K1, K2, Nb) en AES-GCM
##########################################

# (A realizar por el alumno/a...)
msg = []
msg.append(K1.hex())
msg.append(K2.hex())
msg.append(t_nb.hex())
jsn= json.dumps(msg)
aes_engine = funciones_aes.iniciarAES_GCM(KBT)
datos_cifrado, cifrado_nonce, cifrado_mac = funciones_aes.cifrarAES_GCM(aes_engine, jsn.encode("utf-8"))

# Envio el mensaje
socket_Bob.enviar(datos_cifrado)
socket_Bob.enviar(cifrado_nonce)
socket_Bob.enviar(cifrado_mac)

# Cerramos el socket entre B y T, no lo utilizaremos mas
socket_Bob.cerrar() 

# Paso 3) A->T: KAT(Alice, Na) en AES-GCM
#########################################

# (A realizar por el alumno/a...)
# Crear el socket de escucha de Alice (7771)
print("Esperando a Alice...")
socket_Alice = SOCKET_SIMPLE_TCP('127.0.0.1', 7771)
socket_Alice.escuchar()

# Recibe el mensaje
cifrado = socket_Alice.recibir()
cifrado_mac = socket_Alice.recibir()
cifrado_nonce = socket_Alice.recibir()

# Descifro los datos con AES GCM
datos_descifrado_TE = funciones_aes.descifrarAES_GCM(KAT, cifrado_nonce, cifrado, cifrado_mac)

# Decodifica el contenido: Alice, Na
json_TE = datos_descifrado_TE.decode("utf-8" ,"ignore")
print("A->T (descifrado): " + json_TE)
msg_TE = json.loads(json_TE)

# Extraigo el contenido
t_alice, t_na = msg_TE
t_na = bytearray.fromhex(t_na)

# Paso 4) T->A: KAT(K1, K2, Na) en AES-GCM
##########################################

# (A realizar por el alumno/a...)
msg = []
msg.append(K1.hex())
msg.append(K2.hex())
msg.append(t_na.hex())
json = json.dumps(msg)
aes_engine = funciones_aes.iniciarAES_GCM(KAT)
datos_cifrado, cifrado_nonce, cifrado_mac = funciones_aes.cifrarAES_GCM(aes_engine, json.encode("utf-8"))

# Envio el mensaje
socket_Alice.enviar(datos_cifrado)
socket_Alice.enviar(cifrado_nonce)
socket_Alice.enviar(cifrado_mac)

# Cerramos el socket entre A y T, no lo utilizaremos mas
socket_Alice.cerrar()
