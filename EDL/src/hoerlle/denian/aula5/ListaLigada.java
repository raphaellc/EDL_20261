public class ListaLigada<T> {
    private Node<T> cabeca;
    private int tamanho;

    ListaLigada() {
        this.tamanho = 0;
    }

    ListaLigada(T dado) {
        this.cabeca = new Node<T>(dado);
        this.tamanho = 1;
    }

    public void adicionarUltimo(T dado) {
        if (cabeca == null) cabeca = new Node<T>(dado);
        else pegaUltimoNo(this.cabeca).setProximo(new Node<T>(dado));
        this.tamanho++;
    }

    public void removerUltimo() {
        removeUltimo(cabeca);
    }

    public void adicionarPrimeiro(T dado) {
        Node<T> novoNode = new Node<T>(dado);
        novoNode.setProximo(cabeca);
        cabeca = novoNode;
        this.tamanho++;
    }

    public void removerPrimeiro(int posicao) {
        cabeca = cabeca.getProximo();
        this.tamanho--;
    }

    private Node<T> pegaUltimoNo(Node<T> noAtual) {
        Node<T> proximo = noAtual.getProximo();
        if (proximo != null) return pegaUltimoNo(proximo);
        return noAtual;
    }

    private Node<T> removeUltimo(Node<T> noAtual) {
        Node<T> proximo = noAtual.getProximo();

        if (proximo == null) return null;

        noAtual.setProximo(removeUltimo(proximo));

        return noAtual;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void test() {
        System.out.println("Ultimo antes: " + pegaUltimoNo(cabeca).getDado());
        removerUltimo();
        System.out.println("Ultimo depois: " + pegaUltimoNo(cabeca).getDado());
    }

}
