package exerciciosentrega2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EstoquePanificadora {
    public static void main(String[] args){
        // Parte 1
        IO.println("1. Organizando o Estoque: Inserção e Remoção ");
        List<String> produtosList = new ArrayList<>(List.of("Pão Francês", "Bolo de Cenoura", "Pão de Queijo", "Sonho", "Bolo de Cenoura"));
        IO.println(">>> Estoque Inicial:");        
        IO.println(produtosList);
        produtosList.add("Croissant");
        IO.println(">>> Adicionado Croissant ao final da lista.");
        IO.println(produtosList);
        produtosList.add(0, "Pão Doce"); //poderia ser .addFirst pra adicinar na primeira posicao
        IO.println(">>> Adicionado Pão Doce no início da lista.");
        IO.println(produtosList);
        produtosList.remove("Sonho");
        IO.println(">>> Compraram um sonho, removido Sonho da lista.");
        IO.println(produtosList);
        IO.println("-=-".repeat(30));

        // Parte 2
        IO.println("2. Contando as Delícias: Streams e Filtros ");                      
        //                                                    entrada/action/logica
        long quantidadeBoloDeCenoura= produtosList.stream().filter(item -> item.equals("Bolo de Cenoura")).count();
        IO.println(String.format("Quantidade de Bolo de cenoura na lista: %d", quantidadeBoloDeCenoura));
        long quantidadeBrigadeiro= produtosList.stream().filter(item -> item.equals("Brigadeiro")).count();
        IO.println(String.format("Quantidade de Brigadeiro na lista: %d", quantidadeBrigadeiro));
        IO.println("-=-".repeat(30));

        // Parte 3
        IO.println("3. Arrume a Prateleira: Ordenação");
        List<String> estoqueDoDiaList = new ArrayList<>(List.of("Pão Francês", "Bolo de Cenoura", "Pão de Queijo", "Alfajor", "Sonho", "Bolo de Cenoura", "Brigadeiro"));
        IO.println(">>> Estoque do Dia, fora de ordem:");
        IO.println(estoqueDoDiaList);
        IO.println(">>> Estoque do Dia, ordenado alfabeticamente:");
        estoqueDoDiaList.sort(Comparator.naturalOrder());
        IO.println(estoqueDoDiaList);
        IO.println(">>> Estoque do Dia, ordenado de Z - A");
        estoqueDoDiaList.sort(Comparator.reverseOrder());
        IO.println(estoqueDoDiaList);
        IO.println("-=-".repeat(30));

        // Parte 4
        IO.println("4. Referências de Memória e Cópia Segura");
        List<String> estoquePrinciapList = new ArrayList<>(List.of("Pão", "Bolo"));
        List<String> listaDeVerificacao = new ArrayList<>(estoquePrinciapList);
        listaDeVerificacao.add("Brigadeiro");
        IO.println(estoquePrinciapList);
        IO.println(listaDeVerificacao);
        IO.println("-=-".repeat(30));

        // Parte 5
        IO.println("5. Teste Final: Sistema de Pedidos (FIFO)");
        List<String> pedidosPendentesList = new ArrayList<>();
        IO.println(">>> Pedidos no sistema:");
        IO.println(pedidosPendentesList);
        IO.println(">>> Chegou o pedido 1- Café com Leite!");
        pedidosPendentesList.add("Café com Leite");
        IO.println(pedidosPendentesList);
        IO.println(">>> Chegou o pedido 2- Bolo de Chocolate!");
        pedidosPendentesList.add("Bolo de Chocolate");
        IO.println(pedidosPendentesList);
        IO.println(">>> Chegou o pedido 3- Pão na Chapa!");
        pedidosPendentesList.add("Pão na Chapa");
        IO.println(pedidosPendentesList);
        int tamanhoPedidos = pedidosPendentesList.size();
        IO.println(String.format(">>> Tamanho da lista de pedidos: %d", tamanhoPedidos));
        IO.println(">>> Finalizei o primeiro pedido e removi ele!");
        pedidosPendentesList.removeFirst();
        IO.println(pedidosPendentesList);
        IO.println(">>> Um cliente prioritário chegou! Adicionei por primeiro o pedido \"Suco de Laranja\" ");
        pedidosPendentesList.addFirst("Suco de Laranja");
        IO.println(pedidosPendentesList);

    }
}
