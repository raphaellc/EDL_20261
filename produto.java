public class produto {
    // Atributos privados
    private float preco;
    private int estoque;

    // Construtor com validação
    public produto(float preco, int estoque) {
        if (preco < 0) {
            this.preco = 0;
        } else {
            this.preco = preco;
        }

        if (estoque < 0) {
            this.estoque = 0;
        } else {
            this.estoque = estoque;
        }
    }

    // Getters e Setters
    public float getPreco() {
        return preco;
    }

    public void setPreco(float novoPreco) {
        if (novoPreco >= 0) {
            this.preco = novoPreco;
        } else {
            System.out.println("Erro: O preço não pode ser negativo.");
        }
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int novaQuantidade) {
        if (novaQuantidade >= 0) {
            this.estoque = novaQuantidade;
        } else {
            System.out.println("Erro: A quantidade em estoque não pode ser negativa.");
        }
    }
}