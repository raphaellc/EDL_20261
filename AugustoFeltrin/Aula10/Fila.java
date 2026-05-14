package AugustoFeltrin.Aula10;

public class Fila <T>{
    // Atributos
    No<T> inicio;
    No<T> fim;
    int tamanho;

    //Construtor
    public Fila(){
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    //Métodos: inserirFila, removerFila, tamanhoFila, vaziaFila
    public void inserirFila(T dado){
        No<T> novoNo = new No(dado);
        if(estaVazia()){
            this.inicio = novoNo;
            this.fim = this.inicio;
        } else {
            novoNo.setProximo(this.fim);
            this.fim.setAnterior(novoNo);
            this.fim = novoNo;
        }
        tamanho++;
    }

    public T removerFila(){
        T dado_retorno = null;
        if(estaVazia()){
            return dado_retorno;
        } else if (tamanho == 1) {
            dado_retorno = this.inicio.getDado();
            this.inicio = null;
            this.fim = null;
        } else {
            dado_retorno = this.inicio.getDado();
            this.inicio = this.inicio.getAnterior();
            this.inicio.setProximo(null);
        }
        tamanho--;
        return dado_retorno;
    }

    public T frenteFila(){
        return this.inicio.getDado();
    }

    public int tamanhoFila(){
        return tamanho;
    }

    public boolean estaVazia(){
        return tamanho == 0;
    }
}
