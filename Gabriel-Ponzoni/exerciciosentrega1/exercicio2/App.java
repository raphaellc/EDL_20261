package exerciciosentrega1.exercicio2;

public class App {
    public static void main(String[] args){
        Produto produto = new Produto(8000.00f,15);
        
        mostrarValor(false, produto.getPreco(), produto.getEstoque());
        produto.setPreco(8550.10f);
        produto.setEstoque(14);
        mostrarValor(true, produto.getPreco(), produto.getEstoque());
        produto.setPreco(-1.00f);
        produto.setEstoque(-1);
        mostrarValor(true, produto.getPreco(), produto.getEstoque());
    }

    public static void mostrarValor(boolean atualiza,float valor, int estoque){
        if (atualiza == true){
            IO.println("---  Valores Produto Atualizado ---");
        } else {
            IO.println("---  Valores Iniciais do Produto ---");
        }
        IO.println(String.format("Preço: %.2f", valor));
        IO.println(String.format("Estoque: %d", estoque));
    }
}
