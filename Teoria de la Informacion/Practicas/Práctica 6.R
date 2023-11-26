# Función para calcular mi entropía dado un conjunto de valores
calcular_mi_entropia <- function(valores) {
  -sum(valores * log2(valores))
}

# Función para calcular mi capacidad de un canal
calcular_mi_capacidad <- function(matriz_probabilidades) {
  # Verifico que la suma de cada fila de la matriz de probabilidades sea 1
  for (i in 1:nrow(matriz_probabilidades)) {
    fila <- matriz_probabilidades[i,]
    if (sum(fila) != 1) {
      return("Error en la matriz de probabilidades")
    }
  }
  
  # Inicializo mi vector de entropías condicionales
  entropias_condicionales <- c(rep(0, nrow(matriz_probabilidades)))
  
  # Calculo mis entropías condicionales para cada columna de la matriz
  for (i in 1:ncol(matriz_probabilidades)){
    columna_ordenada <- sort(matriz_probabilidades[i,])
    columna_ordenada <- columna_ordenada[!columna_ordenada %in% 0:1]
    
    entropias_condicionales[i] <- calcular_mi_entropia(columna_ordenada[1]) + calcular_mi_entropia(columna_ordenada[2])
  }
  
  print("Mi vector de entropías condicionales es el siguiente:")
  print(entropias_condicionales)
  
  # Resuelvo el sistema de ecuaciones lineales para encontrar mis bi
  bi <- solve(matriz_probabilidades, entropias_condicionales)
  print("Mi solución del sistema de ecuaciones, es decir, mis bi:")
  print(bi)
  
  # Calculo mi capacidad del canal
  capacidad_canal <- 0
  for (i in 1:ncol(matriz_probabilidades)) {
    capacidad_canal <- capacidad_canal + 2^(-bi[i])
  }
  capacidad_canal <- log2(capacidad_canal)
  print(paste("Mi capacidad del canal es ", capacidad_canal))
  
  # Calculo las probabilidades de mis símbolos de salida
  probabilidades_salida <- c(rep(0, nrow(matriz_probabilidades)))
  for (i in 1:ncol(matriz_probabilidades)) {
    probabilidades_salida[i] <- 2^(-bi[i]) / 2^capacidad_canal
  }
  print("Mis probabilidades de los símbolos de salida son: ")
  print(probabilidades_salida)
  
  # Resuelvo el sistema de ecuaciones lineales transpuesto para encontrar mis Ai
  probabilidades_entrada <- solve(t(matriz_probabilidades), probabilidades_salida)
  print("Mis probabilidades de los símbolos de entrada son: ")
  print(probabilidades_entrada)
  
  # Compruebo que la suma de mis probabilidades de entrada es 1
  suma_probabilidades <- sum(probabilidades_entrada)
  print(paste("Compruebo que la suma de mis probabilidades es 1:", suma_probabilidades))
}

# Mi nueva matriz de probabilidades de ejemplo 
matriz_ejemplo <- matrix(c(0.3, 0.1, 0.6, 0.2, 0.5, 0.3, 0.4, 0.2, 0.4), ncol = 3, byrow = TRUE)

# Llamo a mi función con la matriz de ejemplo
calcular_mi_capacidad(matriz_ejemplo)

