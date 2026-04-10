package Aula04;

public class main {
    public static void main(String[] args) {
        System.out.println("Multiplicacao: " + ex1.multiplicar(5, 3));

        System.out.println("Palindromo: " + ex2.palindromo("arara", 0, "arara".length() - 1));

        System.out.println("Contar char: " + ex3.contarChar("banana", 'a', 0));

        System.out.println("Soma digitos: " + ex4.somaDigitos(12345));

        System.out.println("Numero invertido: " + ex5.reverter(123, 0));

        System.out.println("Valores de 5 até 10:");
        ex6.imprimir(5, 10);

        System.out.println("MDC: " + ex7.mdc(48, 18));

        int[] vetor = {3, 7, 2, 9, 5};
        System.out.println("Maior elemento: " + ex8.maior(vetor, vetor.length));

        int[] vetorOrdenado = {1,2,3,4,5,6,7,8};
        System.out.println("Busca binaria (6): " + ex9.busca(vetorOrdenado, 0, vetorOrdenado.length - 1, 6));
    }
}
