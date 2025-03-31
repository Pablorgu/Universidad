import java.util.Arrays;
import java.util.Iterator;

/**
 * 
 * @author ***** Jose A. Onieva ******* Asumimos que: a) Todos los items tienen
 *         un valor >=1 b) W>0
 */

public class MochilaFB extends Mochila {

	
	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm=null;
		// A resolver por el alumno
		
		int[] q = pm.getUnidades();
		int n = q.length;
		int[] vectorSol = new int[n];
		int[] temp = new int[n];
		int valorSol = 0;
		int pesoSol = 0;
		
		boolean combPosibles = true;
		
		while(combPosibles) {
			
			boolean moverse = true;
			
			int i = 0;
			while(i < n && moverse) {
				
				int cantidad = temp[i] + 1;
				
				if (cantidad > q[i]) {
					
					cantidad = 0;				
					combPosibles = i != n - 1;
					
				}else {
					
					moverse = false;
					
				}
				
				temp[i] = cantidad;
				i ++;
			}
			
			int valor = pm.sumaValores(temp);
			int peso = pm.sumaPesos(temp);
			
			if (valor > valorSol && peso <= pm.pesoMaximo) {
				
				vectorSol = Arrays.copyOf(temp, n);
				valorSol = valor;
				pesoSol = peso;
				
			}
		}
		
		sm = new SolucionMochila(vectorSol, pesoSol, valorSol);
				
		return sm;
		
	}

}
