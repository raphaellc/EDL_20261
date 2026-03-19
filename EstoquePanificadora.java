import java.util.*;

public class EstoquePanificadora {
    public static void main(String[] args) {
        System.out.println("Panificadora Sabor Caseiro\n");
        
        System.out.println("ORGANIZAÇÃO ESTOQUE:\n");
        ArrayList<String> estoque= new ArrayList<>();
        estoque.add("Pão Francês");
        estoque.add("Bolo de Cenoura");
        estoque.add("Pão de Queijo");
        estoque.add("Sonho");
        estoque.add("Bolo de Cenoura");
        
        System.out.println("Estoque inicial: " + estoque);
        
        // add croassaint
        estoque.add("Croissant");
        System.out.println("Após adicionar Croissant: " + estoque);
        
        // add o pão doce na frente 
        estoque.add(0, "Pão Doce");
        System.out.println("Após adicionar Pão Doce no início: " + estoque);
        
        // remover o último "Sonho"
        estoque.remove("Sonho");
        System.out.println("Após remover Sonho: " + estoque);
        System.out.println();
        
        // contando delicias stream 
        System.out.println("CONTADOR:");
        long countBoloCenoura = estoque.stream()
                .filter(item -> item.equals("Bolo de Cenoura"))
                .count();
        System.out.println("Quantidade de 'Bolo de Cenoura': " + countBoloCenoura);
        
        long countBrigadeiro = estoque.stream()
                .filter(item -> item.equals("Brigadeiro"))
                .count();
        System.out.println("Quantidade de 'Brigadeiro': " + countBrigadeiro);
   

        System.out.println("ORGANIZAÇÃO PRATELEIRA\n");
        System.out.println("Estoque antes da ordenação: " + estoque);
        
        // ordem alfabética (A-Z)
        estoque.sort(Comparator.naturalOrder());
        System.out.println("Estoque A-Z: " + estoque);
        
        // ordem inversa (Z-A) para cliente VIP
        estoque.sort(Comparator.reverseOrder());
        System.out.println("Estoque Z-A (VIP): " + estoque);
        System.out.println();
        
        //copia memoria e ref segura = aliasing
        System.out.println("REFERÊNCIAS DE MEMÓRIA E CÓPIA SEGURA:");
        ArrayList<String> estoquePrincipal = new ArrayList<>();
        estoquePrincipal.add("Pão");
        estoquePrincipal.add("Bolo");
        System.out.println("Estoque Principal: " + estoquePrincipal);
        
        // copia independente
        ArrayList<String> listaDeVerificacao = new ArrayList<>(estoquePrincipal);
        System.out.println("listaDeVerificacao (cópia): " + listaDeVerificacao);
        
        // Adicionar item apenas na cópia
        listaDeVerificacao.add("Croissant");
        System.out.println("Após adicionar 'Croissant' apenas na cópia:");
        System.out.println("estoquePrincipal: " + estoquePrincipal);
        System.out.println("listaDeVerificacao: " + listaDeVerificacao);
        System.out.println("✓ Prova: estoquePrincipal NÃO foi alterado!");
        System.out.println();
        
        // teste final
        System.out.println("SISTEMA DE PEDIDOS");
        ArrayList<String> pedidosPendentes = new ArrayList<>();
        
        pedidosPendentes.add("Café com Leite");      
        pedidosPendentes.add("Bolo de Chocolate");
        pedidosPendentes.add("Pão na Chapa");
        
        System.out.println("Fila de pedidos iniciais: " + pedidosPendentes);
        System.out.println("Total de pedidos: " + pedidosPendentes.size());
        
        // processe o primeiro pedido
        String primeiroPedido = pedidosPendentes.removeFirst();
        System.out.println("\nProcessando pedido: " + primeiroPedido);
        System.out.println("Fila após processar primeiro pedido: " + pedidosPendentes);
        
        // prioridade = addfirst 
        pedidosPendentes.addFirst("Suco de Laranja");  // JDK 21+
        System.out.println("Cliente VIP adicionado no início: " + pedidosPendentes);
        
        System.out.println("Fila final de pedidos: " + pedidosPendentes);
        System.out.println("Total de pedidos pendentes: " + pedidosPendentes.size());
    }
}
