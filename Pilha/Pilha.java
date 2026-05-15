public class Pilha<T> {
    private No<T> topo;
    private int tamanho;

    public Pilha(){
        topo = null;
        tamanho = 0;
    }
    public Pilha(T dado){
        topo = new No<T>(dado);
        tamanho++;
    }
    public void empilhar(T dado){
        if(estaVazia()){
          topo = new No<T>(dado);
        }else{
            No<T> novo_no = new No<T>(dado);
            novo_no.setProximo(topo);
            topo = novo_no;
        }
        tamanho++;
    }
    public T getTopo(){
        if(estaVazia()) 
            throw new RuntimeException("getTopo: A pilha está vazia"); 
        return topo.getDado();
    }
    public T desempilhar(){
        if(estaVazia()) 
            throw new RuntimeException("Desempilhar: A pilha está vazia");
        tamanho--;
        T dado_temp = topo.getDado();
        topo = topo.getProximo();
        return dado_temp;
    }

    public int getTamanho(){
        return tamanho;
    }
    public boolean estaVazia(){
        return tamanho == 0;
    }

    public void listaPilha(){
        if (estaVazia()) {
            return;
        }

        No<T> noLista = this.topo;

        while (noLista.getProximo() != null) {
            System.out.println(" - " + noLista.getDado());
            noLista = noLista.getProximo();
        }
        noLista.getDado();
    }
}
