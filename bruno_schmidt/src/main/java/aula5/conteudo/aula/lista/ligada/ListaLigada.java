package aula5.conteudo.aula.lista.ligada;

import aula6.exercicio.aula.ListaEncadeada;

public class ListaLigada<T> implements ListaEncadeada<NoSimples<T>, T> {
    private NoSimples<T> inicio;
    private int tamanho = 0;

    public NoSimples<T> buscar(int pos) {
        return buscar(this.inicio, pos);
    }

    private NoSimples<T> buscar(NoSimples<T> noAtual, int pos) {
        if(pos == 0) {
            return noAtual;
        }

        return buscar(noAtual.getProximo(), pos - 1);
    }

    public void adicionar(T dado) {
        var noAtual = this.inicio;

        if(noAtual == null) {
            this.inicio = new NoSimples<>(dado);
            tamanho++;
            return;
        }

        while(noAtual.hasProximo()) {
            noAtual = noAtual.getProximo();
        }

        noAtual.setProximo(new NoSimples<>(dado));
        tamanho++;
    }

    public void remover(int pos) {
        if(pos < 0 || pos >= this.tamanho) {
            return;
        }

        remover(null, this.inicio, pos == 0 ? -1 : pos);

        tamanho--;
    }

    private NoSimples<T> remover(NoSimples<T> noAnterior, NoSimples<T> noAtual, int pos) {
        if(pos == -1) {
            var removido = this.inicio;
            this.inicio = noAtual.getProximo();
            return removido;
        }

        if(pos == 0) {
            noAnterior.setProximo(noAtual.getProximo());
            return noAtual;
        }

        return remover(noAtual, noAtual.getProximo(), pos-1);
    }

    public void atualizar(int pos, T novoDado) {
        if(pos == tamanho) {
            this.adicionar(novoDado);
            return;
        }

        if(pos > tamanho || pos < 0) {
            return;
        }

        atualizar(null, this.inicio, pos == 0 ? -1 : pos, novoDado);
    }

    private void atualizar(NoSimples<T> noAnterior, NoSimples<T> noAtual, int pos, T novoDado) {
        if(pos == -1) {
            NoSimples<T> noAntigo = this.inicio;
            this.inicio = new NoSimples<>(novoDado);

            if(noAntigo.hasProximo()) {
                this.inicio.setProximo(noAntigo.getProximo());
            }
        }

        if(pos == 0) {
            var novoNo = new NoSimples<>(novoDado);

            noAnterior.setProximo(novoNo);

            if(noAtual.hasProximo()) {
                novoNo.setProximo(noAtual.getProximo());
            }

            return;
        }

        atualizar(noAtual, noAtual.getProximo(), pos-1, novoDado);
    }

    public void mostrarTudo() {
        var atual = this.inicio;

        if(atual == null) {
            System.out.println("Lista vazia");
            return;
        }

        while(atual.hasProximo()) {
            System.out.print(atual.getDado() + " ");
            atual = atual.getProximo();
        }

        System.out.println(atual.getDado());
    }

    public int tamanho() {
        return this.tamanho;
    }
}
