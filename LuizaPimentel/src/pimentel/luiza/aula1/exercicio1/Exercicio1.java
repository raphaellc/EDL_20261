package pimentel.luiza.aula1.exercicio1;

import java.util.Random;
import java.util.Scanner;

// 1. Crie um tabuleiro com n linhas por m colunas. 
// Esse tabuleiro deve ser preenchido com cinco letras 
// (informadas pelo usuário) distribuídas aleatoriamente.

public class Exercicio1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = readInt("\nDigite o número de linhas do tabuleiro: ", scan);
        int m = readInt("Digite o número de colunas do tabuleiro: ", scan);

        char[] letters = new char[5];
        for (int i = 0; i < 5; i++) {
            letters[i] = readLetter(scan);
        }

        char[][] board = new char[n][m];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int index = random.nextInt(5); // gera um número aleatório entre 0 a 4 que vai ser usado como índice em letters;
                board[i][j] = letters[index];
            }
        }
        
        printBoard(board);
    }

    public static int readInt(String prompt, Scanner scan) {
        System.out.print(prompt);

        while (!scan.hasNextInt()) {
            System.out.print("Entrada inválida. Digite um número inteiro: ");
            scan.next();
            continue;
        }

        int value = scan.nextInt();
        scan.nextLine();
        return value;
    }

    public static char readLetter(Scanner scan) {
        while (true) {
            System.out.print("\nDigite uma letra: ");
            String input = scan.nextLine().trim().toUpperCase();

            if (input.isEmpty()) {
                System.out.println("Digite uma entrada válida, sem espaços vazios.");
                continue;
            }

            char c = input.charAt(0);

            if (!Character.isLetter(c)) {
                System.out.print("Não é uma letra válida (A-Z). Tente novamente.");
                continue;
            }
            return c;
        }
        
    }

    public static void printBoard(char[][] board) {
        System.out.println("\nTabuleiro");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("[" + board[i][j] + "] ");
            }
            System.out.println();
        }
    }
}

    
