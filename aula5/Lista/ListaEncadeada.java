package Lista;

import No.No;

public class ListaEncadeada<T> {
    private No<T> inicio;
    private int tamanho;

    public ListaEncadeada(){
        this.inicio = null;
        this.tamanho = 0;
    }

    public void adicionar(T dado){
        if (this.inicio == null){
            this.inicio = new No<T>(dado);
            tamanho++;
            return;
        }
        //caso a lista não esteja vazia 
        //Encontrar o elemento cujo próximo seja igual a null
        //partindo do no inicial
        No<T> noAux = this.inicio;
        while (noAux.getProximo() != null){
            noAux = noAux.getProximo();
        }
        noAux.setProximo(new No<T>(dado));
        tamanho++;
        return;

    }

    public void mostrarTodosElementos(){
        if (inicio == null){
            IO.println("Lista vazia!");
            return;
        }
        No<T> noAux = this.inicio;
        while(noAux != null){
            IO.println(noAux.getDado());
            noAux = noAux.getProximo();
        }
        IO.println("Fim da Lista");

    }

}
