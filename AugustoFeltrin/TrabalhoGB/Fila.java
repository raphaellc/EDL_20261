package AugustoFeltrin.TrabalhoGB;

public class Fila<T> {
    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    public Fila(){
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }  

    public void enfileirar(T dado){
        No<T> novoNo = new No<T>(dado);
        if(estaVazia()){
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            novoNo.setAnterior(fim);
            fim = novoNo;
        }
        tamanho++;
    }

    public T desenfileirar(){
        T dadoRetorno = null;
        if(estaVazia()){
            return dadoRetorno;
        } else if (tamanho == 1){
            dadoRetorno = this.inicio.getDado();
            this.inicio = null;
            this.fim = null;
        } else {
            dadoRetorno = this.inicio.getDado();
            this.inicio = this.inicio.getProximo();
            this.inicio.setAnterior(null);
        }
        tamanho--;
        return dadoRetorno;
    }

    public T frente(){
        return this.inicio.getDado();
    }

    public int getTamanho(){
        return tamanho;
    }

    public boolean estaVazia(){
        return tamanho == 0;
    }
}
