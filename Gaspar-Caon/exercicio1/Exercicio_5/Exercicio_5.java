/*
Elabore um programa que:
a. Declare um vetor de inteiros de 10 posições
b. Preencha o vetor
c. Imprima os valores do vetor de maneira invertida, do último elemento para o primeiro;
d. mostre o maior e o menor valor do vetor
e. faça a rotação à esquerda dos elementos do vetor, por exemplo, dado o
vetor [1,2,3,4,5] após uma rotação à esquerda o vetor ficará [2,3,4,5,1],
após nova rotação à esquerda o vetor ficará [3,4,5,1,2].

Programa compilado na versão:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

public class Exercicio_5 {
	
	int	tamanho = 10;
	int[] vetor	= new int[tamanho];

	public static void main(String[] args) {	
	
		Exercicio_5 programa = new Exercicio_5();
		
		programa.populaVetor();	
		programa.mostraVetor();
		programa.mostraVetorInvertido();
		programa.localizaMaxMin();
		programa.rotacionaEsquerda();
		programa.mostraVetor();
	}
	
	  /////////////////////////////
	 // DECLARAÇÃO DOS MÉTODOS: //
	/////////////////////////////
	
	public void populaVetor() {
		System.out.println("Populando um vetor de 10 componentes aleatoriemente com inteiros...");
		for (int i=0; i<tamanho; i++) {
			vetor[i] = (int)Math.floor(Math.random()*31 + 20);
		}
		System.out.println("OK");
	}
	
	public void mostraVetor() {
		System.out.println("Mostrando vetor:");
		System.out.print("[ ");
		for (int i=0; i<tamanho; i++) {
			System.out.print(vetor[i]
								+ " ");
		}
		System.out.println("]");
	}
	
	public void mostraVetorInvertido() {
		System.out.println("Mostrando vetor invertido:");
		System.out.print("[ ");	
		for (int i=tamanho-1; i>=0; i--) {
			System.out.print(vetor[i]
								+ " ");
		}
		System.out.println("]");	
	}
	
	public void localizaMaxMin() {
		System.out.println("Localizando máximo e mínimo...");
		
		int min, max;
		min = max = vetor[0];
		
		for (int i=1; i<tamanho; i++) {
			if (vetor[i] > max) {
				max = vetor[i];
			}
			if (vetor[i] < min) {
				min = vetor[i];
			}
		}
		System.out.println("O valor máximo é " + max);
		System.out.println("O valor mínimo é " + min);
	}
	
	public void rotacionaEsquerda() {
		System.out.println("Rotacionando à esquerda de um componente...");

		int dummy = vetor[0]; //variável necessária para guardar um valor durante a rotação de apenas 1 elemento
		
		for (int i=0; i<tamanho-1; i++) {
			vetor[i] = vetor[i+1];
		}
		vetor[tamanho-1] = dummy;
		System.out.println("OK");
	}
}
