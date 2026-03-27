package main;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
	
	public static long multiplication(long a, long b) {
		
		if (b == 0) {
			return 0L;
		}
		
		return (a + multiplication(a, b -1));
			
	
		
		}
	
	public static void main(String[] args) {
	    
		int menu = 1;
		int choice;
		
		while (menu == 1) {
			
			System.out.println("Escolha o exercicio:\n"
					+ " 1 - Aula passada \n"
					+ " 2 - Paranaues de Vetor \n"
					+ " 3 - Panificadora ''Sabor Caseiro'' da Desgraça \n"
					+ " 4 - Exercicio de Recursividade \n"
					+ " 5 - Templates em Java \n");
			
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
				
				System.out.println("[=[ Treco de Vetor ]=]");
				
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
				
				vetor.remove(0);
				vetor.addLast(1);
				System.out.println("Vetor Esquerdado: " + vetor);
				
				vetor.remove(0);
				vetor.addLast(2);
				System.out.println("Vetor mais Esquerdado: " + vetor);
				
				menu = 0;
			}
			
			else if (choice == 3) {
				System.out.println("[=[ Treco de Estoque ]=]");
				
				ArrayList<String> Stock = new ArrayList<String>();
				ArrayList<String> Daily_Stock = new ArrayList<String>();
				ArrayList<String> Pending_Stock = new ArrayList<String>();
				
				Estoque_Panificadora Estoque = new Estoque_Panificadora(Stock);
				Estoque_Panificadora Estoque_do_Dia = new Estoque_Panificadora(Daily_Stock);
				Estoque_Panificadora Lista_Pendente = new Estoque_Panificadora(Pending_Stock);
				
				
				System.out.println("Estoque Normal: " + Stock);
				
				Stock.add("Crossaint");
				Stock.addFirst("Pão Doce");
				
				System.out.println("Estoque pós novas coisas: " + Stock);
				
				Stock.remove(4);
				
				System.out.println("Estoque pós um retardado comer a porra do Sonho: " + Stock);
				
				System.out.println("Numero de bolos de cenoura: " +	Stock.stream().filter(item->item.equals("Bolo de Cenoura")).count() );
				System.out.println("Numero de razões para esse código funcionar: " + Stock.stream().filter(item->item.equals("Brigadeiro")).count() );
				
				
				System.out.println("Estoque em ordem reversa: " + Stock.reversed());
				Daily_Stock.sort(Comparator.reverseOrder());
				System.out.println("Estoque do dia em ordem alfabetica reversa: " + Daily_Stock);
				
				
				Daily_Stock.sort(Comparator.naturalOrder());
				System.out.println("Estoque do dia em ordem alfabetica: " + Daily_Stock);

				
				ArrayList<String> Main_List = new ArrayList<String>();
				Main_List.add("Pao");
				Main_List.add("Bolo");
				ArrayList<String> Verification_List = new ArrayList<String>(Main_List);
				Verification_List.add("O cu do professor");
				
				System.out.println("Lista Main: " + Main_List);
				System.out.println("Lista de Verificação da Lista Main que funciona como um ponteiro para a região da memoria da Lista Main, assim fazendo um ALIASING: " + Verification_List);
				
				
				Pending_Stock.addLast("Café com Leite");
				Pending_Stock.addLast("Bolo de Chocolate");
				Pending_Stock.addLast("Pão na Chapa");
				
				System.out.println("Lista Pendente: " + Pending_Stock);
				System.out.println("Tamanho da Lista Pendente: " + Pending_Stock.size());
				
				Pending_Stock.removeFirst();
				System.out.println("Lista Pendente sem o primeiro item: " + Pending_Stock);
				
				Pending_Stock.addFirst("Suco de Laranja");
				System.out.println("Lista Pendente nova / Fila de pedidos: " + Pending_Stock);
				
				menu = 0;
			}
			
			
			else if (choice == 4) {
				System.out.println("[=[ Treco de Recursividade ]=]");
				
				System.out.println(
						  "a) Multiplicar inteiros por meio de somas sucessivas;\n"
						+ "b) Verificar se uma palavra é um palíndromo;\n"
						+ "c) Contar quantas vezes o caractere c ocorre na string s, onde o caractere e a string são fornecidos como parâmetro;\n"
						+ "d) Calcular a soma dos dígitos de um número inteiro e positivo, onde o número é fornecido como parâmetro. Por exemplo, a chamada da função para o valor 12345 deve retornar 15;\n"
						+ "e) Retornar um valor inteiro e positivo em ordem reversa, onde o valor é fornecido como parâmetro. Por exemplo, a chamada da função para o valor 123 deve retornar 321. Obs.: Não utilizar string para representar o valor;\n"
						+ "f) Escrever em ordem os valores inteiros de x a y, onde x e y são fornecidos como parâmetro. Obs.: A lista a ser escrita pode estar em ordem crescente ou decrescente;\n"
						+ "g) Calcular o máximo divisor comum entre dois números inteiro e positivos, onde os dois números são fornecidos como parâmetro;\n"
						+ "h) Achar maior elemento de um vetor;\n"
						+ "i) Achar um elemento em um vetor ordenado de comprimento potência de 2.");
				
		
				int Famoso_A = 3;
				int Famoso_B = 2;
				
				System.out.println(Famoso_A + " Vezes " + Famoso_B + " Igual: " + multiplication(Famoso_A, Famoso_B));
				
				menu = 0;
			}
			
			else if (choice == 5) {
				System.out.println("[=[ Treco de Template ]=]");
				
				No<Integer> No_1 = new No<Integer>(10);
				No<Integer> No_2 = new No<Integer>(30);
				No<Integer> No_3 = new No<Integer>(50);
				
				No_1.Set_Prox(No_2);
				No_2.Set_Prox(No_3);
				
				No<Integer> No_4 = new No<>(40, No_1);
				
				System.out.println(No_4.Get_Prox().Get_Prox().Get_Prox().Get_Dado());
				
				No<Integer> Novo_No = No_4.Get_Prox().Get_Prox().Get_Prox().Get_Prox();
				
				System.out.println(Novo_No != null ? Novo_No.Get_Dado() : "Vazio");
				
				// ? É Tipo if-else
				
				Lista_Encadeada<Integer> List_1 = new Lista_Encadeada<Integer>();
				
				
				List_1.add(No_1.Get_Dado());
				List_1.add(No_2.Get_Dado());
								
				List_1.Show_All_Elements(No_2.Get_Dado());
				
				menu = 0;
			}
			
		}
		
	}
}
