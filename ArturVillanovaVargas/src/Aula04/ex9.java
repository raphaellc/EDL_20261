package Aula04;

public class ex9 {
    public static int busca(int[] vetor, int inicio, int fim, int valor) {
        if (inicio > fim) {
            return -1;
        }

        int meio = (inicio + fim) / 2;

        if (vetor[meio] == valor) {
            return meio;
        }

        if (valor < vetor[meio]) {
            return busca(vetor, inicio, meio - 1, valor);
        } else {
            return busca(vetor, meio + 1, fim, valor);
        }
    }
}
