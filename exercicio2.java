public class exercicio2 {
    public static void main(String[] args) {
        // a) Instanciar um objeto (Notebook Gamer)
        produto meuProduto = new produto(8000.00f, 15);

        // b) Mostrar valores iniciais
        System.out.println("--- Valores Iniciais do Produto ---");
        System.out.printf("Preço: R$ %.2f%n", meuProduto.getPreco());
        System.out.println("Estoque: " + meuProduto.getEstoque() + " unidades");
        System.out.println();

        // c) Atualizar valores (Alta do dólar e venda)
        meuProduto.setPreco(8550.50f);
        meuProduto.setEstoque(14);

        // d) Mostrar valores atualizados
        System.out.println("--- Valores Atualizados do Produto ---");
        System.out.printf("Preço: R$ %.2f%n", meuProduto.getPreco());
        System.out.println("Estoque: " + meuProduto.getEstoque() + " unidades");
        System.out.println();

        // e) Tentar definir valores inválidos
        System.out.println("--- Testando Proteção de Dados ---");
        meuProduto.setPreco(-100.00f);
        meuProduto.setEstoque(-5);
        
        // Confirmando que os valores não mudaram após a tentativa inválida
        System.out.printf("Preço final (deve ser 8550,50): R$ %.2f%n", meuProduto.getPreco());
        System.out.println("Estoque final (deve ser 14): " + meuProduto.getEstoque());
    }
}