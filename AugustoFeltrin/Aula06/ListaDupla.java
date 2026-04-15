package AugustoFeltrin.Aula06;

public class ListaDupla<T> {
    private No<T> inicio; 
    private int size;

    public ListaDupla(){
        this.size = 0;
    }

    public void addFirst(T dado){
        if(inicio == null){
            inicio = new No<T>(dado);
        } else {
            No<T> novoNo = new No<T>(dado);
            novoNo.setProximo(inicio);
            inicio.setAnterior(novoNo);
            inicio = novoNo;
        }
        size++;
    }

    public No<T> findLast(No<T> atual){
        if(atual.getProximo() != null){
            return findLast(atual.getProximo());
        }
        return atual;
    }

    public void addLast(T dado){
        if(inicio == null){
            inicio = new No<T>(dado);
        } else {
            No<T> ultimo = findLast(inicio);
            ultimo.setProximo(new No<T>(dado));
            ultimo.getProximo().setAnterior(ultimo);
        }
        size++;
    }

    public void removeFirst(){
        if(inicio != null){
            if(inicio.getProximo() == null){
                inicio = null;
         } else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        }
        size--;
        }
    }

    public void removeLast(){
    if(inicio != null){
        if(inicio.getProximo() == null){
            inicio = null;
        } else {
            No<T> ultimo = findLast(inicio);
            No<T> penultimo = ultimo.getAnterior();
            penultimo.setProximo(null);
        }
        size--;
        }
    }
    
    public boolean isEmpty(){
        return size == 0;
    }

}
