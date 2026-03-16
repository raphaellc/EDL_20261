package hoerlle.denian.aula1;

//Elabore um programa que:
//a. Declare um vetor de inteiros de 10 posições
//b. Preencha o vetor
//c. Imprima os valores do vetor de maneira invertida, do último elemento para o primeiro;
//d. mostre o maior e o menor valor do vetor
//e. faça a rotação à esquerda dos elementos do vetor, por exemplo, dado o
//   vetor [1,2,3,4,5] após uma rotação à esquerda o vetor ficará [2,3,4,5,1],
//   após nova rotação à esquerda o vetor ficará [3,4,5,1,2].
public class Exercicio5 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        int maior, menor;

        nums[0] = generateRandomNumber();
        maior = nums[0];
        menor = nums[0];

        for (int i = 9; i > 0; i--) {
            int newNumber = generateRandomNumber();
            nums[i] = newNumber;
            if (newNumber > maior) maior = newNumber;
            if (newNumber < menor) menor = newNumber;
        }

        System.out.println("Array Original: ");
        printArray(nums);

        System.out.println("Array Invertido: ");
        printReversedArray(nums);

        System.out.println("Maior número: " + maior);
        System.out.println("Menor número: " + menor);

        System.out.println("Array rotacionado: ");
        printArray(rotateArray(nums));
    }

    // https://www.geeksforgeeks.org/java/generating-random-numbers-in-java/
    public static int generateRandomNumber() {
        int min = 0, max = 100;
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public static int[] rotateArray(int[] array) {
        int firstPosition = array[0];

        for (int i = 0; i < array.length; i++)
            if (i == array.length - 1) array[i] = firstPosition;
            else array[i] = array[i+1];

        return array;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + (i == array.length - 1 ? "" : ", "));
        System.out.println("]");
    }

    public static void printReversedArray(int[] array) {
        System.out.print("[");
        for (int i = array.length - 1; i > 0; i--)
            System.out.print(array[i] + ", ");
        System.out.println(array[0] + "]");
    }
}
