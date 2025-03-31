public class Analizador {

    private static int numIteraciones = 5;
    private static Temporizador temporizador = new Temporizador();
    
    public static void main(String[] args) {
    long n1 = 10;
    long n2 = 20;
    double ratio = mediaIntentos(n2)/mediaIntentos(n1);
    
    if (ratio>1000){
        
        if (ratio<3000){
            
            System.out.println("2N");
            
        } else{
            
            System.out.println("NF");
        }
    
    } else {

        n1 = 10000;
        n2 = 20000;
        ratio = mediaIntentos(n2)/mediaIntentos(n1);
        if (6 <= ratio && ratio < 10.0){
            
            System.out.println("N3");

        } else if (3.3 <= ratio && ratio < 6.0){
            
            System.out.println("N2");

        } else if (3<=ratio && ratio<3.3){
            
            System.out.println("NLOGN");
        
        } else {

            n1 =1000;
            n2 =1000000;
            ratio=mediaIntentos(n2)/mediaIntentos(n1);
            if (ratio > 90){
                
                System.out.println("N");

            } else if (ratio<=1.005) {
                
                System.out.println("1");

            }else {

                System.out.println("LOGN");

            }
        }
    }

}
    
    
    private static double mediaIntentos(long num) {
    
    int media=0;
    
    for (int i = 0 ; i<numIteraciones ; i++){ 
        
        temporizador.reiniciar(); 
        temporizador.iniciar(); 
        Algoritmo.f(num); 
        temporizador.parar();
        media += temporizador.tiempoPasado();

    }
    
    return media/(double)numIteraciones;

}

}
    