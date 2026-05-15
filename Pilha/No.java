public class No<T> {
    private No<T> proximo;
    private T dado;

    public No(T dado) {
        this.dado = dado;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public T getDado() {
        return dado;
    }
    
    public void setDado(T dado) {
        this.dado = dado;
    }
    
}
