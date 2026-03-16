package hoerlle.denian.aula1;

import java.util.Scanner;

// Crie um tabuleiro com n linhas por m colunas. Esse tabuleiro deve ser
// preenchido com cinco letras (informadas pelo usuário) distribuídas
// aleatoriamente.
public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = 5, m = 5;

        char[][] board = new char[n][m];

        char[] selectedChars = new char[5];

        for(int i = 0; i < 5; i++) selectedChars[i] = readCharFromInput(scan);

        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                board[i][j] = selectedChars[generateRandomNumber()];

        printBoard(board);

        scan.close();
    }

    public static char readCharFromInput(Scanner scan) {
        char newChar = '0';

        while (newChar == '0') {
            System.out.println("Digita uma única letra ai");
            String userInput = scan.nextLine();

            if (userInput.length() > 1) {
                System.out.println("Você fala demais amigão. Passa um charactere só");
                continue;
            }

            int characterCode = (int)userInput.charAt(0);
            if (characterCode < 65 || (characterCode > 90 && characterCode < 97) || characterCode > 122) {
                System.out.println("LETRA parceiro. Sabe o que é uma LETRA? ABC tá ligado??");
                continue;
            }

            newChar = userInput.charAt(0);
        }

        return newChar;
    }

    // https://www.geeksforgeeks.org/java/generating-random-numbers-in-java/
    public static int generateRandomNumber() {
        int max = 4;
        return (int)(Math.random() * ((max) + 1));
    }

    public static void printBoard(char[][] board) {
        for (char[] chars : board) {
            System.out.print("[");
            for (int j = 0; j < chars.length; j++)
                System.out.print(chars[j] + (j == chars.length - 1 ? "" : ", "));
            System.out.println("]");
        }
    }
}
