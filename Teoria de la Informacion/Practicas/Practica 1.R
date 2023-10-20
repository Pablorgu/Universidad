 ##PRACTICA 1
##A1. La representación gráfica de la función entropía para dos resultados posibles.

muestra <- runif(100, min=0, max=1)
##Creo un array de 100 numeros aleatorios que usaré como muestra

H <- -((muestra * log2(muestra)) + ((1 - muestra) * log2(1 - muestra)))
##Calculo la entropia de la muestra y de su complementario.

plot(muestra, H, col = "blue", pch = 16, xlab = "p", ylab = "H", main = "Gráfico de Entropía")
#Creo el gráfico de dispersión

parabola <- function(muestra) -(muestra * log2(muestra) + (1 - muestra) * log2(1 - muestra))
curve(parabola, col = "red", add = TRUE)
##Agrega una linea que une los puntos siguiendo la forma de parabola

##A2.La función entropía (en general).

calcular_entropia_general<-function(prob){
  -sum(prob*log2(prob))
}
##Creo una funcion que aplica la formula de la entropia a todos los valores

calcular_entropia_general(c(0.5,0.5))
calcular_entropia_general(c(0.4,0.1,0.5))



##PRACTICA 1 - PARTE B
entropia_compuesta <- function(vector_x, vector_y) {
  
  if(sum(vector_x)!=1 | sum(vector_x<0 | vector_x>1)>0) return(NaN)
  if(sum(vector_y)!=1 | sum(vector_y<0 | vector_y>1)>0) return(NaN) 
  # Verifico si los vectores tienen la misma longitud y cumplen las condiciones
  
  resultado = 0
  ##Creo una variable a 0 para sumar al recorrer los bucles
  
  
   for(i in 1:length(vector_x)){ 
     for(j in 1: length(vector_y)){
        resultado<- resultado + (vector_x[i]*vector_y[j]*log2(1/(vector_x[i]*vector_y[j])))
     }
   } 
  #Aplico la formula de la entropía usando bucles para resolver los sumatorios
  
  return(resultado)
  # Devuelvo el resultado
}
# Ejemplo de uso
entropia_compuesta(c(0.4,0.1,0.5),c(0.5,0.5))


##B2. Entropía condicionada.
entropia_condicionada<-function(vector_x,vector_y){
  if(sum(vector_x)!=1 | sum(vector_x<0 | vector_x>1)>0) return(NaN)
  if(sum(vector_y)!=1 | sum(vector_y<0 | vector_y>1)>0) return(NaN)
  return(entropia_compuesta(vector_x,vector_y)-calcular_entropia_general(vector_x))
  ##Como la entropia condicionada es la conjunta menos la normal puedo usar lo que he hecho anteriormente para conseguirla
}
# Ejemplo de uso
entropia_condicionada(c(0.4,0.1,0.5),c(0.5,0.5)) 


##B3. Información mutua.
  informacion_mutua<-function(vector_x,vector_y){
     if(sum(vector_x)!=1 | sum(vector_x<0 | vector_x>1)>0) return(NaN)
     if(sum(vector_y)!=1 | sum(vector_y<0 | vector_y>1)>0) return(NaN)
     return(calcular_entropia_general(vector_x) - entropia_condicionada(vector_x,vector_y)) 
  }
##Uso la entropia general y la condicionada para calcular la informacion mutua
##Ejemplo de uso
informacion_mutua(c(0.25,0.25,0.25,0.25),c(1,0,0,0)) 

    

