package AugustoFeltrin.Aula04;

public class ExercicioH {
    public static int buscarMaior(int[] vetor, int n) {
        if (n == 1) {
            return vetor[0];
        }

        int maior = buscarMaior(vetor, n - 1);

        if (vetor[n - 1] > maior) {
            return vetor[n - 1];
        } else {
            return maior;
        }
    }

    public static void main(String[] args) {
        int[] numeros = {12, 45, 7, 92, 18};
        
        int resultado = buscarMaior(numeros, numeros.length);
        
        System.out.println("O maior elemento do vetor é: " + resultado);
    }
}
