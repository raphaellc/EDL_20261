package AugustoFeltrin.Aula04;

public class ExercicioI {
    public static int buscaBinaria(int[] vetor, int alvo, int inicio, int fim){
        if(inicio > fim){
            return -1;
        }

        int meio = (inicio + fim) / 2;

        if(vetor[meio] == alvo){
            return meio;
        }

        if(alvo < vetor[meio]){
            return buscaBinaria(vetor, alvo, inicio, meio-1);
        } else {
            return buscaBinaria(vetor, alvo, meio + 1, fim);
        }
    }
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50, 60, 70, 80};
        int alvo = 70;

        int posicao = buscaBinaria(numeros, alvo, 0, numeros.length - 1);
        if (posicao != -1) {
            System.out.println("Elemento " + alvo + " encontrado na posição: " + posicao);
        } else {
            System.out.println("Elemento não encontrado.");
        }
    }
}
