package AugustoFeltrin.Aula04;

public class ExercicioA {
	public static long multiplicacao(int n, int m) {
		if(m == 0) {
			return 0;
		} else if (m == 1){
			return n;
		} else {
			return n + multiplicacao(n, m - 1);
		}
	}
	
	public static void main(String args[]) {
		int multiplicando = 3;
		int multiplicador = 4;
		long resultado =  multiplicacao(multiplicando, multiplicador);
		System.out.println("Resultado da multiplicação de " + multiplicando + "x" + multiplicador + ": " + resultado);
	}
}
