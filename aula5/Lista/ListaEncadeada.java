package Lista;

import No.No;
import java.util.Optional;

public class ListaEncadeada<T> implements ILista<T> {
    private No<T> inicio;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    @Override
    public void adicionar(T dado) {
        if (this.inicio == null) {
            this.inicio = new No<>(dado);
            tamanho++;
            return;
        }
        No<T> noAux = this.inicio;
        while (noAux.getProximo() != null) {
            noAux = noAux.getProximo();
        }
        noAux.setProximo(new No<>(dado));
        tamanho++;
    }

    @Override
    public boolean adicionar(int posicao, T dado) {
        if (posicao < 0 || posicao > tamanho) return false;

        if (posicao == 0) {
            this.inicio = new No<>(dado, this.inicio);
            tamanho++;
            return true;
        }

        No<T> noAux = this.inicio;
        for (int i = 0; i < posicao - 1; i++) {
            noAux = noAux.getProximo();
        }
        noAux.setProximo(new No<>(dado, noAux.getProximo()));
        tamanho++;
        return true;
    }

    @Override
    public Optional<T> obter(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return Optional.empty();

        No<T> noAux = this.inicio;
        for (int i = 0; i < posicao; i++) {
            noAux = noAux.getProximo();
        }
        return Optional.of(noAux.getDado());
    }

    @Override
    public boolean remover(int posicao) {
        if (this.inicio == null || posicao < 0 || posicao >= tamanho) return false;

        if (posicao == 0) {
            this.inicio = this.inicio.getProximo();
            tamanho--;
            return true;
        }

        No<T> noAux = this.inicio;
        for (int i = 0; i < posicao - 1; i++) {
            noAux = noAux.getProximo();
        }
        noAux.setProximo(noAux.getProximo().getProximo());
        tamanho--;
        return true;
    }

    @Override
    public boolean remover(T dado) {
        if (this.inicio == null) return false;

        if (this.inicio.getDado().equals(dado)) {
            this.inicio = this.inicio.getProximo();
            tamanho--;
            return true;
        }

        No<T> noAux = this.inicio;
        while (noAux.getProximo() != null) {
            if (noAux.getProximo().getDado().equals(dado)) {
                noAux.setProximo(noAux.getProximo().getProximo());
                tamanho--;
                return true;
            }
            noAux = noAux.getProximo();
        }
        return false;
    }

    @Override
    public boolean contemNaLista(T dado) {
        No<T> noAux = this.inicio;
        while (noAux != null) {
            if (noAux.getDado().equals(dado)) return true;
            noAux = noAux.getProximo();
        }
        return false;
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    @Override
    public boolean estaVazia() {
        return this.inicio == null;
    }

    @Override
    public void limpar() {
        this.inicio = null;
        this.tamanho = 0;
    }

    @Override
    public String toString() {
        if (estaVazia()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        No<T> noAux = this.inicio;
        while (noAux != null) {
            sb.append(noAux.getDado());
            if (noAux.getProximo() != null) sb.append(" -> ");
            noAux = noAux.getProximo();
        }
        sb.append("]");
        return sb.toString();
    }
}
