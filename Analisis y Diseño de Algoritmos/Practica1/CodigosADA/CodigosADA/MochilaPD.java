

/**
 * 
 * @author ***** Jose A. Onieva *******
 *
 */

import java.util.ArrayList;
public class MochilaPD extends Mochila {
	
	@SuppressWarnings("unchecked")
	public SolucionMochila resolver(ProblemaMochila pm) {
		SolucionMochila sm=null;
		// A resolver por el alumno
		
		int f = pm.getUnidades().length + 1;//tam fila
		int c = pm.getPesoMaximo() + 1;//tam columna
		SolucionMochila[][] F = new SolucionMochila[f][c];//tabla solucion
		//int[] res = new int[pm.getUnidades().length];//vector solucion
		
		for (int i = 0; i < f; i++) {//se rellena la primera columna
			F[i][0] = new SolucionMochila(new int[pm.getUnidades().length], 0, 0);
		}
		
		for (int j = 1; j < c; j++) {//se rellena la primera fila
			F[0][j] = new SolucionMochila(new int[pm.getUnidades().length], 0, 0);
		}
		
		for (int i = 1; i < f; i++) {
			
			for (int j = 1; j < c; j++) {
				
				int w = pm.getPeso(i - 1);
				
				if (j < w) {//si no cabe se mantiene el valor de la celda superior
					
					SolucionMochila aux = F[i - 1][j];
					F[i][j] = new SolucionMochila((ArrayList<Integer>) aux.getSolucion().clone(), aux.getSumaPesos(), aux.getSumaValores());
					
				}else {
					
					int v = pm.getValor(i - 1);
					SolucionMochila max = F[i - 1][j];
					int ki = 0;
					for (int k = 1; k <= pm.getUnidad(i - 1); k++) {
						
						if (j >= k * w) {//si cabe se elige el de mayor valor
							
							SolucionMochila aux = F[i - 1][j - k * w];
							
							if (aux.sumaValores + k * v > max.sumaValores) {
								max = aux;
								ki = k;
							
							}
							
						}
						
					}
					
					ArrayList<Integer> vectorSol = (ArrayList<Integer>) max.getSolucion().clone();
					vectorSol.set(i - 1, ki);
					F[i][j] = new SolucionMochila(vectorSol, max.getSumaPesos() + ki * w, max.getSumaValores() + ki * v);
				}
			
			}
			
		}
		
		f--;
		c--;
		sm = F[f][c];
		
		return sm;
	}
	
}
