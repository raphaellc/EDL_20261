package exerciciosentrega3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Achar um elemento em um vetor ordenado de comprimento potência de 2.

public class exercicio2_I {

    private static Random random = new Random(); // gera um metodo para gerar numeros aleatorios
    public static List<Integer> gerar_lista(int valor, int limite, List<Integer> listaValores){
        if (limite == 0){
            Collections.sort(listaValores);
            return listaValores;
        }
        listaValores.add(valor);
        List<Integer> respostaParcial = gerar_lista(random.nextInt((100 - 1) + 1), limite - 1, listaValores);
        return respostaParcial;
    }

    public static int achar_elemento(List<Integer> lista, int alvo, int inicio, int fim){
        // caso base
        if (inicio > fim){
            return -1;
        }

        int meio = (fim + inicio) / 2;

        if (lista.get(meio) == alvo){
            return meio;
        }

        if (alvo < lista.get(meio)){
            return achar_elemento(lista, alvo, inicio, meio - 1);
        } else {
            return achar_elemento(lista, alvo, meio + 1, fim);
        }
    }
    public static void main(String[] args){
        List<Integer> listaVazia = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //                                       valor inicial, limite de tamanho pot de 2, lista para guardar os valores
        List<Integer> listaPotDois = gerar_lista(1, (int) Math.pow(4, 2), listaVazia);
        IO.println(listaPotDois);
        IO.println("Qual número você quer achar?");
        int numeroEscolhido = sc.nextInt();
        sc.close();
        int posicaoElemento = achar_elemento(listaPotDois, numeroEscolhido, 0, listaPotDois.size() - 1);
        IO.println(String.format("A posição do número %d é de posição %d.", numeroEscolhido, posicaoElemento + 1));
    }
}
