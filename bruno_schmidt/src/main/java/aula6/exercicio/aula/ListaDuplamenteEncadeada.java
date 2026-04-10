package aula6.exercicio.aula;

public class ListaDuplamenteEncadeada<T> implements ListaEncadeada<NoDuplo<T>, T> {
    private int tamanho;
    private NoDuplo<T> inicio;
    private NoDuplo<T> fim;

    public ListaDuplamenteEncadeada() {
        this.tamanho = 0;
        this.inicio = null;
        this.fim = null;
    }

    @Override
    public NoDuplo<T> buscar(final int pos) {
        if (pos < 0 || pos >= tamanho) return null;
        if (pos == 0) return inicio;
        if (pos == tamanho - 1) return fim;

        return buscaRecursiva(inicio.getProximo(), pos-1);
    }

    private NoDuplo<T> buscaRecursiva(NoDuplo<T> noAtual, final int pos) {
        if(pos == 0) return noAtual;

        return buscaRecursiva(noAtual.getProximo(), pos-1);
    }

    @Override
    public void adicionar(final T dado) {
        this.adicionarNo(dado, tamanho);
        tamanho++;
    }

    public void adicionar(final T dado, final int pos) {
        this.adicionarNo(dado, pos);
        tamanho++;
    }

    private void adicionarNo(final T dado, final int pos) {
        var novo = new NoDuplo<>(dado);
        NoDuplo<T> anterior;

        if(pos == 0) {
            anterior = inicio;
            inicio = novo;

            if(anterior != null) {
                anterior.setAnterior(novo);
                novo.setProximo(anterior);
            }

            return;
        } else if(pos == tamanho) {
            anterior = tamanho == 1 ? inicio : fim;
            fim = novo;

            anterior.setProximo(novo);
            novo.setAnterior(anterior);

            return;
        }

        var atualizado = this.buscar(pos);
        anterior = atualizado.getAnterior();

        anterior.setProximo(novo);
        novo.setAnterior(anterior);
        novo.setProximo(atualizado);
        atualizado.setAnterior(novo);
    }

    @Override
    public void remover(final int pos) {
        if(pos < 0 || pos >= tamanho) return;

        if(pos == 0) {
            var proximo = inicio.getProximo();
            proximo.setAnterior(null);
            inicio = proximo;
            return;
        }

        if(pos == tamanho - 1) {
            var anterior = fim.getAnterior();
            anterior.setProximo(null);

            fim = fim.getAnterior();
            return;
        }

        var atualizado = this.buscar(pos);
        var anterior = atualizado.getAnterior();
        var proximo = atualizado.getProximo();

        anterior.setProximo(proximo);
        proximo.setAnterior(anterior);
        tamanho--;
    }

    @Override
    public void atualizar(final int pos, final T novoDado) {
        var novo = new NoDuplo<>(novoDado);
        var antigo = this.buscar(pos);

        novo.setAnterior(antigo.getAnterior());
        novo.setProximo(antigo.getProximo());
        antigo.getAnterior().setProximo(novo);
        antigo.getProximo().setAnterior(novo);

        antigo.setAnterior(null);
        antigo.setProximo(null);
    }

    @Override
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

    @Override
    public int tamanho() {
        return this.tamanho;
    }
}
