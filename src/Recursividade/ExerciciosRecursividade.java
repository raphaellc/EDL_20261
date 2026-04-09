package Recursividade;

public class ExerciciosRecursividade {

    public static void main(String[] args) {
        // Testes rápidos
        System.out.println("a) Multiplicação (5 * 3): " + multiplicar(5, 3));
        System.out.println("b) Palíndromo (ovo): " + isPalindromo("ovo"));
        System.out.println("c) Contar 'a' em 'banana': " + contarCaracter("banana", 'a'));
        System.out.println("d) Soma dígitos (12345): " + somaDigitos(12345));
        System.out.print("f) De 1 a 5: "); imprimirIntervalo(1, 5);
    }

    // a) Multiplicar inteiros por meio de somas sucessivas
    // Ex: 5 * 3 = 5 + (5 * 2)
    public static int multiplicar(int a, int b) {
        if (b == 0) return 0; // Caso base
        return a + multiplicar(a, b - 1); // Passo indutivo
    }

    // b) Verificar se uma palavra é um palíndromo
    public static boolean isPalindromo(String s) {
        if (s.length() <= 1) return true; // Caso base
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return isPalindromo(s.substring(1, s.length() - 1)); // Passo indutivo
    }

    // c) Contar quantas vezes o caractere c ocorre na string s
    public static int contarCaracter(String s, char c) {
        if (s.isEmpty()) return 0; // Caso base
        int count = (s.charAt(0) == c) ? 1 : 0;
        return count + contarCaracter(s.substring(1), c); // Passo indutivo
    }

    // d) Calcular a soma dos dígitos de um número inteiro positivo
    // Ex: 123 -> 3 + somaDigitos(12)
    public static int somaDigitos(int n) {
        if (n == 0) return 0; // Caso base
        return (n % 10) + somaDigitos(n / 10); // Passo indutivo
    }

    // e) Retornar um valor inteiro e positivo em ordem reversa (sem String)
    public static int reverterNumero(int n, int reverso) {
        if (n == 0) return reverso; // Caso base
        return reverterNumero(n / 10, reverso * 10 + (n % 10));
    }

    // f) Escrever em ordem os valores inteiros de x a y
    public static void imprimirIntervalo(int x, int y) {
        System.out.print(x + " ");
        if (x == y) {
            System.out.println();
            return;
        }
        if (x < y) imprimirIntervalo(x + 1, y); // Crescente
        else imprimirIntervalo(x - 1, y);       // Decrescente
    }

    // g) Máximo Divisor Comum (MDC) - Algoritmo de Euclides
    public static int mdc(int a, int b) {
        if (b == 0) return a;
        return mdc(b, a % b);
    }

    // h) Achar maior elemento de um vetor
    public static int maiorVetor(int[] v, int n) {
        if (n == 1) return v[0];
        return Math.max(v[n-1], maiorVetor(v, n-1));
    }
}