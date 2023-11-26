
# Función para calcular la suma de valores en una columna específica
sumar_valores <- function(matriz_probabilidades, filas, columna) {
  suma <- 0
  for (i in 1:filas) {
    suma <- suma + matriz_probabilidades[i, columna]
  }
  return(suma)
}

# Función para calcular la matriz de probabilidades condicionales p(Ai/Bj)
calcular_prob_condicional <- function(matriz_probabilidades, columnas, filas) {
  resultado <- numeric()  # Crear un vector vacío para almacenar los valores calculados
  for (i in 1:filas) {
    for (j in 1:columnas) {
      valor <- matriz_probabilidades[i, j] / sumar_valores(matriz_probabilidades, filas, j)
      resultado <- c(resultado, valor)
    }
  }
  matriz_resultado <- matrix(resultado, nrow = filas, ncol = columnas, byrow = FALSE)
  cat("Matriz de probabilidades condicionales p(Evento A_i dado Evento B_j):\n")
  print(matriz_resultado)
  return(matriz_resultado)
}

# Función para verificar si un vector tiene probabilidades equiprobables
es_equiprobable <- function(probabilidades) {
  for (i in 2:length(probabilidades)) {
    if (probabilidades[1] != probabilidades[i]) {
      return(FALSE)
    }
  }
  return(TRUE)
}

# Función principal para calcular las probabilidades compuestas y encontrar las decodificaciones mínimas
calcular_prob_compuestas <- function(probabilidades_A, matriz_probabilidades) {
  if (length(probabilidades_A) != nrow(matriz_probabilidades)) {
    return("Error al introducir los datos")
  }
  for (i in 1:nrow(matriz_probabilidades)) {
    for (j in 1:ncol(matriz_probabilidades)) {
      matriz_probabilidades[i, j] = matriz_probabilidades[i, j] * probabilidades_A[i]
    }
  }
  cat("Matriz de probabilidades compuestas:\n")
  print(matriz_probabilidades)
  cat("---------------------\n")
  resultado <- calcular_prob_condicional(matriz_probabilidades, ncol(matriz_probabilidades), nrow(matriz_probabilidades))
  cat("---------------------\n")
  decodificaciones <- apply(resultado, 1, max)
  cat("Decodificaciones mínimas:\n")
  return(decodificaciones)
}

# Función para encontrar los valores máximos de p(Bj/Ai) en la matriz de probabilidades condicionales
encontrar_max_verosimilitud <- function(matriz_prob_condicional) {
  maximos <- apply(matriz_prob_condicional, 2, max)
  cat("Valores para los cuales p(Bj/Ai) es máxima:\n")
  print(maximos)
}

# Nueva matriz de probabilidades condicionales
matriz_probabilidades_condicionales <- matrix(c(0.4, 0.2, 0.3, 0.1, 0.2, 0.7), nrow = 2, ncol = 3)

# Nuevos vectores de probabilidades p(A1) y p(A2)
probabilidades_A1 <- c(0.6, 0.4)
probabilidades_A2 <- c(0.8, 0.2)

# Llamadas a las funciones
calcular_prob_compuestas(probabilidades_A1, matriz_probabilidades_condicionales)
encontrar_max_verosimilitud(matriz_probabilidades_condicionales)
calcular_prob_compuestas(probabilidades_A2, matriz_probabilidades_condicionales)
encontrar_max_verosimilitud(matriz_probabilidades_condicionales)

