package aula2;

import java.util.ArrayList;
import java.util.LinkedList;

import aula2.utilidades.ClasseAmiga;

public class Main {
    static void main() {
        IO.println("Olá Mundo");
        var lista = new ArrayList<String>();
        var listaLigada = new LinkedList<String>();
        listaLigada.add("pizza");
        listaLigada.add("lasanha");
        listaLigada.add("feijao");
        IO.println("ListaLigada " + listaLigada);

        lista.add("Java");
        lista.add("PHP");
        lista.add("Python");

        IO.println(lista);
        IO.println(lista.get(0));

        for(String s : lista) {
            IO.println(s);
        }

        ClasseAmiga amiga = new ClasseAmiga("Robozinha");
        IO.println("Sou " + amiga.getNome());
    }
}
