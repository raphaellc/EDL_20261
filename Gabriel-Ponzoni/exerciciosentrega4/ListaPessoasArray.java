package exerciciosentrega4;

import java.util.ArrayList;

public class ListaPessoasArray {
    ArrayList<Pessoa> list = new ArrayList<>();

    public void inserir(Pessoa p){
        list.add(p);
    }

    public void remover(String nome){
        Pessoa alvo = null;
        for (Pessoa pessoa : list) {
            if (pessoa.getNome().equalsIgnoreCase(nome)){
                alvo = pessoa;
                break;                
            }
        }
        if (alvo != null) {
            list.remove(alvo);
        } else {
            IO.println("Pessoa não encontrada.");
        }
    }

    public Pessoa buscar(String nome){  
        for (Pessoa pessoa : list) {
            if (pessoa.getNome().equalsIgnoreCase(nome)){
                return pessoa;
            }
        }
        return null;
    }

    public void percorrer(){
        for (Pessoa pessoa : list) {
            IO.println(pessoa);
        }
    }
}
