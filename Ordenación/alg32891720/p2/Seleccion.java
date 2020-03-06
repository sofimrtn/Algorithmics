package alg32891720.p2;

import alg32891720.p2.Vector;

/** Este programa sirve para ordenar n elementos
	con un algoritmo de los "malos" (cuadrático)·
	es la SELECCION
 */
public class Seleccion extends Vector
{
	public Seleccion(int nElementos) {
		super(nElementos);
	}
	

	/**
	 * Ordenación por selección
	 */

	@Override
	public void ordenar() {
		int n = elements.length;
		int posMin;
		for(int i=0; i<n-1;i++){
			posMin = i;
			for(int j=i+1; j<n; j++){
				if(elements[j]<elements[posMin]){
					posMin=j;
				}
			}
			intercambiar(i, posMin);
		}
	}  

	@Override
	public String getNombre() {		
		return "Selección";
	}  
} 
