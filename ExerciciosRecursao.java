public class ExerciciosRecursao {

    // a) Multiplicar inteiros por meio de somas sucessivas
    public static int multiplicar(int a, int b) {
        if (b == 0) return 0;
        if (b < 0) return -multiplicar(a, -b); // Trata multiplicador negativo
        return a + multiplicar(a, b - 1);
    }

    // b) Verificar se uma palavra é um palíndromo
    public static boolean ehPalindromo(String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return ehPalindromo(s.substring(1, s.length() - 1));
    }

    // c) Contar ocorrências de um caractere c na string s
    public static int contarCaractere(String s, char c) {
        if (s.isEmpty()) return 0;
        int count = (s.charAt(0) == c) ? 1 : 0;
        return count + contarCaractere(s.substring(1), c);
    }

    // d) Soma dos dígitos de um número inteiro positivo
    public static int somaDigitos(int n) {
        if (n == 0) return 0;
        return (n % 10) + somaDigitos(n / 10);
    }

    // e) Retornar inteiro em ordem reversa (sem usar String)
    public static int reverterInteiro(int n) {
        return reverterAux(n, 0);
    }
    private static int reverterAux(int n, int acumulador) {
        if (n == 0) return acumulador;
        return reverterAux(n / 10, acumulador * 10 + (n % 10));
    }

    // f) Escrever valores de x a y (crescente ou decrescente)
    public static void imprimirIntervalo(int x, int y) {
        System.out.print(x + " ");
        if (x == y) {
            System.out.println();
            return;
        }
        if (x < y) imprimirIntervalo(x + 1, y);
        else imprimirIntervalo(x - 1, y);
    }

    // g) Máximo Divisor Comum (MDC) - Algoritmo de Euclides
    public static int mdc(int a, int b) {
        if (b == 0) return a;
        return mdc(b, a % b);
    }

    // h) Achar maior elemento de um vetor
    public static int maiorVetor(int[] v, int n) {
        if (n == 1) return v[0];
        return Math.max(v[n - 1], maiorVetor(v, n - 1));
    }

    // i) Achar elemento em vetor ordenado (Busca Binária)
    // Comprimento potência de 2 facilita a divisão exata ao meio.
    public static int buscaBinaria(int[] v, int x, int inicio, int fim) {
        if (inicio > fim) return -1;
        int meio = (inicio + fim) / 2;
        if (v[meio] == x) return meio;
        if (v[meio] > x) return buscaBinaria(v, x, inicio, meio - 1);
        return buscaBinaria(v, x, meio + 1, fim);
    }
}