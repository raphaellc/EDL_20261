package pimentel.luiza.aula1.exercicio5;

import java.util.Arrays;

/*
    5. Elabore um programa que: 
        a. Declare um vetor de inteiros de 10 posições  
        b. Preencha o vetor 
        c. Imprima os valores do vetor de maneira invertida, do último elemento 
        para o primeiro; 
        d. mostre o maior e o menor valor do vetor 
        e. faça a rotação à esquerda dos elementos do vetor, por exemplo, dado o 
        vetor [1,2,3,4,5] após uma rotação à esquerda o vetor ficará [2,3,4,5,1], 
        após nova rotação à esquerda o vetor ficará [3,4,5,1,2].
*/


public class Exercicio5 {
    public static void main(String[] args) {

        int[] array = new int[10];

        // Prenche
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 11);
        }

        System.out.println("\nArray original: " + Arrays.toString(array));
        
        // Inverte
        System.out.print("Array invertido: [");
        for (int i = array.length - 1; i > 0; i--) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[0] + "]");

        // Exibe maior e menor valor
        int max = array[0];
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }

        System.out.println("\nMaior valor: " + max);
        System.out.println("Menor valor: " + min);

        // Rotação à esquerda
        int first = array[0];

        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = first;

        System.out.println("Array rotacionado: " + Arrays.toString(array));
    }
    
}
