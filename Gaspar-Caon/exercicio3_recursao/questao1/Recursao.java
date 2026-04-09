/*
GASPAR CAON

Lista de exercícios sobre recursão

Programa compilado na versão:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

//import java.util.ArrayList;
//import java.util.Comparator;

public class Recursao {
	
	public static void main(String[] args) {

		Recursao programa = new Recursao();
		long t0, tf;

		System.out.println("\nFatorial:\n");
		for (int i=0; i<11; i++) {
			System.out.println("	" + i + "! = " + programa.fatorial(i));
		}

		System.out.println("\nFibonacci:\n");
		for (int i=0; i<11; i++) {
			System.out.println("	" + i + "-ésimo termo = " + programa.fibonacci(i));
		}

		/*t0 = System.currentTimeMillis();
		System.out.println(programa.fibonacci(10));
		tf = System.currentTimeMillis();
		System.out.println(tf-t0);*/

		System.out.println("\nPotências de 2:\n");
		for (int i=0; i<11; i++) {
			System.out.println("	2^" + i + " = " + programa.potencia_2(i));
		}
		
		System.out.println("\nPotências de a = 3:\n");
		for (int i=0; i<11; i++) {
			System.out.println("	3^" + i + " = " + programa.potencia_a(3,i));
		}
		
		System.out.println("\nPotências de a = 1.5:\n");
		for (int i=0; i<11; i++) {
			System.out.println("	1.5^" + i + " = " + programa.potencia_a(1.5,i));
		}
		
		// Propagação de erros vão aparecer aqui por causa da representação binária do número -0.9;
		// Sugestão da IA: utilizar a classe BigDecimal, ao custo de mais processamento;
		System.out.println("\nPotências de a = -0.9:\n");
		for (int i=0; i<11; i++) {
			System.out.println("	-0.9^" + i + " = " + programa.potencia_a(-0.9,i));
		}
		
		System.out.println("\nSoma iterada por 10 vezes de a = 2^n :\n");
		for (int i=1; i<11; i++) {
			System.out.println("	n = " + i + "; soma = " + programa.somaIterada(2,i));
		}
		
		System.out.println("\nFunção específica: 3 + 2*f(n-1)\n");
		for (int i=0; i<11; i++) {
			System.out.println("	n = " + i + "; f(" + i + ") = " + programa.algumaFuncao(i));
		}

	}
	
	  /////////////////////////////
	 // DECLARAÇÃO DOS MÉTODOS: //
	/////////////////////////////

	// Retorna n!
	public int fatorial(int n) {
		
		int resultado = 1;
		if (n>1) {
			resultado = n * fatorial(n-1);
		}
		return resultado;
	}

	// Retorna o n-ésimo termo da sequência de Fibonacci (existe o 0-ésimo termo)
	public int fibonacci(int n) {

		if (n<=1) {
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}

	// Retorna o n-ésimo termo da sequência de Fibonacci (existe o 0-ésimo termo)
	public int fibonacci_alt(int n) {

		if (n<=1) return n;

		int[] serie = new int[n+1];
		serie[0] = 0;
		serie[1] = 1;
		for (int i=2; i<(n+1); i++) {
			serie[i] = serie[i-1] + serie[i-2];
		}

		return serie[n];
	}

	// Retorna 2^n
	public int potencia_2(int n) {

		if (n==0) return 1;
		return 2 * potencia_2(n-1);
	}
	
	// Retorna a^n
	public double potencia_a(double a, int n) {

		if (n==0) return 1;
		return a * potencia_a(a, n-1);
	}
	
	// Retorna a+a+a+a+...
	public double somaIterada(double a, int n) {
	
		if (n==0) return 0;
		return Math.pow(a,n) + somaIterada(a, n-1);
	}
	
	// Retorna valor de uma função específica
	public int algumaFuncao(int n) {
		
		if (n==0) return 3;
		return 3 + 2*algumaFuncao(n-1);
	}
}
