/*
Elabore um programa que:
a. declare um vetor de inteiros de 10 posições,
b. Preencha o mesmo com valores entre 20 e 50.
c. Imprima o resultado da soma de todos os 10 valores preenchidos.

Programa compilado na versão:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

public class Exercicio_4 {
	
	int	tamanho = 10;
	int[] vetor	= new int[tamanho];

	public static void main(String[] args) {	
	
		Exercicio_4 programa = new Exercicio_4();
		
		System.out.println("Populando um vetor de 10 componentes aleatoriemente com inteiros...");
		programa.populaVetor();
		System.out.println("OK");
		System.out.println("Mostrando vetor:");
		programa.mostraVetor();
	}
	
	  /////////////////////////////
	 // DECLARAÇÃO DOS MÉTODOS: //
	/////////////////////////////
	
	public void populaVetor() {
		for (int i=0; i<tamanho; i++) {
			vetor[i] = (int)Math.floor(Math.random()*31 + 20);
		}
	}
	
	public void mostraVetor() {
		System.out.print("[ ");
		for (int i=0; i<tamanho; i++) {
			System.out.print(vetor[i]
								+ " ");
		}
		System.out.println("]");
	}
}
