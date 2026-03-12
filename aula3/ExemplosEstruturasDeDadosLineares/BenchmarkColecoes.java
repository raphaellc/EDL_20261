package raphaellc.ExemplosEstruturasDeDadosLineares;

import java.util.*;

public class BenchmarkColecoes {
    public static void main(String[] args) {
        int N = 100_000; // Quantidade de elementos

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.println("--- Teste com " + N + " elementos ---");

        // 1. TESTE DE INSERÇÃO NO INÍCIO
        // ArrayList precisa "empurrar" todos os itens para o lado a cada inserção.
        // LinkedList apenas muda os ponteiros dos nós.
        
        long inicio = System.currentTimeMillis();
        for (int i = 0; i < N; i++) arrayList.add(0, i);
        long fim = System.currentTimeMillis();
        System.out.println("ArrayList - Inserção no Início: " + (fim - inicio) + "ms");

        inicio = System.currentTimeMillis();
        for (int i = 0; i < N; i++) linkedList.add(0, i);
        fim = System.currentTimeMillis();
        System.out.println("LinkedList - Inserção no Início: " + (fim - inicio) + "ms");

        System.out.println("-----------------------------------");

        // 2. TESTE DE ACESSO ALEATÓRIO (Busca por índice)
        // ArrayList acessa direto o endereço de memória.
        // LinkedList precisa percorrer a lista nó por nó até chegar no índice.
        
        inicio = System.currentTimeMillis();
        for (int i = 0; i < N; i++) arrayList.get(i);
        fim = System.currentTimeMillis();
        System.out.println("ArrayList - Acesso por Índice: " + (fim - inicio) + "ms");

        inicio = System.currentTimeMillis();
        for (int i = 0; i < N; i++) linkedList.get(i);
        fim = System.currentTimeMillis();
        System.out.println("LinkedList - Acesso por Índice: " + (fim - inicio) + "ms (MUITO LENTO)");
    }
}
