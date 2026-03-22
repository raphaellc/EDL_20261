package hoerlle.denian.aula4;

import java.util.ArrayList;
import java.util.List;

public class Exercicios {
    static void main() {
        // Exercicio 1
//        System.out.println(exerciseA(3,4));
        // Exercicio 2
//        System.out.println(exerciseB("ARARA"));
        // Exercício 3
//        System.out.println(exerciseC('a', "Caraca"));
        // Exercício 4
//        System.out.println(exerciseD(12345));
        // Exercicio 5
//        System.out.println(exerciseE(2468));
        // Exercicio 6
//        exerciseF(0, 10);
        // Exercicio 7
//        System.out.println(exerciseG(12, 24));
        // Exercicio 8
        List<Integer> numList = new ArrayList<>();
        numList.add(5);
        numList.add(10);
        numList.add(20);
        numList.add(0);
        System.out.println(exerciseH(numList));
    }

    public static int exerciseA(int value, int counter) {
        //  Multiplicar inteiros por meio de somas sucessivas;
        if (counter == 0) return 0;

        return value + exerciseA(value, counter - 1);
    }

    public static boolean exerciseB(String word) {
        // Verificar se uma palavra é um palíndromo;

        int length = word.length();

        if (word.charAt(length - 1) != word.charAt(0)) return false;

        if (length <= 1) return true;

        return exerciseB(word.substring(1, length - 1));
    }

    public static int exerciseC(char character, String text) {
        // Contar quantas vezes o caractere C ocorre na string s, onde o caractere e a string são
        // fornecidos como parâmetro;

        // Boa sorte lendo isso aqui

        return (text.isEmpty() ? 0 : (text.charAt(0) == character ? 1 : 0) + exerciseC(character, text.substring(1)));
    }

    public static int exerciseD(int num) {
        // Calcular a soma dos dígitos de um número inteiro e positivo, onde o número é fornecido
        // como parâmetro. Por exemplo, a chamada da função para o valor 12345 deve retornar 15;

        if (num < 10) return num;

        return num % 10 + exerciseD(num / 10);
    }

    public static int exerciseE(int num) {
        // Retornar um valor inteiro e positivo em ordem reversa, onde o valor é fornecido como
        // parâmetro. Por exemplo, a chamada da função para o valor 123 deve retornar 321. Obs.:
        // Não utilizar string para representar o valor;

        if (num < 10) return num;

        int count = 1;
        int firstDigit = num;

        while (firstDigit >= 10) {
            firstDigit /= 10;
            count *= 10;
        }

        int result = num - count * firstDigit;

        return firstDigit + (exerciseE(result) * 10);
    }

    public static void exerciseF(int start, int finish) {
        // Escrever em ordem os valores inteiros de x a y, onde x e y são fornecidos como parâmetro.
        // Obs.: A lista a ser escrita pode estar em ordem crescente ou decrescente;

        System.out.print(start + (start == finish ? "." : ", "));

        if (start < finish) exerciseF(start + 1, finish);
        else if (start > finish) exerciseF( start - 1, finish);
    }

    public static int exerciseG(int num1, int num2) {
        // Calcular o máximo divisor comum entre dois números inteiro e positivos, onde os dois
        // número são fornecidos como parâmetro;

        if (num1 == 0)
            return num2;
        return exerciseG(num2 % num1, num1);

        // Não consegui fazer sozinho. Peguei daqui.
        // https://www.geeksforgeeks.org/dsa/euclidean-algorithms-basic-and-extended/
    }

    public static int exerciseH(List<Integer> vector) {
        // Achar maior elemento de um vetor

        int first = vector.getFirst();
        int size = vector.size();

        if (size == 1) return first;

        int nextNum = exerciseH(vector.subList(1, size));

        return Math.max(first, nextNum);
    }
}