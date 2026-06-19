package Main;

public class yippity {

	public static long fatorial(int n) {
			
		long resultado = 1;
		if (n > 1) {
			
			resultado = n * fatorial(n - 1);
			
		}
		return resultado;
	}
	
	public static long somas(int n, int m) {
		
		
		if (m == 0) {
			return 0;
		}
			return n + somas(n, m - 1);
			
		
		
	}
	
	public static void main(String[] args) {
		
		fatorial(5);
		somas(3, 4);
		System.out.println(fatorial(5));
		System.out.println(somas(3, 4));
		
	}
}