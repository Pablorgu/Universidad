import java.util.Arrays;

public class Analizador {
	
	/* 
	 * NOTA IMPORTANTE
	 * 
	 * Esta clase se proporciona solamente para ilustrar el formato de
	 * salida que deberia tener la solucion a este ejericio.
	 * Esta clase debe modificarse completamente para cumplir 
	 * mínimamente los requisitos de esta practica.
	 * Notese que ni siquiera esta completa......
	 */
	
	public static String masCercano(double ratio) {
			if (ratio < 1.5) {                      // aprox 1.0
				return "1";
			} else if (1 <= ratio && ratio < 3.0) { // aprox 2.0
				return "N";
			} else if (3 <= ratio && ratio < 6.0) { // aprox 4.0
				return "N2";
			} else if (6 <= ratio && ratio < 10.0) { // aprox 8.0
				return "N3";
			/*} else if (x <= ratio && ratio < x) { // aprox x
				return "2N";
			} else if (x <= ratio && ratio < x) { // aprox x
				return "LOGN";
			} else if (x <= ratio && ratio < x) { // aprox x
				return "NLOG";*/
			} else { 								 // otras
				return "NF";
			}
	}	
	
	public static void main(String arg[]) {
		int [] n1 = {10000, 20000, 40000};
		int [] n2 = {2000, 4000, 8000};
		
		long [] t1 = new long[n1.length];
		long [] t2 = new long[n1.length];
		
		double [] ratio = new double [n1.length];
		Temporizador t = new Temporizador();
		
		for (int nTam = 0; nTam < n1.length; nTam++) {
			t.reiniciar();
			t.iniciar();
			Algoritmo.f(n1[nTam]);
			t.parar();
			t1[nTam] = t.tiempoPasado();
			
			t2[nTam] = cuadratica(n1[nTam]);
			
			ratio[nTam] = (double)t2[nTam]/t1[nTam];
		}	
		
		System.out.println(Arrays.toString(ratio));
		System.out.println(masCercano(ratio[ratio.length-1]));
	}
	
	private static long lineal (int n) {
		//T(n) = n
		return n;
	}
	
	private static long cuadratica (int n) {
		//T(n) = n^2
		return n*n;
	}
	
	private static long cubica (int n) {
		//T(n) = n^3
		return n*n*n;
	}
	
	private static long logn (int n) {
		//T(n) = logn
		return (long) (Math.log(n)/Math.log(2));
	}
	
	private static long nlogn (int n) {
		//T(n) = nlogn
		return (long) (n*logn(n));
	}
	
	private static long potencia (int n) {
		//T(n) = 2^n
		return (long) Math.pow(2, n);
	}
}
