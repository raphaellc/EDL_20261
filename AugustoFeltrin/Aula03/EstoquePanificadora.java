package AugustoFeltrin.Aula03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EstoquePanificadora {
    public static void main(String[] args) {
        // Exercício 1 
        
        List<String> estoque = new ArrayList<>();

        estoque.add("Pão Francês");
        estoque.add("Bolo de Cenoura");
        estoque.add("Pão de Queijo");
        estoque.add("Sonho");
        estoque.add("Bolo de Cenoura");

        System.out.println("== Panificadora Sabor Caseiro == ");
        System.out.println("Estoque: " + estoque);

        estoque.addLast("Croissant");
        estoque.addFirst("Pão Doce");
        estoque.remove("Sonho");
        System.out.println("Atualização estoque: " + estoque);

        // Exercício 2

        long qtdBoloCenoura = estoque.stream().filter(produtos -> produtos.equals("Bolo de Cenoura")).count();
        long qtdBrigadeiro = estoque.stream().filter(produtos -> produtos.equals("Brigadeiro")).count();

        System.out.println("Quantidade de Bolos de Cenoura: " + qtdBoloCenoura);
        System.out.println("Quantidade de Brigadeiros: " + qtdBrigadeiro);
    
        // Exercício 3
        estoque.sort(Comparator.naturalOrder());
        System.out.println("Estoque organizado ordem alfabética:  " + estoque);
        estoque.sort(Comparator.reverseOrder());
        System.out.println("Estoque organizando ordem inversa: "+ estoque);
    
        // Exercício 4
        List<String> estoquePrincipal  = new ArrayList<>();
        estoquePrincipal.add("Pão");
        estoquePrincipal.add("Bolo");

        List<String> listaVerificacao = new ArrayList<>(estoquePrincipal);
        listaVerificacao.add("Café");
        System.out.println("Estoque Principal: " + estoquePrincipal);
        System.out.println("Lista de Verificação: " + listaVerificacao);
    
        // Exercício 5
        List<String> pedidosPendentes = new ArrayList<>();
        pedidosPendentes.addLast("Café com Leite");
        pedidosPendentes.addLast("Bolo de Chocolate");
        pedidosPendentes.addLast("Pão na Chapa");

        System.out.println(pedidosPendentes.size() + " Pedidos pendentes: " + pedidosPendentes);
        pedidosPendentes.removeFirst();
        pedidosPendentes.addFirst("Suco de Larnja");
        System.out.println(pedidosPendentes.size() + " Pedidos pendentes: " + pedidosPendentes);
    }
}
