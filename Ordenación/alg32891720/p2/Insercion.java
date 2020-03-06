package alg32891720.p2 ;

import alg32891720.p2.Vector;

/** Este programa sirve para ordenar n elementos
	con un algoritmo de los "malos" (cuadrático)· 
	Es la INSERCIÓN DIRECTA
 */
public class Insercion extends Vector
{
	
	public Insercion(int nElementos) {
		super(nElementos);
	}

	/**
	 * Ordenación por inserción directa
	 */

	@Override
	public void ordenar() {
		int j;
		int pivote;
		for(int i=1; i<elements.length; i++){
			pivote=elements[i];
			j=i-1;

			while (j>=0 && pivote<elements[j]){
				elements[j+1] = elements[j];
				j--;
			}

			elements[j+1] = pivote;
		}
	} 

	@Override
	public String getNombre() {
		return "Inserción directa";
	} 
} 
