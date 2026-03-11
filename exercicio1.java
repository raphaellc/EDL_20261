import java.util.Scanner;
import java.util.Random;

public class exercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        
        System.out.print("Digite o número de linhas (n): ");
        int n = sc.nextInt();
        System.out.print("Digite o número de colunas (m): ");
        int m = sc.nextInt();

        char[] letras = new char[5];
        System.out.println("Digite 5 letras (pressione Enter após cada uma):");
        for (int i = 0; i < 5; i++) {
            letras[i] = sc.next().charAt(0);
        }

  
        char[][] tabuleiro = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                int indiceAleatorio = random.nextInt(5);
                tabuleiro[i][j] = letras[indiceAleatorio];
            }
        }

        
        System.out.println("\n--- Tabuleiro Gerado ---");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}