package aula6.exercicio.aula.lista.pessoas.duplamente.encadeada;

import aula5.exercicio.Pessoa;
import aula6.exercicio.aula.ListaDuplamenteEncadeada;

public class ListaPessoasDuplamenteEncadeada {
    private final ListaDuplamenteEncadeada<Pessoa> lista;

    public ListaPessoasDuplamenteEncadeada() {
        this.lista = new ListaDuplamenteEncadeada<>();
    }

    public void inserir(Pessoa pessoa) {
        lista.adicionar(pessoa);
    }

    public void remover(String nome) {
        var indice = procurarIndice(nome);

        if(indice == -1) {
            return;
        }

        System.out.printf("Removendo %s...%n", nome);
        lista.remover(indice);
    }

    public Pessoa buscar(String nome) {
        var indice = procurarIndice(nome);
        return indice == -1 ? null : lista.buscar(indice).getDado();
    }

    private int procurarIndice(String nome) {
        int pos = 0;

        var elemento = lista.buscar(0);

        do {
            if(elemento.getDado().getNome().equals(nome)) {
                return pos;
            }

            pos++;
            elemento = lista.buscar(pos);
        } while(elemento.hasProximo());

        return -1;
    }

    public void percorrer() {
        for(int i = 0; i < lista.tamanho(); i++) {
            System.out.println(lista.buscar(i).getDado());
        }
    }
}
