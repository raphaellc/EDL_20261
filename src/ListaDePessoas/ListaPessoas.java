package ListaDePessoas;

import java.util.ArrayList;

public class ListaPessoas {
    private ArrayList<Pessoa> lista;

    public ListaPessoas() {
        this.lista = new ArrayList<>();
    }

    public void inserir(Pessoa pessoa) {
        lista.add(pessoa);
    }

    public void remover(String nome) {
        boolean removido = lista.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
        if (removido) {
            System.out.println("\nRemovendo " + nome + "...");
        }
    }

    // Buscar por nome
    public Pessoa buscar(String nome) {
        for (Pessoa p : lista) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public void percorrer() {
        if (lista.isEmpty()) {
            System.out.println("A lista está vazia.");
        } else {
            for (Pessoa p : lista) {
                System.out.println(p);
            }
        }
    }
}

