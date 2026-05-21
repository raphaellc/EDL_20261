package AugustoFeltrin.TrabalhoGB;

public class Pilha<T> {
    private No<T> topo;
    private int tamanho;

    public Pilha(){
        topo = null;
        tamanho = 0;
    }

    public void empilhar(T dado){
        No<T> novoNo = new No<T>(dado);
        novoNo.setProximo(topo);
        topo = novoNo;
        tamanho++;
    }

    public T desempilhar(){
        if(estaVazia()){
            throw new RuntimeException("Desempilhar: A pilha está vazia");
        }
        T dadoTemp = topo.getDado();
        topo = topo.getProximo();
        tamanho--;
        return dadoTemp;
    }

    public T getTopo(){
        if(estaVazia()){
            throw new RuntimeException("getTopo: A pilha está vazia");
        }
        return topo.getDado();
    }

    public int getTamanho(){
        return tamanho;
    }

    public boolean estaVazia(){
        return tamanho == 0;
    }

    public void listarPilha(){
        if(estaVazia()){
            return;
        }
        No<T> noLista = topo;
        while(noLista != null){
            System.out.println(" - " + noLista.getDado());
            noLista = noLista.getProximo();
        }
    }
}
