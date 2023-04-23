#Primero empiezo importando el archivo pero usando la libreria readr y con barra baja en lugar
#de punto para que devuelva un tibble en vez de un data frame
library(readr)
datos <- read_csv("18608.csv")

#Ahora cargare la operacion para calcular el IMC en la variable
