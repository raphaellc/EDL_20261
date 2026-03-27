package aula5.conteudo.aula.lista.ligada;

public class No<T> {
    private T dado;
    private No<T> proximo;

    No(T dado) {
        this.dado = dado;
    }

    No(T dado, No<T> proximo) {
        this.dado = dado;
        this.proximo = proximo;
    }

    public T getDado() {
        return dado;
    }

    public No<T> getProximo() {
        return proximo;
    }

    void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public boolean hasProximo() {
        return proximo != null;
    }
}
