package aula4.algoritmos.aula;

public class AlgoritmosAula {
    public static int fatorial(int n) {
        return n == 0 ? 1 : n * fatorial(n - 1);
    }

    public static int fibonacci(int n) {
        IO.println("Entrando em fibonacci(" + n + ")");
        var resultado = n <= 1 ? n : fibonacci(n - 1) + fibonacci(n - 2);
        IO.println("Saindo de fibonacci(" + n + ") = " + resultado);
        return resultado;
    }

    public static int potencia(int base, int expoente) {
        if(expoente == 0) return 1;
        return base * potencia(base, expoente - 1);
    }

    public static int somatorio(int[] a, int n) {
        if(n == 0) return a[0];
        return a[n] + somatorio(a, n - 1);
    }

    public static int funcao(int n) {
        if(n == 0) return 3;
        return (2 * funcao(n - 1)) + 3;
    }

    static void main() {
        IO.println("Fatorial de 5: " + fatorial(5));
        IO.println("Fibonacci de 10: " + fibonacci(10));
        IO.println("Potência de 2 a 8: " + potencia(2, 8));
        IO.println("Somatório de a=1-4 com n=4: " + somatorio(new int[]{1,2,3,4,5}, 4));
    }
}
