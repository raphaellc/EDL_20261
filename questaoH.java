public class questaoH {

    public static int maiorElemento(int[] vetor, int indice) {
        if (indice == vetor.length - 1) {
            return vetor[indice];
        }


        int maiorDoResto = maiorElemento(vetor, indice + 1);

        return Math.max(vetor[indice], maiorDoResto);
    }
    
}