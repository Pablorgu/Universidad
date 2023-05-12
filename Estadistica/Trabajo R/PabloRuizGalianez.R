#EJERCICIO 1
#Configuro el directorio de trabajo
setwd("~/UNIV AUX/Universidad/Estadistica/Trabajo R")

#Primero empiezo importando el archivo pero usando la libreria readr y con barra baja en lugar
#de punto para que devuelva un tibble en vez de un data frame, asignare tipos a las columnas ya que cada una
#representa un tipo de datos distinto, por ejemplo las de ingresos, sexo o estudios que representan variables categóricas
library(readr)
library(tidyverse)
library(purrr)
datos <- read_csv("18608.csv", col_types=cols(.default=col_double(), sexo=col_factor(),
                                              dietaEsp=col_factor(), nivEstPad=col_factor(),
                                              nivEstudios=col_factor(), nivIngresos=col_factor()))

#EJERCICIO 2
#Ahora cargare la operacion para calcular el IMC en la variable, la formula del imc es peso en kg dividido entre la altura en metros al cuadrado,
#el peso y la altura en este caso seran variables dependientes mientras que el resto seran independientes
calc_imc<- function(peso, altura){
  imc<- peso/altura^2
}
datos <- datos %>% mutate(IMC=calc_imc(datos$peso, datos$altura))

#EJERCICIO 3
#Ahora tratare de eliminar las filas en las que nos falte algun dato
datos <- na.omit(datos)

#EJERCICIO 4
#Primero para quedarme con las variables numéricas aprovechare la función is.numeric con la función keep
##lo guardo en la variable datos numericos y con un map le aplico la funcion mean a todo el dataframe
datosNumericos <- keep(datos, is.numeric)
datosMedia<- map_dbl(datosNumericos, mean)

#Para calcular la desviacion tipica usare la funcion sd que que calcula la desviacion estandar con un map
#Debajo de la desviacion tipica tambien le he aplicado la correcion de bessel debido a que la desviacion estandar por si sola
#tiende a subestimar la desviacion estandar de la poblacion de la que se extrajo la muestra.

desvTipica <- map_dbl(datosNumericos, sd)
desvTipicasBessel <- map_dbl(datosNumericos, function(x) sqrt(sum((x-mean(x))^2) / (length(x)-1)))

#EJERCICIO 5
#Lo primero que hare sera extraer las variables independientes
VariablesInd <- names(datos[3:14])

#Una vez los tengo usare lm y summary para obtener los coeficientes de regresion que cuantifican la relacion entre la variable dependiente e independiente
coeficienteReg<-function(df, y, x) {
  modelo<- lm(y ~ x, df)
  summary(modelo)$coefficients[2]
}

#El siguiente paso sera calcular el coeficiente de determinación que nos indica cuanto depende la variable dependiente de la variable independiente
coeficienteDet <- function(df, y, x) {
  modelo<- lm(y ~ x, df)
  summary(modelo)$r.squared
}

#Ahora calculare el coeficiente de regresión entre la variable de respuesta IMC
#y cada una de las variables predictoras
coeficientesRegIMC <- map_dbl(VariablesInd,~ coeficienteReg(datos, datos$IMC, datos[[.x]]))

#Y hare lo mismo con el coeficiente de determinacion
coeficientesDetIMC <- map_dbl(VariablesInd,~ coeficienteDet(datos, datos$IMC, datos[[.x]]))

#EJERCICIO 6
# Para empezar creare una funcion que calcule el ajuste lineal entre la variable dependiente y la independiente
ajusteLinear <- function(df, y, x) {
  list(x = x, y = y, mod = lm(str_c(y, "~", x), df))
}

# Dibujaremos los modelos teniendo en cuenta que si son datos numericos usare un plot que unira los datos con una linea verde
# y en caso contrario un boxplot
dir.create("Graficos")
dibujarModelos <- function(mod) {
  jpeg(str_c("./Graficos/", mod$x, ".jpeg"))
  varx <- mod$x
  vary <- mod$y
  
  if (is.numeric(datos[[varx]])) {
    plot(datos[[varx]], datos[[vary]], xlab = varx, ylab = vary)
    abline(mod$mod, col = "green")
  } else {
    boxplot(formula = datos[[vary]] ~ datos[[varx]], xlab = varx, ylab = vary)
  }
  dev.off()
}

