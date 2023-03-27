from Codigo_RSA_CampusVirtual import *

Pri_B = cargar_RSAKey_Privada("./bob.pem", "bob")
Pub_A = cargar_RSAKey_Publica("./alice.pub")

texto = "Hola amigos de la seguridad"

cifradob = cargar("./cifrado")
firmab = cargar("./firma")

descifrado = descifrarRSA_OAEP(cifradob, Pri_B)
comprobarRSA_PSS(descifrado, firmab, Pub_A)
print(descifrado)