import java.util.ArrayList;
import java.util.List;


class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return nome + ", " + idade + " anos";
    }
}


class ListaPessoas {
    private List<Pessoa> lista = new ArrayList<>();

    public void inserir(Pessoa p) {
        lista.add(p);
    }

    public void remover(String nome) {
        lista.removeIf(p -> p.nome.equalsIgnoreCase(nome));
    }

    public Pessoa buscar(String nome) {
        for (Pessoa p : lista) {
            if (p.nome.equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public void percorrer() {
        for (Pessoa p : lista) {
            System.out.println(p);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        ListaPessoas lista = new ListaPessoas();

        // Entrada
        lista.inserir(new Pessoa("Alice", 30));
        lista.inserir(new Pessoa("Bob", 25));
        lista.inserir(new Pessoa("Carlos", 40));

      
        lista.percorrer();

        System.out.println("\nRemovendo Bob...\n");
        lista.remover("Bob");

        lista.percorrer();

        System.out.println("\nBuscando Alice:");
        Pessoa buscada = lista.buscar("Alice");
        if (buscada != null) {
            System.out.println(buscada);
        }
    }
}
