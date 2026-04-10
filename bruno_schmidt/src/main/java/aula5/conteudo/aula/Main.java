package aula5.conteudo.aula;

import aula5.conteudo.aula.lista.ligada.ListaLigada;

public class Main {
    static void main() {
        var lista = new ListaLigada<Integer>();

        lista.adicionar(10);
        lista.adicionar(20);
        lista.adicionar(30);

        lista.mostrarTudo();
    }
}
