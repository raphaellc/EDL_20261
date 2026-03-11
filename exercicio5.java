import java.util.Scanner;
import java.util.Arrays;

public class exercicio5 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[10];

        // a. e b. Declarar e Preencher o vetor
        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Posição [" + i + "]: ");
            vetor[i] = leitor.nextInt();
        }

        // c. Imprimir de maneira invertida
        System.out.println("\n--- Vetor Invertido ---");
        for (int i = vetor.length - 1; i >= 0; i--) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();

        // d. Mostrar o maior e o menor valor
        int maior = vetor[0];
        int menor = vetor[0];

        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > maior) maior = vetor[i];
            if (vetor[i] < menor) menor = vetor[i];
        }
        System.out.println("\nMaior valor: " + maior);
        System.out.println("Menor valor: " + menor);

        // e. Rotação à esquerda
        // Vamos realizar uma rotação como exemplo
        int primeiro = vetor[0]; // Salva o primeiro elemento
        for (int i = 0; i < vetor.length - 1; i++) {
            vetor[i] = vetor[i + 1]; // Move o próximo para a posição atual
        }
        vetor[vetor.length - 1] = primeiro; // O antigo primeiro vai para o final

        System.out.println("\n--- Vetor após uma rotação à esquerda ---");
        System.out.println(Arrays.toString(vetor));

        leitor.close();
    }
}