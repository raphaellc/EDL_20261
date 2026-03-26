public class questaoI {

    public static int buscaBinaria(int[] vetor, int inicio, int fim, int alvo) {
        if (inicio > fim) {
            return -1; 
        }

        int meio = (inicio + fim) / 2;

        if (vetor[meio] == alvo) {
            return meio;
        }
        if (alvo < vetor[meio]) {
            return buscaBinaria(vetor, inicio, meio - 1, alvo);
}
        return buscaBinaria(vetor, meio + 1, fim, alvo);
    
}
}