import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class Ejercicio1 {
    public static void main(String[] args) {
        int [] tamEntrada = {1,2,3,4,5,10,20,30};
        Temporizador reloj = new Temporizador();
        long[]tiempos1 = new long[tamEntrada.length];
        long[]tiempos2 = new long[tamEntrada.length];
        try(PrintWriter fich1 = new PrintWriter("algoritmo1.csv");
            PrintWriter fich2 = new PrintWriter("algoritmo2.csv"); ){
            fich1.print("Tam,Tiempo");
            fich2.print("Tam,Tiempo");

            for (int i = 0; i < tamEntrada.length; i++) {
                reloj.reiniciar();
                reloj.iniciar();
                algoritmo1(tamEntrada[1]);
                reloj.parar();
                tiempos1[i] = reloj.tiempoPasado();
                fich1.print(tamEntrada[i]); //fich1.prinln(tamEntrada[i]+","+tiempos[1])
                fich1.print(",");
                fich1.println(tiempos1[i]);


                //Preparar datos entrada para algoritmo 2
                int[] datos = new int[tamEntrada[i]];
                Random r = new Random();
                for (int j = 0; j < datos.length; j++) {
                    datos[j] = r.nextInt();
                }
                System.out.println(Arrays.toString(datos));
                //algoritmo2
                reloj.reiniciar();
                reloj.iniciar();
                algoritmo2(datos);
                reloj.parar();
                tiempos2[i] = reloj.tiempoPasado();
                fich2.print(tamEntrada[i]); //fich1.prinln(tamEntrada[i]+","+tiempos[i])
                fich2.print(",");
                fich2.println(tiempos2[i]);

            }
            System.out.println(Arrays.toString(tiempos1));
            System.out.println(Arrays.toString(tiempos2));
        }catch (FileNotFoundException e) {
            System.out.println("El fichero no se encuentra");
        }
    }
    public static int algoritmo1(int n){
        //n >0
        if (n<=2) return 1;
        else return algoritmo1(n-1) + algoritmo1(n-2);
    }

    private static void algoritmo2(int [] a) {
        for(int i = 0; i < a.length; i ++) {
            int suma = 0;
            for (int j = 0; j < a.length; j++ ) {
                suma += a[j];
            }
            a[i] = suma;
        }
    }
}
