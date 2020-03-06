package alg77777777.p12;

public class Bucle1 {

	public static long bucle1(int n)
	{
		long cont = 0; //1
		for (int i = 1; i <= n; i++)//O(n). Si fuera i<=2n sería 2O(n). Si fuera i+=n se ejecutaría n/2 y sería O(n) tmb.
			for (int j = 1; j <= n; j *= 2)
				cont++;
		return cont;//1
	}

	public static void main(String arg[]) {
		long t1, t2;
		int nVeces = Integer.parseInt(arg[0]);

		System.out.println("n\ttiempo\tcontador");
		for (int n = 8; n <= 100000; n *= 2) {
			long c = 0;
			t1 = System.currentTimeMillis();

			for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
				c += bucle1(n);
			}

			t2 = System.currentTimeMillis();

			System.out.println(n+"\t"+(t2-t1)+"\t"+c);

		} // for

	} // main
} // class