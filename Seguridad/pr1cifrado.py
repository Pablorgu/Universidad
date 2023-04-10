def encuentraclave(clave, pos):
    pos=pos%len(clave)
    orden = ord(clave[pos])
    return (orden - 65) % 26



def cifradoCesarAlfabetoInglesMAY(cadena, palabra):
    """Devuelve un cifrado Cesar tradicional (+3)"""
    # Definir la nueva cadena resultado
    resultado = ''
    # Realizar el "cifrado", sabiendo que A = 65, Z = 90, a = 97, z = 122
    i = 0
    while i < len(cadena):
        # Recoge el caracter a cifrar
        ordenClaro = ord(cadena[i])
        ordenCifrado = 0
        # Cambia el caracter a cifrar
        if (ordenClaro >= 65 and ordenClaro <= 90):
            ordenCifrado = (((ordenClaro - 65) + encuentraclave(palabra, i)) % 26) + 65
        elif(ordenClaro >=97 and ordenClaro <=122):
            ordenCifrado = (((ordenClaro - 97) + encuentraclave(palabra, i)) % 26) + 97
        elif(ordenClaro == 32):
            ordenCifrado = 32
        # Añade el caracter cifrado al resultado
        resultado = resultado + chr(ordenCifrado)
        i = i + 1
    # devuelve el resultado
    return resultado

def descifradoCesarAlfabetoInglesMAY(cadena, palabra):
    resultado = ''
    i = 0
    while i < len(cadena):
        # Recoge el caracter a cifrar
        ordenClaro = ord(cadena[i])
        ordenCifrado = 0
        # Cambia el caracter a cifrar
        if (ordenClaro >= 65 and ordenClaro <= 90):
            ordenCifrado = (((ordenClaro - 65) - encuentraclave(palabra, i)) % 26) + 65
        elif(ordenClaro >=97 and ordenClaro <=122):
            ordenCifrado = (((ordenClaro - 97) - encuentraclave(palabra, i)) % 26) + 97
        elif(ordenClaro == 32):
            ordenCifrado = 32
        # Añade el caracter cifrado al resultado
        resultado = resultado + chr(ordenCifrado)
        i = i + 1
    # devuelve el resultado
    return resultado


claroCESARMAY = 'VeNI ViDI ViNcI aURIA'
palabra= 'ESTOCOLMO'
print(claroCESARMAY)
cifradoCESARMAY = cifradoCesarAlfabetoInglesMAY(claroCESARMAY, palabra) 
print(cifradoCESARMAY)
descrifradoCESARMAY = descifradoCesarAlfabetoInglesMAY(cifradoCESARMAY, palabra)
print(descrifradoCESARMAY)