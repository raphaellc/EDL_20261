package hoerlle.denian.aula2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EstoquePanificadora {
    public static void main(String[] args) {
        System.out.println("============== EXERCÍCIO 1 ==============");
        List<String> storage = exercise1();

        System.out.println("\n\n============== EXERCÍCIO 2 ==============");
        exercise2(storage);

        System.out.println("\n\n============== EXERCÍCIO 3 ==============");
        exercise3(storage);

        System.out.println("\n\n============== EXERCÍCIO 4 ==============");
        exercise4();

        System.out.println("\n\n============== EXERCÍCIO 5 ==============");
        exercise5();
    }

    public static List<String> exercise1() {
        // 1.1 - Crie uma classe chamada EstoquePanificadora e, no método main, inicialize um ArrayList
        // com ["Pão Francês", "Bolo de Cenoura", "Pão de Queijo", "Sonho", "Bolo de Cenoura"].
        List<String> storage = new ArrayList<>();

        storage.add("Pão Francês");
        storage.add("Bolo de Cenoura");
        storage.add("Pão de Queijo");
        storage.add("Sonho");
        storage.add("Bolo de Cenoura");

        // 1.2 - Adicione o item "Croissant" ao final da lista usando o método .add().
        storage.add("Croissant");

        // 1.3 - Adicione o item exatamente na primeira posição da lista (índice 0).
        storage.addFirst( "Pão Doce");

        // 1.4 - Um cliente comprou o último "Sonho". Remova-o da lista usando o método .remove().
        storage.remove("Sonho");

        // 1.5 - Imprima o estado atual do estoque no console.
        System.out.println(storage);

        return storage;
    }

    public static void exercise2(List<String> storage) {
        // 2.1 - Utilizando a lista modificada no exercício anterior, conte quantas vezes o item
        // "Bolo de Cenoura" aparece.
        long quantBoloCenouras = storage.stream().filter(item -> item.equals("Bolo de Cenoura")).count();

        // 2.2 - Tente contar quantas vezes aparece o item "Brigadeiro".
        long quantBrigadeiros = storage.stream().filter(item -> item.equals("Brigadeiro")).count();

        // 2.3 - Imprima ambos os resultados. Observe se o Java retorna um erro ou o número zero
        // quando o item não existe.
        System.out.println("Há " + quantBoloCenouras + " Bolos de Cenoura no estoque");
        System.out.println("Há " + quantBrigadeiros + " Brigadeiros no estoque");

    }

    public static void exercise3(List<String> storage) {
        // 3.1 - Organize a lista estoqueDoDia em ordem alfabética utilizando Comparator.naturalOrder().
        storage.sort(Comparator.naturalOrder());

        // 3.2 - Imprima a lista ordenada.
        System.out.println("Lista ordenada: ");
        System.out.println(storage);

        // 3.3 - Agora, imagine que um cliente VIP deseja ver os itens em ordem alfabética inversa (Z-A).
        storage.sort(Comparator.reverseOrder());
        System.out.println("Lista reversa: ");
        System.out.println(storage);

    }

    public static void exercise4() {
        // 4.1 - Crie uma lista chamada estoquePrincipal com os itens: ["Pão", "Bolo"].
        List<String> estoquePrincipal = new ArrayList<>();
        estoquePrincipal.add("Pão");
        estoquePrincipal.add("Bolo");

        // 4.2 - Crie uma listaDeVerificacao que seja uma cópia independente da primeira.
        List<String> listaDeVerificacao = new ArrayList<>(estoquePrincipal);

        // 4.3 - Adicione um item qualquer apenas na listaDeVerificacao.
        listaDeVerificacao.add("Cueca virada");

        // 4.4 - Imprima ambas as listas e prove que a alteração em uma não afetou a outra.
        System.out.println("Lista 'estoquePrincipal': ");
        System.out.println(estoquePrincipal);

        System.out.println("Lista 'listaDeVerificacao': ");
        System.out.println(listaDeVerificacao);
    }

    public static void exercise5() {
        // 5.1 - Crie uma lista vazia chamada pedidosPendentes.
        List<String> pedidosPendentes = new ArrayList<>();

        // 5.2 - Simule a chegada de 3 pedidos adicionando-os ao final da lista: "Café com Leite",
        // "Bolo de Chocolate" e "Pão na Chapa"
        pedidosPendentes.add("Café com leite");
        pedidosPendentes.add("Bolo de Chocolate");
        pedidosPendentes.add("Pão na Chapa");

        // 5.3 - Imprima a lista e o tamanho total (método .size()).
        System.out.println("Lista: " + pedidosPendentes);
        System.out.println("Tamanho: " + pedidosPendentes.size());

        // 5.4 Processe o primeiro pedido da fila (FIFO - First In, First Out) removendo-o.
        pedidosPendentes.removeFirst();

        // 5.5 - Um cliente prioritário chegou! Adicione o pedido "Suco de Laranja" no início da lista para
        // que ele seja o próximo a ser atendido.
        pedidosPendentes.addFirst("Suco de Laranja");
        System.out.println("Lista: " + pedidosPendentes);
    }
}
