package alg77777777.p32;

/* Esta clase simula el algoritmo que sigue en la actualiodad el TIO GILITO y 
 * que nos reta para que se lo mejoremos gratuitamente (no piensa pagarnos nada el muy usurero) */
public class Gilito2
{

	static int []monedas;  // peso en gramos de las n monedas
	static int watH;       // energia media consumida(watioshora=wh) 

	/* Pesa en el platillo izquierdo las monedas entre las posiciones izqMin..izqMax
	   Pesa en el platillo derecho las monedas entre las posiciones derMin..derMax
	   Devuelve 1 si pesa menos la izquierda, 2 si la derecha y 3 si igual    */     
	public static int balanza (int[] monedas,int izqMin,int izqMax,int derMin,int derMax)
	{
		watH++;           // 1 wh consumido   
		int pIzq=0;      // peso platillo izquierdo
		for (int i=izqMin;i<=izqMax;i++)
			pIzq=pIzq+monedas[i];

		int pDer=0;      // peso platillo derecho   
		for (int i=derMin;i<=derMax;i++)
			pDer=pDer+monedas[i];
		if (pIzq<pDer) return 1;
		if (pIzq>pDer) return 2;
		return 3;
	}

	/* Algoritmo divide y vencerás para minimizar la energía gastada por
	Gilito. En este caso se va diviendo recursivamente el montón de monedas
	en dos y cogiendo siempre el que menos pesa, que es el que tendría la moneda
	falsa. */
	public static int gilito2(int[]monedas){	
		return divAndConquer(monedas, 0 , monedas.length-1);
	}

	public static int divAndConquer(int[] monedas, int inf, int sup){
		
		int res = 0;
		if(sup-inf == 1){ //Caso Base
			res=balanza(monedas, inf, inf, sup, sup);
			if(res==1) res = inf;
			else if(res==2) res = sup;
			else if(res==3) throw new IllegalArgumentException("Algo pasó");
		} else {
			int medio=(inf+sup)/2; //dividimos en dos el problema.
			int peso= balanza(monedas, inf, medio, medio+1, sup); //pesamos los dos montones
			if(peso==1){ //si el de la derecha pesa más, avanzamos con el de la izquierda. 
				res = divAndConquer(monedas, inf, medio);
			}else if (peso==2){ //si el de la izquierda pesa más, avanzamos con el de la derecha.
				res = divAndConquer(monedas, medio+1, sup);
			}
		}
		return res;
	}
	
	public static void main (String arg[])
	{
		//int n=Integer.parseInt(arg[0]);//numero de monedas=tama�o del problema
		int n = 16;
		monedas=new int[n];
		int posicion;
		//vamos a simular los n casos posibles - moneda falsa en cada posición
		for (int i=0;i<n;i++)
		{ 
			for (int j=0;j<n;j++) monedas[j]=1000; //peso moneda buena
			monedas[i]=999; //moneda falsa limada para estafar al Gilito  
			posicion=gilito2(monedas);
			System.out.println ("POSICION MONEDA FALSA="+posicion);
		}
		System.out.println("MONEDAS= "+n+"***ENERGIA MEDIA CONSUMIDA= "+watH/n+" WattiosHora");
	} 
}