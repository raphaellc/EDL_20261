package Aula04;

public class ex8 {
    public static int maior(int[] vetor, int tamanho) {
        if (tamanho == 1) {
            return vetor[0];
        }

        int maiorAnterior = maior(vetor, tamanho - 1);

        if (vetor[tamanho - 1] > maiorAnterior) {
            return vetor[tamanho - 1];
        } else {
            return maiorAnterior;
        }
    }
}
