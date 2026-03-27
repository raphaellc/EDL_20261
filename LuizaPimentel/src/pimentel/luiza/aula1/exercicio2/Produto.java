package pimentel.luiza.aula1.exercicio2;

public class Produto {
    private float preco;
    private int estoque;

    public Produto(float preco, int estoque) {
        this.preco = preco < 0 ? 0 : preco; 
        this.estoque = estoque < 0 ? 0 : estoque;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float novoPreco) {
        if (novoPreco < 0) throw new IllegalArgumentException("O novo preço não deve ser negativo.");
        else this.preco = novoPreco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int novaQuantidade) {
        if (novaQuantidade < 0) throw new IllegalArgumentException("A nova quantidade em estoque não deve ser negativa.");
        else this.estoque = novaQuantidade;
    }

}
