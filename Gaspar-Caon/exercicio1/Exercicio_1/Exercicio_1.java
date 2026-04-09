/*
Crie um tabuleiro com n linhas por m colunas. Esse tabuleiro deve ser
preenchido com cinco letras (informadas pelo usuário) distribuídas
aleatoriamente.

Programa compilado na versão:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

import java.util.Scanner;
import java.util.Random;

public class Exercicio_1 {

	int n=2, m=3, quantidade=5;		
	String[] userInputList = new String[quantidade];	//arrays de tamanho fixo
	String[][] userMatrix = new String[n][m];
		
	Scanner kbdInputReader = new Scanner(System.in);
	Random randomizer = new Random();

	public static void main(String[] args) {	
	
		Exercicio_1 programa = new Exercicio_1();
		
		programa.recebe_input();
		programa.preenche_tabela();
		programa.mostra_tabela();
		programa.kbdInputReader.close();
	}
	
	  /////////////////////////////
	 // DECLARAÇÃO DOS MÉTODOS: //
	/////////////////////////////
		
	public void recebe_input() {	
		System.out.println("Escolha 5 letras. A cada letra escolhida, pressione Enter:");
		for (int i=0; i<quantidade; i++) {
			String userInput = kbdInputReader.next();
			userInputList[i] = userInput;
		}
	}
			
	public void preenche_tabela() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				userMatrix[i][j] = userInputList[randomizer.nextInt(quantidade)];
			}
		}
	}
		
	public void mostra_tabela() {
		/* Mostra tabela no formato:
		[ a b c ]
		[ x y z ] */
		
		for (int i=0; i<n; i++) {
			System.out.print("[ ");
				
			for (int j=0; j<m; j++) {
				System.out.print(userMatrix[i][j] + " ");
			}
			
			System.out.println("]");
		}
		
	}
}
