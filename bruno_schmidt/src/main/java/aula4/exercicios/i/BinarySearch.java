package aula4.exercicios.i;

public class BinarySearch {
    public static int buscar(int[] vetor, int valor) {
        if(vetor.length == 0) return -1;

        var posMeio = vetor.length / 2;
        var meio = vetor[posMeio];

        if(meio == valor) return posMeio;

        int posicaoInicio = valor > meio ? posMeio + 1 : 0;
        int posicaoFim = valor > meio ? vetor.length : posMeio;

        return buscaBinaria(vetor, valor, posicaoInicio, posicaoFim);
    }

    private static int buscaBinaria(int[] vetor, int valor, int pos, int fim) {
        if(pos == fim) return -1;

        var valorAtual = vetor[pos];

        if(valorAtual == valor) return pos;

        return buscaBinaria(vetor, valor, pos+1, fim);
    }

}
