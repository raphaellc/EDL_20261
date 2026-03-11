package exerciciosentrega1.exercicio1;

// import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Crie um tabuleiro com n linhas por m colunas. Esse tabuleiro deve ser 
// preenchido com cinco letras (informadas pelo usuário) distribuídas 
// aleatoriamente.


public class Tabuleiro {
    public static boolean isElementPresent(char[] array, char alvo) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == alvo) {
                return true; 
            }
        }
        return false; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] array_caracteres = new char[5];
        Random gerador = new Random();

        IO.println("Informe as linhas");
        int n = sc.nextInt();
        IO.println("Informe as colunas");
        int m = sc.nextInt();

        IO.println("Informe 5 caracters:");
        
        int preenchido = 0;
        while (preenchido < array_caracteres.length) {
            char valor = sc.next().charAt(0);
            if (!isElementPresent(array_caracteres, valor)){
                array_caracteres[preenchido] = valor;
                preenchido ++;
            } else {
                IO.println("N pode char repetido! Tente de novo");
            }
        }
        // for (int i = 0; i < array_caracteres.length; i++){
        //     array_caracteres[i] = sc.next().charAt(0); // pra poder pegar so o primeiro char da String
        // }
        sc.close();
        // IO.println(Arrays.toString(array_caracteres));

        char[][] matriz_tabuleiro = new char[n][m];
        //   iniciali; condicao; incremento
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                int indice_aleatorio = gerador.nextInt(array_caracteres.length);
                matriz_tabuleiro[i][j] = array_caracteres[indice_aleatorio];
            }
        }
        
        //  inicializa; condicao; incremento
        for (int i = 0; i < n; i++){
            IO.print("| ");
            for (int j = 0; j < m; j++){
                IO.print(matriz_tabuleiro[i][j]);
            }
            IO.print(" |");
            IO.println();
        }
    }
}
