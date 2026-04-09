package ListaDePessoas;

import java.util.ArrayList;

public class ListaPessoas {
    private ArrayList<Pessoa> lista;

    public ListaPessoas() {
        this.lista = new ArrayList<>();
    }

    // Inserir pessoa
    public void inserir(Pessoa pessoa) {
        lista.add(pessoa);
    }

    // Remover por nome
    public void remover(String nome) {
        // Utilizamos removeIf para encontrar o objeto com o nome correspondente e remover
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
        return null; // Retorna null (equivalente ao None) se não encontrar
    }

    // Percorrer e exibir
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

