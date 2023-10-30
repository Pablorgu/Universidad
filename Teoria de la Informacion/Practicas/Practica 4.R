Huffman <- function(n_mensajes, probabilidades, D_simbolos) {
  # Verifico si la suma de las probabilidades es 1 y si la longitud de probablididades es n_mensajes
  if (sum(probabilidades) != 1 | length(probabilidades) != n_mensajes) {
    return(NA)
  } else {
    # Calculo el resto para la asignación de símbolos
    resto <- (n_mensajes - 2) %% (D_simbolos - 1)
    # Ordeno las probabilidades de mayor a menor
    probabilidades_ordenadas <- sort(probabilidades, decreasing = TRUE, index.return = TRUE)
    # Inicializo la matriz de códigos con NA
    codigos <- array(NA, n_mensajes)
    # Inicializo un vector para indicar qué mensajes ya tienen símbolo asignado
    mensajes_utilizados <- array(0, n_mensajes)
    suma_probabilidades <- 0
    aux_probabilidades <- probabilidades_ordenadas
    
    # Asigno los símbolos a los mensajes con las mayores probabilidades
    for (i in 0:(resto + 1)) {
      suma_probabilidades <- suma_probabilidades + probabilidades_ordenadas$x[n_mensajes - i]
      codigos[probabilidades_ordenadas$ix[n_mensajes - i]] <- D_simbolos - (i + 1)
      aux_probabilidades$x[n_mensajes - i] <- length(aux_probabilidades$x) + 1
      mensajes_utilizados[n_mensajes - i] <- 1
    }
    
    # Añado la suma de probabilidades a la lista
    aux_probabilidades$x[length(aux_probabilidades$x) + 1] <- suma_probabilidades
    probabilidades_ordenadas_actuales <- aux_probabilidades$x
    
    # Mientras no he asignado símbolos a todos los mensajes
    while (sum(mensajes_utilizados) < n_mensajes) {
      suma_probabilidades <- 0
      nuevos_codigos <- array(NA, n_mensajes)
      prob_auxiliares <- aux_probabilidades
      
      # Asigno los símbolos a los mensajes restantes
      for (i in 0:(D_simbolos - 1)) {
        suma_probabilidades <- suma_probabilidades + aux_probabilidades$x[length(aux_probabilidades$x) - i]
        
        # Verifico si el mensaje tiene un índice válido y si no ha sido asignado ya
        if (!is.na(aux_probabilidades$ix[length(aux_probabilidades$x) - i]) && aux_probabilidades$ix[length(aux_probabilidades$x) - i] <= n_mensajes) {
          nuevos_codigos[aux_probabilidades$ix[length(aux_probabilidades$x) - i]] <- D_simbolos - (i + 1)
          aux_probabilidades$x[length(aux_probabilidades$x) - i] <- length(aux_probabilidades$x) + 1
          probabilidades_ordenadas_actuales[aux_probabilidades$ix[length(aux_probabilidades$x) - i]] <- length(aux_probabilidades$x) + 1
          mensajes_utilizados[aux_probabilidades$ix[length(aux_probabilidades$x) - i]] <- 1
        } else if (!is.na(aux_probabilidades$ix[length(aux_probabilidades$x) - i])) {
          aux_probabilidades$x[length(aux_probabilidades$x) - i] <- length(aux_probabilidades$x) + 1
          probabilidades_ordenadas_actuales[aux_probabilidades$ix[length(aux_probabilidades$x) - i]] <- length(aux_probabilidades$x) + 1
          
          # Actualizo los índices de los mensajes que tienen la misma probabilidad
          for (j in 1:length(aux_probabilidades$x)) {
            if (!is.na(prob_auxiliares$x[j]) && prob_auxiliares$x[j] == aux_probabilidades$ix[length(aux_probabilidades$x) - i]) {
              aux_probabilidades$x[j] <- length(aux_probabilidades$x) + 1
              probabilidades_ordenadas_actuales[prob_auxiliares$ix[j]] <- length(aux_probabilidades$x) + 1
              
              if (!is.na(prob_auxiliares$ix[j]) && prob_auxiliares$ix[j] <= n_mensajes) {
                nuevos_codigos[prob_auxiliares$ix[j]] <- D_simbolos - (i + 1)
              }
            }
          }
        }
      }
      
      # Añado la suma de probabilidades a la lista
      aux_probabilidades$x[length(aux_probabilidades$x) + 1] <- suma_probabilidades
      codigos <- cbind(nuevos_codigos, codigos)
      probabilidades_ordenadas_actuales[length(probabilidades_ordenadas_actuales) + 1] <- suma_probabilidades
      aux_probabilidades <- sort(probabilidades_ordenadas_actuales, decreasing = TRUE, index.return = TRUE)
    }
    
    return(codigos)
  }
}

 Huffman(8,c(0.25, 0.25, 0.126, 0.124, 0.0625, 0.0625, 0.0625, 0.0625),4)
 Huffman(8,c(0.25, 0.25, 0.126, 0.124, 0.0625, 0.0625, 0.0625, 0.0625),3)
 