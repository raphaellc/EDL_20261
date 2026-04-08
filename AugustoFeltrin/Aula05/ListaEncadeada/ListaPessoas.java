package ListaEncadeada;

public class ListaPessoas {
    private No inicio = null;

    public void inserir(Pessoa pessoa){
        No novoNo = new No(pessoa);

        if(inicio == null){
            inicio = novoNo;
        } else {
            No atual = inicio;
            while(atual.proximo != null){
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
    }

    public void remover(String nome){
        if (inicio == null) return;  
        
        if(inicio.getPessoa().getNome().equalsIgnoreCase(nome)){
            inicio = inicio.proximo;
            return;
        }

        No atual = inicio;
        while(atual.proximo != null){
            if(atual.proximo.getPessoa().getNome().equalsIgnoreCase(nome)){
                atual.proximo = atual.proximo.proximo;
                return;
            }
            atual = atual.proximo;
        }
        System.out.println("Pessoa não encontrada");
    }

    public Pessoa buscar(String nome){
        No atual = this.inicio;
        while(atual != null){
            if(atual.getPessoa().getNome().equalsIgnoreCase(nome)){
                return atual.pessoa;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public void percorrer(){
        if(inicio == null){
            System.out.println("Lista vazia");
            return;
        }
        No atual = inicio;
        while(atual != null){
            System.out.println(atual.pessoa);
            atual = atual.proximo;
        }
    }
}
