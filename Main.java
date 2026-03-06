package main;
//import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
	    
	    Classe_Amiga amiga = new Classe_Amiga("Jorge");
	    
	    System.out.println(amiga.getNome());
	    
	    ArrayList<String> lista = new ArrayList<String>();
	    LinkedList<String> lista_ligada = new LinkedList<String>();
	    lista_ligada.addFirst("Churrasco");
	    lista_ligada.addLast("Arroz");
	    lista_ligada.add("Carne");
	    lista_ligada.add("Salsichão");
	    lista_ligada.add("Pão de Alho");
	    
	    
	    
	    lista.add("Java");
	    lista.add("Python");
	    lista.add("C++");
	    lista.add("SQL");
	    lista.add("Cobol");
	    lista.add(1,"C#");
	    
	    System.out.println("Lista Normal:" + lista);
	    System.out.println("Lista Ligada: " + lista_ligada);
	    System.out.println("Lista Ligada Diferenciada: " + lista_ligada.get(2));
	    
	   /*
	    
	    System.out.println(lista.get(0));
	    
	    for (String s : lista) {
	    	System.out.println(s);
	    }
	    
	    */
	}
}