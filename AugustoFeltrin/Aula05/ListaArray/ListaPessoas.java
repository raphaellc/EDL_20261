package ListaArray;
import java.util.List;
import java.util.ArrayList;

public class ListaPessoas {
    private List<Pessoa> lista;

    public ListaPessoas(){
        this.lista = new ArrayList<>();
    }

    public void inserir(Pessoa pessoa){
        lista.add(pessoa);
    }

    public void remover(String nome){
        lista.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }

    public Pessoa buscar(String nome){
        for(Pessoa p : lista){
            if(p.getNome().equalsIgnoreCase(nome)){
                return p;
            }
        }
        return null;
    }

    public void percorrer(){
        if(lista.isEmpty()){
            System.out.println("Lista vazia");
        } else {
            for (Pessoa p : lista) {
                System.out.println(p);
            }
        }
    } 
}
