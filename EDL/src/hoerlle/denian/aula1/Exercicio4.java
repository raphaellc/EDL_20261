package hoerlle.denian.aula1;

//Elabore um programa que:
//a. declare um vetor de inteiros de 10 posições,
//b. Preencha o mesmo com valores entre 20 e 50.
//c. Imprima o resultado da soma de todos os 10 valores preenchidos.
public class Exercicio4 {
    public static void main(String[] args) {
        int[] nums = new int[10];

        int total = 0;

        System.out.print("[");
        for (int i = 0; i < 10; i++) {
            nums[i] = generateRandomNumber();
            System.out.print(nums[i] + (i == 9 ? "" : ", "));
            total += nums[i];
        }
        System.out.println("]");
        System.out.println("Total: " + total);
    }

    // https://www.geeksforgeeks.org/java/generating-random-numbers-in-java/
    public static int generateRandomNumber() {
        int min = 20, max = 50;
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
