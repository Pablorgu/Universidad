# Defino una función para calcular la entropía de un conjunto de valores
entropia <- function(valores){
  -sum(valores * log2(valores))
}

# Defino una función para analizar una cadena de Markov
cadena_markov <- function(matriz_probabilidades){
  
  # Verifico que las probabilidades sumen 1 en cada fila
  for (i in 1:ncol(matriz_probabilidades)){
    fila_valores <- matriz_probabilidades[i,]
    if (sum(fila_valores) != 1){
      stop("Encuentro un error en las probabilidades.")
    }
  }
  
  # Construyo la matriz transpuesta y ajusto para el sistema de ecuaciones
  transpuesta <- t(matriz_probabilidades)
  matriz_identidad <- diag(ncol(transpuesta))
  transpuesta <- transpuesta - matriz_identidad
  sistema_ecuaciones <- rbind(transpuesta, c(rep(1, ncol(matriz_probabilidades))))
  
  # Inicializo la matriz de incógnitas y resuelvo el sistema de ecuaciones
  incognitas <- matrix(c(rep(0, nrow(matriz_probabilidades)), 1), ncol = 1)
  resultados <- qr.solve(sistema_ecuaciones, incognitas)
  
  # Verifico que la suma de las probabilidades del vector estacionario es 1
  if (sum(resultados) < 1 - 0.0005 | sum(resultados) > 1 + 0.0005 ){
    stop("Encuentro un error en las probabilidades del vector estacionario.")
  }
  
  # Imprimo el vector que describe los estados estacionarios
  print("El vector que describe los estados estacionarios es:")
  print(resultados)
  
  # Calculo las entropías asociadas a cada fila de la matriz
  entropias <- rep(0, ncol(matriz_probabilidades))
  for (i in 1:ncol(matriz_probabilidades)){
    valores_ordenados <- sort(matriz_probabilidades[i])
    valores_ordenados <- valores_ordenados[!valores_ordenados %in% 0:1]
    h <- entropia(valores_ordenados)
    entropias[i] <- h
  }
  
  # Imprimo las entropías asociadas a cada fila de la matriz
  print("Las entropías asociadas a cada fila de la matriz son:")
  print(entropias)
  
  # Calculo e imprimo la entropía total de la fuente
  resultado_final <- 0
  for (i in 1:length(entropias)){
    resultado_final <- resultado_final + entropias[i] * resultados[i]
  }
  
  print(paste("La entropía total de la fuente es:", resultado_final, "\n"))
}

# Ejemplo práctico:
matriz_probabilidades_ejemplo <- matrix(c(0.3, 0.1, 0.6, 0.2, 0.5, 0.3, 0.4, 0.2, 0.4), ncol = 3, byrow = TRUE)
cadena_markov(matriz_probabilidades_ejemplo)

