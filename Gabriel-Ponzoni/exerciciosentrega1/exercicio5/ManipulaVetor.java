package exerciciosentrega1.exercicio5;

//import java.lang.reflect.Array;
import java.util.Arrays;
//import java.util.Collections;
import java.util.Scanner;

// Elabore um programa que: 
//     a. Declare um vetor de inteiros de 10 posições  <<<<<<<<<<<<<<<<<
//     b. Preencha o vetor <<<<<<<<<<<<<<<<<<<<<<
//     c. Imprima os valores do vetor de maneira invertida, do último elemento 
//     para o primeiro; <<<<<<<<<<<<<<<<<<<<<<<<<<<
//     d. mostre o maior e o menor valor do vetor <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//     e. faça a rotação à esquerda dos elementos do vetor, por exemplo, dado o 
//     vetor [1,2,3,4,5] após uma rotação à esquerda o vetor ficará [2,3,4,5,1], 
//     após nova rotação à esquerda o vetor ficará [3,4,5,1,2].

public class ManipulaVetor {
    public static int[] reverse(int[] a){
        int[] arrayRev = new int[a.length];
        int n = 0;
        // começa de tras pra frente, posicao 4/5, vai ate 0, incrementa --
        for (int i = a.length-1 ; i >= 0; i--) {
            arrayRev[n] = a[i];
            n++;
        }
        return arrayRev;
    }

    public static void maiorMenor(int[] a){
        //         evitar usar 0, usa 1a posicao do array
        int maior = a[0];
        int menor = a[0];
        for (int i = 0; i < a.length; i++) {
            
            if (maior < a[i]) {
                maior = a[i];
            }

            if (menor > a[i]) {
                menor = a[i];
            }
        }
        IO.println(String.format("Maior valor: %d%nMenor valor: %d%n", maior, menor));
    }

    public static int[] rotacaoEsquerda(int[] a){
        int temp = a[0];
        for (int i = 0; i < a.length -1; i++) {
            a[i] = a[i + 1];
        }
        a[a.length - 1] = temp;
        return a;
    }
    public static void main(String[] args){
        int[] vetor = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = sc.nextInt();
        }
        sc.close();

        IO.println(Arrays.toString(vetor));
        IO.println(Arrays.toString(reverse(vetor)));
        maiorMenor(vetor);
        IO.println(Arrays.toString(rotacaoEsquerda(vetor))); // rotaciona p esquerda vetor 1x
        IO.println(Arrays.toString(rotacaoEsquerda(vetor))); // rotaciona vetor p esquerda 1x
    }
}
