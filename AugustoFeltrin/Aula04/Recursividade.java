package AugustoFeltrin.Aula04;

public class Recursividade {
	public static long fatorial(int n) {
		if(n <= 1) {
			return 1;
		}
		else {
			return n * fatorial(n -1);
		}
	}
	
	public static long fibonacci(int n) {
		if(n <= 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
	
	public static void main(String args[]) {
		int num = 5;
		long resultadoFatorial = fatorial(num);
		long resultadoFibonacci = fibonacci(num);
		System.out.println("O fatorial do número " + num + ": " + resultadoFatorial);
		System.out.println("O fibonacci do número " + num + ": " + resultadoFibonacci);
	}
}

