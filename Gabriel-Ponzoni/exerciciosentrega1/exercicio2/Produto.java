package exerciciosentrega1.exercicio2;

public class Produto {
    //atributos
    private float preco;
    private int estoque;

    //construtor
    Produto(float preco, int estoque){
        if (preco < 0){
            this.preco = 0;
        } else {
            this.preco = preco;
        }

        if (estoque < 0){
            this.estoque = 0;
        } else {
            this.estoque = estoque;
        }
    }

    //getter e setters
    public float getPreco() {
        return preco;
    }

    public void setPreco(float novoPreco) {
        if (novoPreco < 0){
            IO.println("Não permitido valor negativo!");
        } else {
            this.preco = novoPreco;
        }
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int novoEstoque) {
        if (novoEstoque < 0){
            IO.println("Não permitido valor negativo!");
        } else {
            this.estoque = novoEstoque;
        }
    }
    
    
}
