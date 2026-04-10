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
    public void adicionar(int posicao, T dado){}
    public void contemNaLista(T dado){}

    public boolean remover(int posicao){
        if(this.inicio == null) return false;
        if (posicao <= this.tamanho){
            int pos_atual = 0;
            No<T> no_aux = this.inicio;
            No<T> no_ant = null;
            if (posicao == 0){
                this.inicio = no_aux.getProximo();
                tamanho--;
                return true;
            }else{
                while(pos_atual < posicao-1){
                    no_ant = no_aux;
                    no_aux = no_aux.getProximo();
                    pos_atual++;
                }
                no_ant.setProximo(no_aux.getProximo());
                tamanho--;
                return true;
            }
        }
        return false; 

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
