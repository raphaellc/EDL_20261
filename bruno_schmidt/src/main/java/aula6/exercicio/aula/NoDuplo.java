package aula6.exercicio.aula;

public class NoDuplo<T> {
    private final T dado;
    private NoDuplo<T> proximo;
    private NoDuplo<T> anterior;

    public NoDuplo(T dado) {
        this.dado = dado;
    }

    public T getDado() {
        return dado;
    }

    public NoDuplo<T> getProximo() {
        return proximo;
    }

    public NoDuplo<T> getAnterior() {
        return anterior;
    }

    public void setProximo(NoDuplo<T> proximo) {
        this.proximo = proximo;
    }

    public void setAnterior(NoDuplo<T> anterior) {
        this.anterior = anterior;
    }

    public boolean hasAnterior() {
        return anterior != null;
    }

    public boolean hasProximo() {
        return proximo != null;
    }
}

