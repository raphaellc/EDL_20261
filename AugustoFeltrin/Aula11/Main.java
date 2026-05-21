package AugustoFeltrin.Aula11;

public class Main {
	public static void main(String[] args) {
		Pilha<String> pilha_filmes = new Pilha<>();
		pilha_filmes.empilhar("Little Miss Sunshine (2006)");
		pilha_filmes.empilhar("LadyBird (2017)");
		pilha_filmes.empilhar("Didi (2024)");		
		pilha_filmes.empilhar("The Drama (2026)");
		
		System.out.println("Filme no topo: " + pilha_filmes.getTopo());
		System.out.println("Tamanho da pilha: " + pilha_filmes.getTamanho());
		
		System.out.println("Desempilhando os filmes:");
		while (!pilha_filmes.estaVazia()) {
			String filme_removido = pilha_filmes.desempilhar();
			System.out.println("Removido: " + filme_removido);
		}
		
		System.out.println("A pilha está vazia? " + pilha_filmes.estaVazia());
		
	}
}
