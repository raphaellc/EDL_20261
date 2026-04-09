/*
Programa compilado na versão:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

import java.util.Scanner;

public class Exercicio_2 {

	public static void main(String[] args) {	
	
		Produto noteBookGamer = new Produto(8000, 15);
		Exercicio_2 programa = new Exercicio_2();
		
		programa.mostra_dados_produto(noteBookGamer);
				
		noteBookGamer.setPreco(8550.50f);
		noteBookGamer.setEstoque(14);
		
		programa.mostra_dados_produto(noteBookGamer);
		
		noteBookGamer.setPreco(-8550.50f);
		noteBookGamer.setEstoque(-14);
		
		programa.mostra_dados_produto(noteBookGamer);
	}
	
	  /////////////////////////////
	 // DECLARAÇÃO DOS MÉTODOS: //
	/////////////////////////////
	
	public void mostra_dados_produto(Produto produto_informado) {
		System.out.println("Preço do produto: "
							+ produto_informado.getPreco()
							+ "R$");
		System.out.println("Qtd em estoque: "
							+ produto_informado.getEstoque());
	}
}
