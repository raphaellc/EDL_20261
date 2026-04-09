/*
GASPAR CAON

Desafio de Programação:
Panificadora "Sabor Caseiro"

Programa compilado na versão:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

import java.util.ArrayList;
import java.util.Comparator;

public class EstoquePanificadora {
	
	public static void main(String[] args) {
	
		  //////////////////////////////////////////////////////////////
		 // 1. Organizando o Estoque: Inserção e Remoção                 
		//////////////////////////////////////////////////////////////
	
		ArrayList<String> estoque = new ArrayList<String>();		
		estoque.add("Pão Francês");
		estoque.add("Bolo de Cenoura");
		estoque.add("Pão de Queijo");
		estoque.add("Sonho");
		estoque.add("Bolo de Cenoura");
		
		System.out.println("\nEstoque atual: \n    " + estoque);
		
		  //////////////////////////////////////////////////////////////
		 // 2. Contando as Delícias: Streams e Filtros                 
		//////////////////////////////////////////////////////////////		
		
		System.out.println("\nnº de ocorrências para 'Bolo de Cenoura': " +
							estoque.stream().filter(item -> item.equals("Bolo de Cenoura")).count());									
		System.out.println("\nnº de ocorrências para 'Brigadeiro': " +
							estoque.stream().filter(item -> item.equals("Brigadeiro")).count());
							
		  //////////////////////////////////////////////////////////////
		 // 3. Arrume a Prateleira: Ordenação
		//////////////////////////////////////////////////////////////
		
		ArrayList<String> estoqueDoDia = new ArrayList<String>();	
		estoqueDoDia.add("Pão Francês");
		estoqueDoDia.add("Bolo de Cenoura");
		estoqueDoDia.add("Pão de Queijo");
		estoqueDoDia.add("Sonho");
		estoqueDoDia.add("Pastel");
		estoqueDoDia.add("Esfiha");
		
		System.out.println("\nEstoque do dia (desordenado): \n    " + estoqueDoDia);
		
		estoqueDoDia.sort(Comparator.naturalOrder());	//ordena itens por ordem alfabética (aceita alfanuméricos também)
		System.out.println("\nEstoque do dia (ordenado): \n    " + estoqueDoDia);
		
		estoqueDoDia.sort(Comparator.reverseOrder());
		System.out.println("\nEstoque do dia (ordem reversa): \n    " + estoqueDoDia);
		
		  //////////////////////////////////////////////////////////////
		 // 4. Referências de Memória e Cópia Segura               
		//////////////////////////////////////////////////////////////
		
		ArrayList<String> estoquePrincipal = new ArrayList<String>();
		estoquePrincipal.add("Pão");
		estoquePrincipal.add("Bolo");
		System.out.println("\nEstoque principal: \n    " + estoquePrincipal);

		ArrayList<String> estoqueCopia = new ArrayList<String>();	//apenas pointeiro/referência
		estoqueCopia = estoquePrincipal;
		System.out.println("\nCópia por ponteiro de estoque principal: \n    " + estoqueCopia);
		
		ArrayList<String> listaDeVerificacao = new ArrayList<>(estoquePrincipal);	//construtor copiador
		System.out.println("\nLista de verificação criada via construtor copiador: \n    " + estoquePrincipal);

		estoquePrincipal.add("Pizza");
		System.out.println("\nItem adicionado ao estoque principal: Pizza");
		System.out.println("\nEstoque principal: \n    " + estoquePrincipal);
		System.out.println("\nLista de verificação: \n    " + listaDeVerificacao);
		System.out.println("\nCópia por ponteiro de estoque principal: \n    " + estoqueCopia);	
		
		  //////////////////////////////////////////////////////////////
		 // 5. Teste Final: Sistema de Pedidos (FIFO)             
		//////////////////////////////////////////////////////////////
		
		ArrayList<String> pedidosPendentes = new ArrayList<String>();
		pedidosPendentes.add("Café com Leite");
		pedidosPendentes.add("Bolo de Chocolate");
		pedidosPendentes.add("Pão na Chapa");
		
		System.out.println("\nPedidos pendentes: " + pedidosPendentes.size() + "\n	" + pedidosPendentes);
		
		pedidosPendentes.removeFirst();
		System.out.println("\nPedidos pendentes: " + pedidosPendentes.size() + "\n	" + pedidosPendentes);
		
		pedidosPendentes.add(0,"Suco de Laranja");
		System.out.println("\nPedidos pendentes: " + pedidosPendentes.size() + "\n	" + pedidosPendentes);
		
		
	}
	
	  /////////////////////////////
	 // DECLARAÇÃO DOS MÉTODOS: //
	/////////////////////////////
	
}
