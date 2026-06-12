import java.util.Arrays;

public class OrdenacaoBubble {

    // Método auxiliar genérico para realizar a troca de elementos
    private static <T extends Comparable<? super T>> void exchange(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // Algoritmo Bubble Sort Genérico
    public static <T extends Comparable<? super T>> void bubbleSort(T[] a) {
        boolean exchange;
        do {
            exchange = false;
            for (int i = 0; i < a.length - 1; i++) {
                // Compara se o elemento atual é maior que o próximo
                if (a[i].compareTo(a[i + 1]) > 0) {
                    exchange(a, i, i + 1);
                    exchange = true;
                }
            }
        } while (exchange);
    }

    // Método principal para testar a execução
    public static void main(String[] args) {
        // Nota: Como o algoritmo usa genéricos (<T>), precisamos usar a classe Wrapper 'Integer' em vez do tipo primitivo 'int'
        Integer[] dados = {7, 2, 8, 5, 4};

        System.out.println("Vetor original: " + Arrays.toString(dados));

        // Executa a ordenação
        bubbleSort(dados);

        System.out.println("Vetor ordenado: " + Arrays.toString(dados));
    }
}