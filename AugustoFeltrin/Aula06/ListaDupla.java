package AugustoFeltrin.Aula06;

public class ListaDupla<T> {
    private No<T> inicio; 
    private int size;

    public ListaDupla(){
        this.inicio = null;
        this.size = 0;
    }

    public void addFirst(T dado){
        No<T> novo = new No<>(dado);

        if(inicio != null){
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
        }

        inicio = novo;
        size++;
    }

    public No<T> findLast(No<T> atual){
        if(atual.getProximo() == null){
            return atual;
        }
        return findLast(atual.getProximo());
    }

    public void addLast(T dado){
        No<T> novo = new No<>(dado);

        if(inicio == null){
            inicio = novo;
        } else {
            No<T> ultimo = findLast(inicio);
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
        }

        size++;
    }

    public void removeFirst(){
        if(inicio == null) return;

        if(inicio.getProximo() == null){
            inicio = null;
        } else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        }

        size--;
    }

    public void removeLast(){
        if(inicio == null) return;

        if(inicio.getProximo() == null){
            inicio = null;
        } else {
            No<T> ultimo = findLast(inicio);
            No<T> penultimo = ultimo.getAnterior();
            penultimo.setProximo(null);
        }

        size--;
    }

    public boolean buscar(T valor){
        No<T> atual = inicio;

        while(atual != null){
            if(atual.getDado().equals(valor)){
                return true;
            }
            atual = atual.getProximo();
        }

        return false;
    }

   @Override
    public String toString(){
        String s = "";
        No<T> atual = inicio;

        while(atual != null){
            s += atual.getDado() + " -> ";
            atual = atual.getProximo();
        }

        return s + "null";
    }

    public boolean isEmpty(){
        return size == 0;
    }

    
}