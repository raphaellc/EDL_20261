package aula2;

import aula2.utilidades.ClasseAmiga;
import java.util.ArrayList;
import java.util.LinkedList;
public class HelloWorld {
    public static void main(String[] args){
        System.out.println("Olá Mundo");
        ArrayList<String> lista = new ArrayList<>();
        LinkedList<String> listaLigada = new LinkedList<>();
        listaLigada.addFirst("pizza");
        listaLigada.addLast("lasanha");
        listaLigada.add("feijao");
        lista.add("Java");
        lista.add("PHP");
        lista.add("Python");
        lista.add(1, "C#");

        IO.println("Lista " + lista);

        lista.set(1,"C++");
        
        
        //System.out.println(lista);
        //IO.println(lista);
        //IO.println(lista.get(0));
        IO.println("Lista Ligada"+listaLigada);
        //IO.println("Lista Ligada "+listaLigada.get(2));

        for (String s : lista){
            IO.println(s);
        }

        ClasseAmiga amiga = new ClasseAmiga("Robozinha");

        IO.println("Sou "+ amiga.getNome());
    }
}
