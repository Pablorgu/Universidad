import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] a= {1,2,2,3,0,5,10};
        System.out.println(tieneCero(a));
    }

    public static boolean buscarSuma(int[] a, int x) {
        int i = 0;
        int j = a.length-1;
        boolean encontrado = false;
        while(!encontrado && i!=j) {
            if(a[i]+a[j]>x){
                j--;
            } else if(a[i]+a[j]<x) {
                i++;
            }else{
                encontrado = true;
            }
        }
        return encontrado;
    }

    //Relacion 2

    //1a
    public static boolean tieneCero(int[] a) {
        boolean encontrado = false;
        for (int i = 0; i < a.length && !encontrado; i++) {
            if(a[i]==0){
                encontrado = true;
            }
        }
        return encontrado;
    }






