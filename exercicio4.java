import java.util.Random;

public class exercicio4 {
    public static void main(String[] args) {
        
        int[] vetor = new int[10];
        Random gerador = new Random();
        int soma = 0;

        System.out.println("Valores gerados:");

        
        for (int i = 0; i < vetor.length; i++) {
            
            vetor[i] = gerador.nextInt(31) + 20;
            
       
            soma += vetor[i];

          
            System.out.print(vetor[i] + " ");
        }

        
        System.out.println("\n\nSoma total: " + soma);
    }
}