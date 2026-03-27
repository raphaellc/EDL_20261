package pimentel.luiza.aula1.exercicio3;

import java.util.ArrayList;
import java.util.Scanner;

// 3. Implemente um programa que receba como entrada somente números inteiros 
// positivos e imprima apenas os que estejam no intervalo de 5 a 15. O Programa 
// deve terminar quando for digitado o valor 0.


public class Exercicio3 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> range = new ArrayList<>();

        while (true) {
            System.out.print("Digite um número inteiro positivo (ou 0 para encerrar o programa): ");
            int number = scan.nextInt();

            if (number == 0) {
                System.out.println("Encerrando...");
                break;
            } 
            
            if (number < 0) {
                System.out.println(number + " é negativo. Tente novamente.");
            } else if (number >= 5 && number <= 15) {
                if (!range.contains(number)) {
                    range.add(number);
                }
            }
        }
        
        System.out.println("Números digitados dentro do intervalo entre 5 e 15: " + range);
        scan.close();
    }
}
