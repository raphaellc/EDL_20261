package pimentel.luiza.aula1.exercicio2;

public class Main {
    public static void main(String[] args) {
        Produto notebook = new Produto(5200, 10);

        System.out.println("\n--- Valores Iniciais do Produto ---");
        printProductInfo(notebook);

        notebook.setPreco(4800);
        notebook.setEstoque(notebook.getEstoque() - 2);

        System.out.println("\n--- Valores Atualizados do Produto ---");
        printProductInfo(notebook);

        // Testando validação de preço negativo
        notebook.setPreco(-100);
        notebook.setEstoque(-100);

        printProductInfo(notebook);
    }

    public static void printProductInfo(Produto produto) {
        System.out.println("Preço do produto: R$" + produto.getPreco());
        System.out.println("Estoque do produto: " + produto.getEstoque());
    }
}
