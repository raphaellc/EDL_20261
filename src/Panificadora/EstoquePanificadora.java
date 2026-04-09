package Panificadora;

import java.util.ArrayList;
import java.util.Comparator;

public class EstoquePanificadora {
    public static void main(String[] args) {

        ArrayList<String> produtos = new ArrayList<>();
        produtos.add("Pão Frances");
        produtos.add("Pão de Queijo");
        produtos.add("Sonho");
        produtos.add("Bolo de Cenoura");
        produtos.addLast("Croissant");
        produtos.addFirst("Pão Doce");

        System.out.println("=== PADARIA ABERTA: ESTOQUE INICIAL ===");
        System.out.println("Produtos: " + produtos);
        pausar(2000);

          System.out.println("\n[CLIENTE] - 'Me vê o último sonho, por favor?'");
        pausar(1500);
        produtos.remove("Sonho");
        System.out.println("[SISTEMA] - Sonho removido do estoque.");
        pausar(1000);

        System.out.println("\n[SISTEMA] - Verificando disponibilidade de itens específicos...");
        pausar(2000);
        long qtdBoloCen = produtos.stream().filter(item -> item.equals("Bolo de Cenoura")).count();
        long qtdBrigadeiro = produtos.stream().filter(item -> item.equals("Brigadeiro")).count();

        System.out.println("-> Bolos de Cenoura: " + qtdBoloCen);
        System.out.println("-> Brigadeiros: " + qtdBrigadeiro);
        pausar(1500);

        System.out.println("\n[SISTEMA] - Organizando a vitrine por ordem alfabética...");
        pausar(2000);
        produtos.sort(Comparator.naturalOrder());
        System.out.println("Vitrine organizada: " + produtos);
        pausar(1500);

        System.out.println("\n[GERENTE] - Criando lista de verificação para o fornecedor...");
        pausar(2000);
        ArrayList<String> estoquePrincipal = new ArrayList<>();
        estoquePrincipal.add("Pão");
        estoquePrincipal.add("Bolo");

        ArrayList<String> listaDeVerificacao = new ArrayList<>(estoquePrincipal);
        listaDeVerificacao.add("Café");

        System.out.println("Estoque Original: " + estoquePrincipal);
        System.out.println("Anotação (Cópia): " + listaDeVerificacao);
        System.out.println("[SISTEMA] - Verificação concluída. Listas independentes.");
        pausar(2000);

        System.out.println("\n=== INICIANDO SISTEMA DE PEDIDOS (Fila) ===");
        ArrayList<String> pedidosPendentes = new ArrayList<>();

        System.out.println("[BALCÃO] - Novos pedidos chegando...");
        pausar(1000);
        pedidosPendentes.addLast("Café com Leite");
        System.out.println("+ Café com Leite anotado.");
        pausar(1000);
        pedidosPendentes.addLast("Bolo de Chocolate");
        System.out.println("+ Bolo de Chocolate anotado.");
        pausar(1000);
        pedidosPendentes.addLast("Pão na Chapa");
        System.out.println("+ Pão na Chapa anotado.");

        System.out.println("Total na fila: " + pedidosPendentes.size());
        pausar(2000);

        System.out.println("\n[SISTEMA] - Processando primeiro pedido da fila...");
        pausar(1500);
        String processado = pedidosPendentes.removeFirst();
        System.out.println(">>> Saindo: " + processado + "!");
        pausar(1500);

        System.out.println("\n[CLIENTE VIP] - 'Com licença, tenho prioridade!'");
        pausar(1000);
        pedidosPendentes.addFirst("Suco de Laranja");
        System.out.println("[SISTEMA] - Suco de Laranja inserido no topo da fila.");
        pausar(1000);

        System.out.println("Fila atualizada: " + pedidosPendentes);
        System.out.println("=== FIM DO EXPEDIENTE ===");
    }

    public static void pausar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}