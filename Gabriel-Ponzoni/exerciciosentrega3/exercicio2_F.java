package exerciciosentrega3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Implementar Recursividade: Escrever em ordem os valores inteiros de x a y, onde x e y são fornecidos como parâmetro. 
// Obs.: A lista a ser escrita pode estar em ordem crescente ou decrescente;

public class exercicio2_F {
    public static List<Integer> entre_valores(int a, int b, List<Integer> valores){ // 1 e 10
        valores.add(a); // [1,]
        // caso base
        if (a == b) { // 1 = 10?
            return valores; // 
        }

        // passo indutivo
        if (a > b){ // 1 > 10?
            List<Integer> respostaParcial = entre_valores(a - 1, b, valores); // 1 - 1 , 10, [1,]
            return respostaParcial;
        } else {
            List<Integer> respostaParcial = entre_valores(a + 1, b, valores); // 1 + 1, 10, [1,]
            return respostaParcial;
        }
    }
    public static void main(String[] args){
        List<Integer> numerosList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        IO.println("Informe 2 números para eu dizer o que tem entre eles:");
        int numero1 = sc.nextInt();
        int numero2 = sc.nextInt();
        sc.close();
        numerosList = entre_valores(numero1, numero2, numerosList);
        IO.println(numerosList);
    }
}
