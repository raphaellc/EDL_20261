/*
Implemente um programa que receba como entrada somente números inteiros
positivos e imprima apenas os que estejam no intervalo de 5 a 15. O Programa
deve terminar quando for digitado o valor 0.

Programa compilado na versão:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

import java.util.Scanner;

public class Exercicio_3 {
	
	Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {	
	
		Exercicio_3 programa = new Exercicio_3();
		
		System.out.println("Digite apenas números inteiros. Pressione Enter após cada escolha. Digite 0 para sair.");
		
		programa.recebeDados();
		
	}
	
	  /////////////////////////////
	 // DECLARAÇÃO DOS MÉTODOS: //
	/////////////////////////////
	
	public void recebeDados() {
		int n = userInput.nextInt();
	
		if (n == 0) {
			System.out.println("Você escolheu 0. Programa encerrado.");
			return;
		}
		
		if ((5 <= n) && (n <= 15)) {
			System.out.println("Você escolheu " + n);
		}
			
		recebeDados();	//utilização de recursão
	}
}
