package GabrielArboitte.DesafioPanificadora;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class EstoquePanificadora 
{
    public static void main(String[] args) 
    {
        ArrayList<String> Estoque = new ArrayList<>(Arrays.asList("Pão Francês", "Bolo de Cenoura", "Pão de Queijo", "Sonho", "Bolo de Cenoura"));
        
        Estoque.add("Croissant");
        Estoque.add(0, "Pão Doce"); // add(indice, var)
        Estoque.remove("Sonho");
        System.out.println(Estoque);

        // conta quantas vezes "Bolo de Cenoura" aparece
        long qtdBoloCenoura = Estoque.stream()
            .filter(item -> item.equals("Bolo de Cenoura"))
            .count();

        // conta quantas vezes "Brigadeiro" aparece
        long qtdBrigadeiro = Estoque.stream()
            .filter(item -> item.equals("Brigadeiro"))
            .count();

        System.out.println("Bolo de Cenoura: " + qtdBoloCenoura);
        System.out.println("Brigadeiro: " + qtdBrigadeiro);
        
        //3
        Estoque.sort(Comparator.naturalOrder());
        System.out.println(Estoque);
        Estoque.sort(Comparator.reverseOrder());
        System.out.println(Estoque);

        //4
        ArrayList<String> estoquePrincipal = new ArrayList<>(Arrays.asList("Pão", "Bolo"));
        ArrayList<String> estoqueVerificacao = new ArrayList<>(estoquePrincipal);
        estoqueVerificacao.add("itemQualquer");
        System.out.println(estoquePrincipal);
        System.out.println(estoqueVerificacao);

        //5
        ArrayList<String> pedidosPendentes = new ArrayList<>();
        pedidosPendentes.addLast("Café com leite");
        pedidosPendentes.addLast("Bolo de chocolate");
        pedidosPendentes.addLast("Pão na chapa");
        System.out.println(pedidosPendentes);
        System.out.println(pedidosPendentes.size());

        System.out.println("Entregando primeiro pedido da lista");
        pedidosPendentes.removeFirst();
        System.out.println(pedidosPendentes);

        System.out.println("Um cliente prioritário chegou! ");
        pedidosPendentes.addFirst("Suco de Laranja");
        System.out.println(pedidosPendentes);
    }   
}