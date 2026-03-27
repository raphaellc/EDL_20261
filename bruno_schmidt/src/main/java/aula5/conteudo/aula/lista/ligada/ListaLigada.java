package aula5.conteudo.aula.lista.ligada;

public class ListaLigada<T> {
    private No<T> inicio;
    private int tamanho = 0;

    public No<T> buscar(int pos) {
        return buscar(this.inicio, pos);
    }

    private No<T> buscar(No<T> noAtual, int pos) {
        if(pos == 0) {
            return noAtual;
        }

        return buscar(noAtual.getProximo(), pos - 1);
    }

    public void adicionar(T dado) {
        var noAtual = this.inicio;

        if(noAtual == null) {
            this.inicio = new No<>(dado);
            tamanho++;
            return;
        }

        while(noAtual.hasProximo()) {
            noAtual = noAtual.getProximo();
        }

        noAtual.setProximo(new No<>(dado));
        tamanho++;
    }

    public void remover(int pos) {
        if(pos < 0 || pos >= this.tamanho) {
            return;
        }

        remover(null, this.inicio, pos == 0 ? -1 : pos);

        tamanho--;
    }

    private No<T> remover(No<T> noAnterior, No<T> noAtual, int pos) {
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

    private void atualizar(No<T> noAnterior, No<T> noAtual, int pos, T novoDado) {
        if(pos == -1) {
            No<T> noAntigo = this.inicio;
            this.inicio = new No<>(novoDado);

            if(noAntigo.hasProximo()) {
                this.inicio.setProximo(noAntigo.getProximo());
            }
        }

        if(pos == 0) {
            var novoNo = new No<>(novoDado);

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
}
