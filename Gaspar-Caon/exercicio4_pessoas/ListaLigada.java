/*
GASPAR CAON

Programa compilado nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

public class ListaLigada<T> {

	private No<T> inicio;
	private int tamanho;

	// CONSTRUTORES
	public ListaLigada() {
		this.inicio = null;
		this.tamanho = 0;
	}
	
	public ListaLigada(T dadoInicialInformado) {
		this.inicio = new No<>(dadoInicialInformado);
		this.tamanho = 1;
	}
	
	//GETTER para tamanho
	public int getTamanho() {
		return tamanho;
	}
	
	/// MÉTODOS
	public boolean estaVazia() {
		return tamanho == 0;
	}

	// método sugerido por IA para contornar problema em ListaPessoasListaLigada; inicio não tem getter
	public No<T> getInicio() {
		return this.inicio;
	}

	public void inserirInicio(T dado) {

		if (inicio == null) {
			inicio = new No<>(dado);
			tamanho++;
			System.out.println("'" + dado + "' adicionado. É o único elemento. Lista atualizada.\n");
			return;
		}

		No<T> nodeNovo = new No<T>(dado);
		nodeNovo.setProximo(inicio);
		inicio = nodeNovo;
		tamanho++;
		System.out.println("'" + dado + "' adicionado ao início. Lista atualizada.\n");
		return;
	}

	public void inserir(T dado, int indiceInsercao) {
		
		if (indiceInsercao < 0 || indiceInsercao > tamanho) {
			System.out.println("Índice de inserção está fora dos limites da lista. Lista inalterada.");
			return;
    	}
		
		if (inicio == null || indiceInsercao == 0) {
			inserirInicio(dado);
			return;
		}
		
		/* localiza ponto de inserção de novo nó;
		cria um outro nó auxiliar (nodeInicioResto) para guardar referência ao primeiro nó do "resto" da lista (após ponto de inserção);
		isto é necessário para não se perder o fim da lista;
		*/
		
		No<T> nodeNovo = new No<>(dado);
		int indice = 0;

		No<T> nodeAux = this.inicio;

		while (indice < indiceInsercao - 1 ) {
			nodeAux = nodeAux.getProximo();
			indice++;
		}	

		No<T> nodeInicioResto = nodeAux.getProximo();
		nodeAux.setProximo(nodeNovo);
		nodeNovo.setProximo(nodeInicioResto);
		tamanho++;
		System.out.println("'" + dado + "' adicionado na posição " + indiceInsercao + ". Lista atualizada.\n");
		return;
	}
	
	public void inserirFinal(T dado) {

		if (inicio == null) {
			inserirInicio(dado);
			return;
		}

		No<T> nodeAux = this.inicio;

		while (nodeAux.getProximo() != null) {
			nodeAux = nodeAux.getProximo();
		}

		No<T> nodeNovo = new No<>(dado);		
		nodeAux.setProximo(nodeNovo);
		tamanho++;
		System.out.println("'" + dado + "' adicionado ao final. Lista atualizada.\n");
		return;
	}

	public void remover(T dado) {
		// remove dado baseado no seu rótulo

		// caso vazio
		if (inicio == null) {
			System.out.println("A lista é vazia.");
			return;
		}

		System.out.println("Removendo '" + dado + "' ...");
		// caso seja o primeiro elemento
		if (inicio.getDado().equals(dado) == true) {
			System.out.println("'" + dado + "' removido. Lista atualizada.");	// informa antes de atualizar os ponteiros
			inicio = inicio.getProximo();
			tamanho--;
			return;
		}

		No<T> nodeAux = this.inicio;

		while (nodeAux.getProximo() != null) {
			if (nodeAux.getProximo().getDado().equals(dado) == true) {
				System.out.println("'" + dado + "' removido. Lista atualizada.\n");
				nodeAux.setProximo(nodeAux.getProximo().getProximo());
				tamanho--;
				return;
			}
			nodeAux = nodeAux.getProximo();	
		}
		System.out.println("'" + dado + "' não encontrado. Lista inalterada.\n");
		return;
	}

 	public void buscar(T dado) {
		// caso vazio
		if (inicio == null) {
			System.out.println("A lista é vazia.\n");
			return;
		}

		int indice = 0;	// indice 0 será o primeiro elemento
		No<T> nodeAux = this.inicio;

		while (indice < tamanho) {
			if (nodeAux.getDado().equals(dado) == true) {
				System.out.println("'" + dado + "' localizado na posição " + indice + "\n");
				return;
			}
			nodeAux = nodeAux.getProximo();
			indice++;
		}

		System.out.println("'" + dado + "' não encontrado. Lista inalterada.\n");
		return;
	}

	public void percorrer() {
		if (this.inicio == null) {
			System.out.println("Nada para mostrar. Lista vazia\n");
			return;
		}

		System.out.println("Mostrando a lista:");
		No<T> nodeAux = this.inicio;
		int indice = 0;

		while (indice < this.tamanho) {
			System.out.println(nodeAux.getDado());
			nodeAux = nodeAux.getProximo();
			indice++;
		}
		return;
	}

}
