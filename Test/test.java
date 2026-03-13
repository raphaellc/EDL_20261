package main;
import main.ClasseAmiga;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World");
	
	ClasseAmiga nomvariavel = new ClasseAmiga("driftin my shi");
			nomvariavel.getNome();
			System.out.println(nomvariavel.getNome());
			
			ArrayList<String> lista = new ArrayList<>();
			LinkedList<String> listaLigada = new LinkedList<>();
			listaLigada.addFirst("Arthur Morgan");
			listaLigada.add("Dutch van der Linde");
			listaLigada.addLast("John Marston");
			lista.add("Java");
			lista.add("Python");
			lista.add(1, "PHP");
			
			System.out.println(lista);
			System.out.println(listaLigada);
			System.out.println();
			
			for (String s : lista) {
				System.out.println(s);
				
			}
			
			System.out.println();
			
			for (String s : listaLigada) {
				System.out.println(s);
				
			}
}
}