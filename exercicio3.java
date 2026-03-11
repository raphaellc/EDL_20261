import java.util.Scanner;

public class exercicio3 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int numero;

        System.out.println("Digite números inteiros positivos (0 para sair):");

        do {
            System.out.print("Entrada: ");
            numero = leitor.nextInt();

           
            if (numero >= 5 && numero <= 15) {
                System.out.println("Número no intervalo: " + numero);
            }

        } while (numero != 0); 
        System.out.println("Programa encerrado.");
        leitor.close();
    }
}