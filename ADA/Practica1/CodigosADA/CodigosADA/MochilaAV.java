

import java.util.Arrays;

/**
 * 
 * @author ***** Indicar aqui el autor de la practica *******
 *
 */

public class MochilaAV extends Mochila {
	
	static class item implements Comparable<item> {
		
		int peso, valor, indice, unidades;
		double densidad;
		
		public item(int peso, int valor, int unidades, int i){
			
			this.peso = peso;
			this.valor = valor;
			this.indice = i;
			this.unidades= unidades;
	
			densidad = (double) this.valor/(double) this.peso;
			
		}
	
		public int compareTo(item i2) {
			
			if((densidad == i2.densidad) && (indice == i2.indice)) {
	
				return 0;
	
			}else if((densidad == i2.densidad) && (indice > i2.indice)) {
	
				return 1;
	
			}else if(densidad > i2.densidad) {
	
				return - 1;
	
			} else {
	
				return 1;
			}
		}
		
	}
	
	public SolucionMochila resolver(ProblemaMochila pm) {
		
		int[] q = pm.getUnidades();
		int[] w = pm.getPesos();
		int[] v = pm.getValores();
		int W = pm.getPesoMaximo();
		int n= w.length;
		
		item[] it = new item[n];
		int[] sol= new int[n];
		
		
		
		for(int i = 0; i < n; i++){ //almacenamos items
			
			it[i] = new item(w[i], v[i], q[i], i);
			
		}
		
		Arrays.sort(it);
		
		int pesoTotal = 0;
		int valorTotal = 0;
		
		int i = 0;
		int pesoMax = W;
		
		while(i < n && pesoTotal < pesoMax) {
			
			if(it[i].peso + pesoTotal <= pesoMax && it[i].unidades >= 1) {
				
				sol[it[i].indice]++;
				pesoTotal += it[i].peso;
				valorTotal += it[i].valor;
				it[i].unidades--;
				
			} else {
				
				i++;
				
			}
		}
		
		
		SolucionMochila sm= new SolucionMochila(sol, pesoTotal, valorTotal);
		
		return sm;
		
	}
	
}
