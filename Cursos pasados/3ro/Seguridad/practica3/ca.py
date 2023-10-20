from Codigo_RSA_CampusVirtual import *

alice = crear_RSAKey()
guardar_RSAKey_Publica("./alice.pub", alice)
guardar_RSAKey_Privada("./alice.pem", alice, "alice")

bob = crear_RSAKey()
guardar_RSAKey_Publica("./bob.pub", bob)
guardar_RSAKey_Privada("./bob.pem", bob, "bob")