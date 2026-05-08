void main() {

    System.out.println("[=[ - [=[  Isso é um sinal que está tudo funcionando  ]=] - ]=]\n");

    Fila<String> Fila_Do_Super = new Fila<String>();

    System.out.println("Tentando remover uma fila vazia:");
   if (Fila_Do_Super.removerFila() == null) {
       System.out.println("Mais vazia q minha alma\n");
   };

    Fila_Do_Super.InserirFila("Obama");
    Fila_Do_Super.InserirFila("Bob Esponja");
    Fila_Do_Super.InserirFila("Mãe do Musculoso");

    System.out.println("Pessoa na frente da fila: " + Fila_Do_Super.frenteFila() + " || Tamanho da Fila: " + Fila_Do_Super.tamanhoFila());

    Fila_Do_Super.removerFila();

    System.out.println("Pessoa na frente da fila: " + Fila_Do_Super.frenteFila() + " || Tamanho da Fila: " + Fila_Do_Super.tamanhoFila());

}

public class No<T> {
    private T dado;
    private No<T> proximo;
    private No<T> anterior;

    public No(T dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }

    public T getDado()               { return dado; }
    public void setDado(T dado)      { this.dado = dado; }
    public No<T> getProximo()        { return proximo; }
    public void setProximo(No<T> p)  { this.proximo = p; }
    public No<T> getAnterior()       { return anterior; }
    public void setAnterior(No<T> a) { this.anterior = a; }
}


public class Fila<T> {
    No<T> inicio;
    No<T> fim;
    int tamanho;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void InserirFila(T dado){
        No<T> novoNo = new No(dado);

        if (Empty()) {
            this.inicio = novoNo;
            this.fim = this.inicio;
        }

        else {
            novoNo.setProximo(this.fim);
            this.fim.setAnterior(novoNo);
            this.fim = novoNo;
        }

        tamanho++;
    }
    public T removerFila(){

        T dado_return = null;
        if (Empty()) {
            return dado_return;
        }

        else if (tamanho == 1) {
            dado_return = this.inicio.getDado();
            this.inicio = null;
            this.fim = null;
            tamanho--;
            return dado_return;
        }

        else {
            dado_return = this.inicio.getDado();
            this.inicio = this.inicio.getAnterior();
            this.inicio.setProximo(null);
            tamanho--;
            return dado_return;
        }
    }
    public T frenteFila(){
        return this.inicio.getDado();
    }
    public int tamanhoFila(){
        return tamanho;
    }
    public boolean Empty(){
        return tamanho == 0;
    }

}