package aula4.exercicios.h;

public class MaiorElementoVetor {
    public static int maiorElemento(int[] vetor) {
        return buscarMaior(vetor, vetor.length-1); // Começa do final e vai até o inicio
    }

    private static int buscarMaior(int[] vetor, int indiceAtual) {
        if(vetor.length == 1) return vetor[0];

        // O maior entre atual e o anterior até chegar no indice 0
        // (Momento em que a comparação é entre o atual e o primeiro, pois o indice zero nao tem ngm pra
        // comparar)
        if(indiceAtual == 0) return vetor[0];

        return Math.max(vetor[indiceAtual], buscarMaior(vetor, indiceAtual-1));
    }
}
