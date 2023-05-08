#Configuro el directorio de trabajo
setwd("~/UNIV AUX/Universidad/Estadistica/Trabajo R")
#Primero empiezo importando el archivo pero usando la libreria readr y con barra baja en lugar
#de punto para que devuelva un tibble en vez de un data frame, asignare tipos a las columnas ya que cada una
#representa un tipo de datos distinto, por ejemplo las de ingresos, sexo o estudios que representan variables categóricas
library(readr)
library(tidyverse)
datos <- read_csv("18608.csv", col_types=cols(.default=col_double(), sexo=col_factor(),
                                              dietaEsp=col_factor(), nivEstPad=col_factor(),
                                              nivEstudios=col_factor(), nivIngresos=col_factor()))

#Ahora cargare la operacion para calcular el IMC en la variable, la formula del imc es peso en kg dividido entre la altura en metros al cuadrado,
#el peso y la altura en este caso seran variables dependientes mientras que el resto seran independientes
calc_imc<- function(peso, altura){
  imc<- peso/altura^2
}
datos <- datos %>% mutate(IMC=calc_imc(datos$peso, datos$altura))
