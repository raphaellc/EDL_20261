package aula2;

import java.util.ArrayList;

import aula2.utilidades.ClasseAmiga;

public class Main {
    static void main() {
        IO.println("Olá Mundo");
        var lista = new ArrayList<String>();
        lista.add("Java");
        lista.add("PHP");
        lista.add("Python");

        IO.println(lista);

        ClasseAmiga amiga = new ClasseAmiga("Robozinha");
        IO.println("Sou " + amiga.getNome());
    }
}
