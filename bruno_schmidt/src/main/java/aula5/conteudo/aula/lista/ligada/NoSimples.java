package aula5.conteudo.aula.lista.ligada;

public class NoSimples<T> {
    private T dado;
    private NoSimples<T> proximo;

    protected NoSimples(T dado) {
        this.dado = dado;
    }

    NoSimples(T dado, NoSimples<T> proximo) {
        this.dado = dado;
        this.proximo = proximo;
    }

    public T getDado() {
        return dado;
    }

    public NoSimples<T> getProximo() {
        return proximo;
    }

    void setProximo(NoSimples<T> proximo) {
        this.proximo = proximo;
    }

    public boolean hasProximo() {
        return proximo != null;
    }
}