#Ahora generare los modelos de regresion lineal ayudandome de las funciones que he creado
modelos <- map(names(datos), ~ ajusteLinear(datos, "IMC", .x))

# Ya solo me queda generar los graficos usando walk
walk(modelos, dibujarModelos)

#EJERCICIO 7
#Usare la forma que vemos en los apuntes para separar los sets creando una funcion que tiene como parametros los tamaños de los sets/conjuntos
separarSets <- function(df, p1, p2) {
  rDf <- 1:nrow(df)
  rTrain <- sample(rDf, p1 * length(rDf))
  rResto  <- setdiff(rDf, rTrain)
  rTest <- sample(rResto, p2*length(rDf))
  rValido <- setdiff(rResto, rTest)
  
  list(train=df[rTrain,], test=df[rTest,], valido=df[rValido,])  
}

setsSeparados <- separarSets(datos,.6,.2)

#EJERCICIO 8
#Para seleccionar la variable que mejor explica el IMC necesitaré ayudarme de unas cuantas funciones
# Esta función calcula el coeficiente de determinación ajustado R2 para un modelo de regresión lineal.
calcR2 <- function(df, mod, y) {
  MSE <- mean((df[[y]] - predict.lm(mod, df)) ^ 2)
  varY <- mean(df[[y]] ^ 2) - mean(df[[y]]) ^ 2
  R2 <- 1 - MSE / varY
  ajR2 <- 1 - (1- R2) * (nrow(df) - 1) / (nrow(df) - mod$rank)
  ajR2
}
#Con esta funcion evaluare el modelo de regresión lineal utilizando el conjunto de datos de entrenamiento y el otro de prueba.
calcModR2 <- function(dfTrain, dfTest, y, x) {
  mod <- ajusteLinear(dfTrain, y, x)
  calcR2(dfTest, mod$mod, y)
}
#Pasaré a utilizar la función map_dbl para aplicar la función calcModR2 que acabo de crear a cada variable predictora del vector VariablesInd.
AjusteR2 <- VariablesInd %>%
  map_dbl(calcModR2,dfTrain=setsSeparados$train,dfTest=setsSeparados$test,y="IMC")

#Ahora calcularé la variable predictora que genera el coeficiente de determinación ajustado R2 más alto.
x <- which.max(AjusteR2)
mejorVar <- VariablesInd[x]


#EJERCICIO 9
encontrarMejorAjuste <- function(dfTrain, dfTest, varPos) {
  bestVars <- character(0)
  aR2      <- 0
  
  repeat {
    aR2v <- map_dbl(varPos, ~calcModR2(dfTrain, dfTest, "IMC", c(bestVars, .)))
    i    <- which.max(aR2v)
    aR2M <- aR2v[i]
    if (aR2M <= aR2) break
    
    cat(sprintf("%1.4f %s\n", aR2M, varPos[i]))
    aR2 <- aR2M
    bestVars <- c(bestVars, varPos[i])
    varPos   <- varPos[-i]
  }
  
  mod <- ajusteLinear(dfTrain, "IMC", bestVars)
  
  list(vars=bestVars, mod=mod)
}
# Llamo a la función encontrarMejorAjuste para obtener el modelo que mejor explica el IMC
# mejorAjuste es una lista que contiene las variables predictoras seleccionadas y el modelo ajustado
mejorAjuste <- encontrarMejorAjuste(setsSeparados$train, setsSeparados$test, VariablesInd)


#EJERCICIO 10
# Se extrae el modelo ajustado de la lista mejorAjuste
mejorMod <- mejorAjuste$mod$mod
# Calculo el valor de R2 ajustado para el conjunto de validación utilizando el modelo ajustado
calcR2(setsSeparados$valid, mejorMod, "IMC")


#EJERCICIO 11
#Empezare importando el archivo que contiene el dataframe eval
dfEval <- read_csv("eval.csv")
#Ahora tendre que deducir el IMC
dfEval["IMC"] <- predict.lm(mejorMod, dfEval)
#Finalmente dedicire la variable de peso con la de IMC y altura
dfEval["Peso"] <- dfEval$IMC*dfEval$altura^2

#Por ultimo ya solo tengo que guardar este archivo
write.csv(dfEval, "evalX.csv", row.names = FALSE)












