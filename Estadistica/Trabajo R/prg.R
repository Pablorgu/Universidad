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
#Para empezar creare una funcion que calcule el ajuste lineal entre la variable dependiente y la independiente
AjusteLinear <- function(df, y, x) {
  list(x=x, y=y, mod=lm(str_c(y, "~", x), df))
}
