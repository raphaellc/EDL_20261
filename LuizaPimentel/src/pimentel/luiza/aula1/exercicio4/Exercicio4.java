package pimentel.luiza.aula1.exercicio4;

// 4. Elabore um programa que:  
// a. declare um vetor de inteiros de 10 posições,  
// b. Preencha o mesmo com valores entre 20 e 50.  
// c. Imprima o resultado da soma de todos os 10 valores preenchidos.

public class Exercicio4 {

    public static void main(String[] args) {

        int[] array = new int[10];

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 31) + 20;
            sum += array[i];

            System.out.println("Valor na posição " + i + ": " + array[i]);
        }

        System.out.println("Soma dos valores preenchidos: " + sum);
    } 
}
