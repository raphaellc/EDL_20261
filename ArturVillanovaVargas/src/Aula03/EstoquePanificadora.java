package Aula03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SequencedCollection;

public class EstoquePanificadora {
    public static void main(String[] args) {
        List<String> estoque = new ArrayList<>(List.of("Bolo de Cenoura", "Pão de Queijo", "Sonho", "Bolo de Cenoura"));
        estoque.add("Croissant");
        estoque.add(0, "Pão doce");
        estoque.remove("Sonho");

        System.out.println(estoque);

        long qtdBoloDeCenoura = estoque.stream().filter(produto -> produto.equals("Bolo de Cenoura")).count();
        long qtdBrigadeiro = estoque.stream().filter(produto -> produto.equals("Brigadeiro")).count();

        System.out.println(qtdBoloDeCenoura);
        System.out.println(qtdBrigadeiro);

       estoque.sort(Comparator.naturalOrder());
       estoque.sort(Comparator.reverseOrder());

        List<String> estoquePrincipal = new ArrayList<>(List.of("Pão", "Bolo"));
        List<String> listaDeVerificacao = new ArrayList<>(estoquePrincipal);

        estoquePrincipal.add("Brigadeiro");

        System.out.println(listaDeVerificacao);
        System.out.println(estoquePrincipal);

        SequencedCollection<String> pedidosPendentes = new ArrayList<>();
        pedidosPendentes.addLast("Café com leite");
        pedidosPendentes.addLast("Bolo de chocolate");
        pedidosPendentes.addLast("Pão na Chapa");

        System.out.println(pedidosPendentes + " TAMANHO -> " + pedidosPendentes.size());
        pedidosPendentes.removeFirst();
        pedidosPendentes.addFirst("Suco de Laranja");

        System.out.println(pedidosPendentes + " TAMANHO -> " + pedidosPendentes.size());
    }
}
