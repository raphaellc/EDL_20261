package hoerlle.denian.aula1;

import java.util.Scanner;

//Implemente um programa que receba como entrada somente números inteiros
//positivos e imprima apenas os que estejam no intervalo de 5 a 15. O Programa
//deve terminar quando for digitado o valor 0.
public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int currentNumber = 1;

        while (currentNumber != 0) {
            System.out.println("Digita um número ai. Se não quiser mais brincar, põe 0");
            currentNumber = Integer.parseInt(scan.nextLine());

            if (currentNumber >= 5 && currentNumber <= 15) System.out.println("Esse número aí, " + currentNumber + ", tá no intervalo de 5-15");
        }

        scan.close();
    }
}
