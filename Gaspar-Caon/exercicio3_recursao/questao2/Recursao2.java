/*
GASPAR CAON

Recursão - Questão 2
Implemente recursivamente os seguintes algoritmos.
a) Multiplicar inteiros por meio de somas sucessivas;
b) Verificar se uma palavra é um palíndromo;
c) Contar quantas vezes o caractere c ocorre na string s, onde o caractere e a string são
fornecidos como parâmetro;
d) Calcular a soma dos dígitos de um número inteiro e positivo, onde o número é fornecido
como parâmetro. Por exemplo, a chamada da função para o valor 12345 deve retornar 15;
e) Retornar um valor inteiro e positivo em ordem reversa, onde o valor é fornecido como
parâmetro. Por exemplo, a chamada da função para o valor 123 deve retornar 321. Obs.:
Não utilizar string para representar o valor;
f) Escrever em ordem os valores inteiros de x a y, onde x e y são fornecidos como parâmetro.
Obs.: A lista a ser escrita pode estar em ordem crescente ou decrescente;
g) Calcular o máximo divisor comum entre dois números inteiro e positivos, onde os dois
número são fornecidos como parâmetro;
h) Achar maior elemento de um vetor;
i) Achar um elemento em um vetor ordenado de comprimento potência de 2

Programa compilado na versão:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
//import java.util.Comparator;

public class Recursao2 {
	
	public static void main(String[] args) {

		Recursao2 programa = new Recursao2();

		System.out.println("\na) Multiplicar inteiros por meio de somas sucessivas:\n");
		System.out.println(" = " + programa.multiplicacao(7,5));
		
		System.out.println("\nb) Verificar se uma palavra é um palíndromo:\n");
		String palavra = "radhYdar";
		System.out.println("	Palavra é: " + palavra + "\n");
		System.out.println(programa.palindromo(palavra, 0, (palavra.length()-1)));	//Entra com índices iniciais das letras da palavra; isto é importante para isolá-los da chamada recursiva
		
		System.out.println("\nc) Contar quantas vezes o caractere c ocorre na string s,\nonde o caractere e a string são fornecidos como parâmetro.");
		String s = "sucesso";
		System.out.println("	Palavra é: " + s);
		System.out.println("	Contar ocorrências do caractere 's'");
		System.out.println(programa.contadorCaractere(s, 's', 0));
		
		System.out.println("\nd) Calcular a soma dos dígitos de um número inteiro e positivo,\nonde o número é fornecido como parâmetro. Por exemplo, a chamada da função para o valor 12345 deve retornar 15.");
		int numero = 2223;
		System.out.println("	Número de entrada: " + numero);
		System.out.println(programa.somaAlgarismos(numero,1));

		System.out.println("\ne) Retornar um valor inteiro e positivo em ordem reversa,\nonde o valor é fornecido como parâmetro. Por exemplo, a chamada da função para o valor 123 deve retornar 321.\nObs.: Não utilizar string para representar o valor;");
		numero = 987654321;
		System.out.println("	Número de entrada: " + numero);
		System.out.println(programa.inverterAlgarismos(numero,numero,1));
		System.out.println(programa.inverter(numero,0));
		
		System.out.println("\nf) Escrever em ordem os valores inteiros de x a y, onde x e y são fornecidos como parâmetro.\nObs.: A lista a ser escrita pode estar em ordem crescente ou decrescente");
		int x = -5;
		int y = 3;
		System.out.println("	Números de entrada: " + x + " e " + y);
		programa.ordenadorCrescente(x,y);
		
		System.out.println("\ng) Calcular o máximo divisor comum entre dois números inteiro e positivos,\nonde os dois números são fornecidos como parâmetro");
		int a = 30;
		int b = 20;
		System.out.println("	Números de entrada: " + a + " e " + b);
		System.out.println("MDC é "+ programa.MDC(a,b));
		
		System.out.println("\nh) Achar maior elemento de um vetor;");
		float[] vetor = new float[5];
		vetor[0] = 5.6f;
		vetor[1] = -0.4f;
		vetor[2] = 7.8f;
		vetor[3] = 17.999f;
		vetor[4] = -22.1f;
		int index = 1;
		float dummy_var = vetor[0];
		System.out.println(programa.maxElemento(vetor, index, dummy_var));
		
		System.out.println("\ni) Achar um elemento em um vetor ordenado de comprimento potência de 2");
		ArrayList<Integer> vetorOrdenado = new ArrayList<Integer>();
		for (int i=0; i<16; i++) {
			vetorOrdenado.add(i);
		}
		int valor = 5;
		System.out.println("	Seja v o vetor de 16 (2^4) elementos = [0, 1, 2, ... , 15]");
		System.out.println("	Valor de vetor[10] = " + vetorOrdenado.get(10));
		System.out.println("	Posição do valor " + valor + " = " + programa.localizaElemento(vetorOrdenado, valor));


	}
	
	  /////////////////////////////
	 // DECLARAÇÃO DE MÉTODOS:  //
	/////////////////////////////

	public int multiplicacao(int a, int b) {
		if (b==0 || a==0) return 0;
		if (b==1) {
			System.out.print(a);
			return a;
		}
		System.out.print(a + " + ");
		return a + multiplicacao(a, b-1);
	}
	
	public boolean palindromo(String palavra, int i, int j) {
		/* O método inicia com contadores i e j inicializados na 1ª chamada da função. Isto é necessário para que
		   a recorrência não os inicialize novamente com os mesmos valores. Esses contadores devem varrer toda
		   a palavra analisada. Para isso, seu valor é atualizado na chamada recursiva, utilizando ++i e --j.
		*/
		
		//Caso trivial
		if (i >= j) return true;
		
		//Compara primeiro e último caractere; muda índices uma unidade para direita/esquerda
		if (palavra.charAt(i) != palavra.charAt(j)) {
			return false;
		} else {
			return palindromo(palavra, ++i, --j);	//Importante: incrementar i e j antes de executar a linha (++i e não i++);
		}
	}
	
	public int contadorCaractere(String s, char c, int index) {
		/* Inicia com index=0 para varrer cada caractere. Enquanto não atingir o último caractere
		   da String, a função deve retornar 0 ou 1.
		*/

		if (index < s.length()) {
			if (s.charAt(index) == c) return 1 + contadorCaractere(s, c, ++index);
			else return 0 + contadorCaractere(s, c, ++index);		
		} return 0;
	}
	
	public int somaAlgarismos(int n, int casaDecimal) {
		/* Extrai as unidades/dezenas/centenas/milhares... com operador modulus % (resto da divisão),
			para obter o algarismo necessário. Quando a casa decimal ultrapassar o número, encerra.
		*/
		
		if (casaDecimal > n) return 0;

		casaDecimal *= 10;
		return (n % casaDecimal) * 10 / casaDecimal + somaAlgarismos(n - (n % casaDecimal), casaDecimal);
	}
	
	public int inverterAlgarismos(int nOriginal, int n, int casaDecimal) {
		/* Guarda nOriginal para caso-base.
		   Localiza a maior casa decimal. Extrai as centenas/dezenas/unidades...
		   e multiplica, respectivamente, por ...unidades/dezenas/centenas.
		*/
		
		if (casaDecimal > nOriginal) return 0;

		//rastreia a maior casa decimal;
		int x = 1; //casaDecimal;
		while (x <= n) {
			System.out.println("x = " + x);
			x *= 10;
		}
		x /= 10; //volta uma casa decimal
		System.out.println("\nn - (n/x)*x = " + (n - (n/x)*x));
		System.out.println("(n/x)*casaDecimal = " + (n/x)*casaDecimal);
		return (n/x)*casaDecimal + inverterAlgarismos(nOriginal, n - (n/x)*x, casaDecimal*10);
	}
	
	//Sugestão da IA a estudar:
	public int inverter(int n, int acc) {
		if (n == 0) return acc;
		return inverter(n / 10, acc * 10 + (n % 10));
	}
	
	public void ordenadorCrescente(int x, int y) {
		/* Aceita números negativos
		*/
		if (x >= y) {
			System.out.println(y);
			return;
		}
		System.out.println(x);
		ordenadorCrescente(x+1,y);
	}
	
	public int MDC(int a, int b) {
		if (a % b == 0) return b;
		return MDC(b,a%b);		
		//20/12 = 1; resta 8
		//12/8 = 1; resta 4
		//8/4 = 2; resta 0; 4 é MDC (último divisor)
	}
		
	public float maxElemento(float[] v, int i, float dummy) {
		//Recebe vetor, índice iniciando em 0, e variável auxiliar de armazenamento
		
		//caso trivial (vetor com 1 elemento)
		if (v.length == 1) return v[0];
		
		//caso final
		if (i == (v.length - 1)) {
			if (v[i] > dummy) {
				return v[i];
			} else {
				return dummy;
			}
		}
		//caso geral				
		if (v[i] > dummy) dummy = v[i];
		return maxElemento(v, ++i, dummy);
	}

	public int localizaElemento(List<Integer> vetorOrdenado, int valorProcurado) {
		//Pega ponto médio e verifica valor.
		//Não achando o valorProcurado, divide vetor em 2 vetores iguais e refaz a busca, como um fractal
		//OBS importante: subList(0,4) tem 4 elementos, e não 5, pois não inclui o elemento no índice 4
		
		//caso com sorte
		if (vetorOrdenado.isEmpty() == true) return -1;
		
		if (valorProcurado == vetorOrdenado.get(vetorOrdenado.size()/2)) {
			return vetorOrdenado.size()/2;
		}
		
		//casos gerais
		if (valorProcurado > vetorOrdenado.get(vetorOrdenado.size()/2)) {
			return vetorOrdenado.size()/2 + localizaElemento(vetorOrdenado.subList( vetorOrdenado.size()/2, vetorOrdenado.size()), valorProcurado);
		}
		
		if (valorProcurado < vetorOrdenado.get(vetorOrdenado.size()/2)) {
			return localizaElemento(vetorOrdenado.subList( 0, vetorOrdenado.size()/2), valorProcurado);
		}
		
		return -1;
	}
}
