import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EstoquePanificadora {

    public static void main(String[] args) {

        IO.println("\n=== Estoque ===");
        List<String> estoque = new ArrayList<>(List.of(
                "Pão Francês", "Bolo de Cenoura", "Pão de Queijo", "Sonho", "Bolo de Cenoura"
        ));

        estoque.add("Croissant");
        estoque.addFirst("Pão Doce");
        estoque.remove("Sonho");

        IO.println("Estado atual do estoque: " + estoque);


        IO.println("\n Contando Estoque");
        long qtdBoloCenoura = estoque.stream()
                .filter(item -> item.equals("Bolo de Cenoura"))
                .count();

        long qtdBrigadeiro = estoque.stream()
                .filter(item -> item.equals("Brigadeiro"))
                .count();

        IO.println("Quantidade de 'Bolo de Cenoura': " + qtdBoloCenoura);
        IO.println("Quantidade de 'Brigadeiro': " + qtdBrigadeiro);



        IO.println("\nOrdenando");
        estoque.sort(Comparator.naturalOrder());
        IO.println("Estoque em ordem alfabética: " + estoque);

        estoque.sort(Comparator.reverseOrder());
        IO.println("Estoque em ordem alfabética inversa (VIP): " + estoque);


        IO.println("\n Referências e Cópia Segura");
        List<String> estoquePrincipal = new ArrayList<>(List.of("Pão", "Bolo"));
        List<String> listaDeVerificacao = new ArrayList<>(estoquePrincipal);

        listaDeVerificacao.add("Torta");

        IO.println("Estoque Principal (intacto): " + estoquePrincipal);
        IO.println("Lista de Verificação (alterada): " + listaDeVerificacao);


        IO.println("\nSistema de Pedidos");
        List<String> pedidosPendentes = new ArrayList<>();

        pedidosPendentes.addLast("Café com Leite");
        pedidosPendentes.addLast("Bolo de Chocolate");
        pedidosPendentes.addLast("Pão na Chapa");

        IO.println("Lista de pedidos: " + pedidosPendentes);
        IO.println("Tamanho total de pedidos: " + pedidosPendentes.size());

        String pedidoAtendido = pedidosPendentes.removeFirst();
        IO.println("Pedido atendido: " + pedidoAtendido);


        pedidosPendentes.addFirst("Suco de Laranja");

        IO.println("Fila de pedidos final: " + pedidosPendentes);
    }
}