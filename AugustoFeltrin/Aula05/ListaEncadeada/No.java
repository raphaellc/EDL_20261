package ListaEncadeada;

public class No {
    Pessoa pessoa;
    No proximo;

    public No(Pessoa pessoa){
        this.pessoa = pessoa;
        this.proximo = null;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
