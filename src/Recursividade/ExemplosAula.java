package Recursividade;

public class ExemplosAula {

    public static void main(String[] args) {
        // Testando Fatorial
        int nFatorial = 5;
        System.out.println("Fatorial de " + nFatorial + ": " + fatorial(nFatorial));

        // Testando Fibonacci
        int nFib = 7;
        System.out.println("Fibonacci (termo " + nFib + "): " + fibonacci(nFib));

        // Exibindo a sequência de Fibonacci até o termo 7
        System.out.print("Sequência Fibonacci: ");
        for (int i = 0; i <= nFib; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    /**
     * FATORIAL
     * Regra: n! = n * (n-1)!
     * Caso base: 0! ou 1! é igual a 1.
     */
    public static int fatorial(int n) {
        if (n <= 1) { // Caso base
            return 1;
        }
        return n * fatorial(n - 1); // Passo indutivo
    }

    /**
     * FIBONACCI
     * Regra: f(n) = f(n-1) + f(n-2)
     * Caso base: f(0) = 0, f(1) = 1
     */
    public static int fibonacci(int n) {
        if (n == 0) return 0; // Caso base 1
        if (n == 1) return 1; // Caso base 2
        return fibonacci(n - 1) + fibonacci(n - 2); // Passo indutivo (dupla recursão)
    }
}