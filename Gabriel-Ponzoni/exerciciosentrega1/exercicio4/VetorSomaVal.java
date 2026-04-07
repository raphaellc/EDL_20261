package exerciciosentrega1.exercicio4;

//  Elabore um programa que:  
//     a. declare um vetor de inteiros de 10 posições,  
//     b. Preencha o mesmo com valores entre 20 e 50.  
//     c. Imprima o resultado da soma de todos os 10 valores preenchidos.

import java.util.Scanner;

public class VetorSomaVal {
    public static void main(String[] args){
        int[] array_vetor = new int[10];
        Scanner sc = new Scanner(System.in);
        int posicao = 0;
        while (posicao < array_vetor.length) {
            int valor = sc.nextInt();
            if (valor >= 20 && valor <= 50){
                array_vetor[posicao] = valor;
                posicao++;
            } else {
                IO.println("O valor só pode ser entre 20 a 50");
            }
        }
        sc.close();
        int soma = 0;
        IO.println("--- Soma valores vetor ---");
        for (int i = 0; i < array_vetor.length; i++) {
            soma += array_vetor[i];
            if (i < 9) {
                IO.println("   "+ array_vetor[i]);
            } else {
                IO.println(" + "+ array_vetor[i]);
                IO.println("_________");
                IO.println("   "+ soma);
            }
        }
    }
}
