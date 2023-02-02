setwd("C:/Users/pablo/Desktop/Universidad/ADA")
tiempo1 <- read.csv("algoritmo1.csv")
tiempo2 <- read.csv("algoritmo2.csv")
tam <- unlist(tiempo1[1])
t1 <-  unlist(tiempo1[2])
t2 <-  unlist(tiempo2[2])
plot(tam, t2, type = "l", col = "red")
lines(tam, t1, col = "blue")
lines(tam, t2/t1,type = "l", col = "green")


f_n = tam;
f_n2 = tam^2 #tam+tam
f_logn= log(tam, base=2)
f_exp = 2^tam
plot(tam, t1/f_n2,type= "l")
plot(tam,t1/f_exp, type="l")
