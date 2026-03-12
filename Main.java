package main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
	    
		int menu = 1;
		int choice;
		
		while (menu == 1) {
			
			System.out.println("Escolha o exercicio:\n"
					+ " 1 - Aula passada \n"
					+ " 2 - Paranaues de Vetor");
			
			Scanner cin = new Scanner(System.in);
			
			choice = cin.nextInt();
			
			cin.close();
			
			if (choice == 1) {
				
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
			
			    menu = 0;
			}
			
			else if (choice == 2) {
				
				ArrayList<Integer> vetor = new ArrayList<Integer>();
				vetor.add(1);
				vetor.add(2);
				vetor.add(3);
				vetor.add(4);
				vetor.add(5);
				vetor.add(6);
				vetor.add(7);
				vetor.add(8);
				vetor.add(9);
				vetor.add(10);
				
				System.out.println("Vetor de 10 numeros: " + vetor);
				
				System.out.println("Vetor de 10 numeros ao contrario: " + vetor.reversed());
				
				System.out.println("Maior e Menor valor do vetor: " + vetor.get(0) + " , " + vetor.get(9));
				
				int sum = 0;
				for (Integer total : vetor) { sum += total;	}
				
				System.out.println("Soma de Todos os valores do vetor: " + sum);
				
				
				menu = 0;
			}
	    
		}
		
	}
}
