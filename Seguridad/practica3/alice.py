from Codigo_RSA_CampusVirtual import *

Pri_A = cargar_RSAKey_Privada("./alice.pem", "alice")
Pub_B = cargar_RSAKey_Publica("./bob.pub")

texto = "Hola amigos de la seguridad"

cifrado= cifrarRSA_OAEP(texto, Pub_B)
firma_K = firmarRSA_PSS(texto, Pri_A)

guardar("./cifrado", cifrado)
guardar("./firma", firma_K)