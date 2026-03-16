package hoerlle.denian.aula1;

public class Exercicio2 {
    public static void main(String[] args) {
        Produto churrasqueiraControleRemoto = new Produto(500, 100);

        printProductInfo(churrasqueiraControleRemoto);

        churrasqueiraControleRemoto.setEstoque(99);
        churrasqueiraControleRemoto.setPreco(450);

        printProductInfo(churrasqueiraControleRemoto);

        churrasqueiraControleRemoto.setEstoque(-1);
        churrasqueiraControleRemoto.setPreco(-1);

    }

    static void printProductInfo(Produto produto) {
        System.out.println("Preço do produto: " + produto.getPreco());
        System.out.println("Estoque do produto: " + produto.getEstoque());
    }
}

class Produto {
    private float preco;
    private int estoque;

    Produto(float preco, int estoque) {
        this.preco = preco > 0 ? preco : 0;
        this.estoque = Math.max(estoque, 0);
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if (preco < 0) System.out.println("Negativo não né, camarada?");
        else this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0) System.out.println("Negativo não né, camarada?");
        else this.estoque = estoque;
    }
}
