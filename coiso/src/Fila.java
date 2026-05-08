public class Fila<T> {

    No<T> inicio;
    No<T> fim;
    int tamanho;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void inserirFila(T dado) {
        No<T> novoNo = new No(dado);
        if (estaVazia()) {
            this.inicio = novoNo;
            this.fim = this.inicio;
        } else {
            novoNo.setProximo(this.fim);
            this.fim.setAnterior(novoNo);
            this.fim = novoNo;
        }
        tamanho++;
    }

    public T removerFila() {
        T dadoRetorno;
        if (estaVazia()) {
            return null;
        } else if (tamanho == 1){
            dadoRetorno = this.inicio.getDado();
            this.inicio = null;
            this.fim = null;
            tamanho--;
            return dadoRetorno;
        } else {
            dadoRetorno = this.inicio.getDado();
            this.inicio = this.inicio.getAnterior();
            this.inicio.setProximo(null);
        }
        tamanho--;
        return dadoRetorno;
    }

    public T frenteFila() {
        return this.inicio.getDado();
    }

    public int tamanhoFila() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }
}
