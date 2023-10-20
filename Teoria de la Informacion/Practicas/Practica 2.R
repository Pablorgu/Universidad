# Función para construir códigos de longitud constante
calcularLongitudConstante <- function(simbolos, numero) {
  
  n <- length(simbolos)
  # Obtener el número de símbolos
  
  longitud <- ceiling((log2(numero)/log2(length(simbolos))))
  # Calcular la longitud necesaria para representar el número dado de códigos
  
  if ((n^longitud) >= numero) {
    # Verificar si la longitud es suficiente para representar el número de códigos
    
    permuta <- expand.grid(rep(list(simbolos), longitud))
    # Generar todas las permutaciones posibles de longitud 'longitud' con repetición
    
    permuta <- permuta[1:numero, , drop = FALSE]
    # Tomar solo las primeras 'numero' permutaciones
    
    
    for (i in 1:numero) {
      res <- permuta[i,]
      reString <- toString(res)
      print(paste("Código ", i, ": ", reString))
    }
    # Imprimir los códigos generados
  } else {
    cat("La longitud no es suficiente para representar el número dado de códigos.")
  }
}

# Ejemplo de uso
calcularLongitudConstante(c(0, 1), 5)


#LONGITUD MEDIA
# Función para calcular la longitud media del código
calcularLongitudMedia <- function(probabilidades, longitudes) {
  
  
  if (sum(probabilidades > 0 & probabilidades <= 1) > 0 & sum(probabilidades) == 1 & length(probabilidades) == length(longitudes)) {
    # Verificar condiciones de probabilidades válidas

    longitud_media <- sum(probabilidades * longitudes)
    # Calcular la longitud media

    print(longitud_media)
    # Imprimir la longitud media
  } else {
    print("ERROR: Datos no válidos")
    # Mostrar mensaje de error si las condiciones no se cumplen
  }
}

# Ejemplo de uso
calcularLongitudMedia(c(0.6, 0.3, 0.1), c(5, 3, 2)) 
calcularLongitudMedia(c(0.4, 0.5, 0.1), c(2, 4, 6))


#DESIGUALDAD DE KRAFT
# Función para verificar la desigualdad de Kraft
verificarDesigualdadKraft <- function(dimensiones, longitudes) {
  

  suma_potencias <- sum(length(dimensiones)^(-longitudes))
  # Calculo la suma de las inversas de las potencias de la longitud

  print(suma_potencias)
  # Imprimo la suma de las inversas de las potencias de la longitud

  cumple_desigualdad <- suma_potencias <= 1
  # Verifico si la desigualdad de Kraft se cumple

  return(cumple_desigualdad)
  # Devuelvo TRUE si la desigualdad se cumple, FALSE en caso contrario
}

# Ejemplo de uso 
verificarDesigualdadKraft(c(2, 3, 4), c(1, 2, 3))
