import java.io.FileNotFoundException;

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
        System.out.println(exerciseE(123));

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

        return 0;

//        return (firstDigit + exerciseE(num - ));
    }



}