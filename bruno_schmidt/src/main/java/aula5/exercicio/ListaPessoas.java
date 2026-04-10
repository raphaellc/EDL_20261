package aula5.exercicio;

import aula5.conteudo.aula.lista.ligada.ListaLigada;

public class ListaPessoas {
    private final ListaLigada<Pessoa> lista;

    public ListaPessoas() {
        this.lista = new ListaLigada<>();
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
