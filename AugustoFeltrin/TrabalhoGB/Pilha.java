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

    public T getTopo(){
        if(estaVazia()){
            throw new RuntimeException("getTopo: A pilha está vazia");
        }
        return topo.getDado();
    }

    public T desempilhar(){
        if(estaVazia()){
            throw new RuntimeException("Desempilhar: A pilha está vazia");
        }
        tamanho--;
        T dadoTemp = topo.getDado();
        topo = topo.getProximo();
        return dadoTemp;
    }

    public int getTamanho(){
        return tamanho;
    }

    public boolean estaVazia(){
        return tamanho == 0;
    }

    public void listaPilha(){
        if(estaVazia()){
            return;
        }

        No<T> noLista = this.topo;
        while (noLista != null) {
            System.out.println(" - " + noLista.getDado());
            noLista = noLista.getProximo();
        }
    }
}