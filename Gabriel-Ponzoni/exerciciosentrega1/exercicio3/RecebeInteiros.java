package exerciciosentrega1.exercicio3;

// Implemente um programa que receba como entrada somente números inteiros 
// positivos e imprima apenas os que estejam no intervalo de 5 a 15. O Programa 
// deve terminar quando for digitado o valor 0. 

import java.util.ArrayList;
import java.util.Scanner;

public class RecebeInteiros {
    public static void main(String[] args){
        // try-with-resorces para fechar o scanner mesmo q tem um throw excpetion
        try (Scanner sc = new Scanner(System.in)){
            ArrayList<Integer> array_valores = new ArrayList<>();
            ArrayList<Integer> array_valores_filtrados = new ArrayList<>();
            IO.println("Informe valores inteiros positivos:");

            int chave = 1;
            while (chave == 1) {
                int valor = sc.nextInt();
                if (valor < 0) {
                    throw new IllegalArgumentException("Não usar valor negativo!");
                } else if (valor > 0){
                    array_valores.add(valor);
                } else {
                    chave = 0;
                }
            }

            IO.println(array_valores);
            for (int valor : array_valores){
                if (valor >= 5 && valor <= 16){
                    array_valores_filtrados.add(valor);
                }
            }
            IO.println(array_valores_filtrados);
        }
    }
}