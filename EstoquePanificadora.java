import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EstoquePanificadora {
    public static void main(String[] args) {
        
        List<String> estoque = new ArrayList<>(Arrays.asList(
            "Pao Francês", "Bolo de Cenoura", "Pao de Queijo", "Sonho", "Bolo de Cenoura"
        ));

        estoque.add("Croissant");

        estoque.add(0, "Pao Doce");

        estoque.remove("Sonho");

        System.out.println("Estado atual do estoque:");
        System.out.println(estoque);

        long qtdBoloCenoura = estoque.stream()
                                     .filter(item -> item.equals("Bolo de Cenoura"))
                                     .count();

        long qtdBrigadeiro = estoque.stream()
                                    .filter(item -> item.equals("Brigadeiro"))
                                    .count();

        System.out.println("Quantidade de Bolo de Cenoura: " + qtdBoloCenoura);
        System.out.println("Quantidade de Brigadeiro: " + qtdBrigadeiro);

        estoque.sort(Comparator.naturalOrder());
        System.out.println("3. Estoque em Ordem Alfabética (A-Z):");
        System.out.println(estoque);

        estoque.sort(Comparator.reverseOrder());
        System.out.println("\n3.1 Estoque em Ordem Inversa (Z-A):");
        System.out.println(estoque);

        
        List<String> estoquePrincipal = new ArrayList<>(Arrays.asList("Pão", "Bolo"));

        
        List<String> listaDeVerificacao = new ArrayList<>(estoquePrincipal);

        
        listaDeVerificacao.add("Café");

       
        System.out.println("4. Prova de Independência de Memória:");
        System.out.println("Estoque Principal (Original): " + estoquePrincipal);
        System.out.println("Lista de Verificação (Cópia): " + listaDeVerificacao);
        
        if (estoquePrincipal.size() != listaDeVerificacao.size()) {
            System.out.println("\nSucesso: As listas são independentes!");
        }


        List<String> pedidosPendentes = new ArrayList<>();

        pedidosPendentes.addLast("Café com Leite");
        pedidosPendentes.addLast("Bolo de Chocolate");
        pedidosPendentes.addLast("Pão na Chapa");

        System.out.println("5. Pedidos Iniciais: " + pedidosPendentes);
        System.out.println("Total de pedidos: " + pedidosPendentes.size());

        
        String pedidoProcessado = pedidosPendentes.removeFirst();
        System.out.println("\nProcessando pedido: " + pedidoProcessado);
        System.out.println("Pedidos restantes: " + pedidosPendentes);

        pedidosPendentes.addFirst("Suco de Laranja");
        
        System.out.println("\nApós chegada de prioridade:");
        System.out.println("Fila de atendimento: " + pedidosPendentes);
    }
}