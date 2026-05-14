package AugustoFeltrin.Aula10;

public class No<T> {
    private T dado;
    private No<T> proximo;
    private No<T> anterior;

    public No(T dado){
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }
    
    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }


    @Override
    public String toString() {
        return "No{" +
                "dado=" + dado +
                '}';
    }

}
