/*
GASPAR CAON

Programa compilado nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

// Gerenciando uma lista de pessoas, implementando-a com ListaLigada iniciada em aula;

public class ListaPessoasListaLigada {

	private ListaLigada<Pessoa> listaPessoas;

	/// CONSTRUTOR
	public ListaPessoasListaLigada() {
		listaPessoas = new ListaLigada<>();
	}

	/// MÉTODOS
	public void inserirInicio(Pessoa pessoaAdicionavel) {
		listaPessoas.inserirInicio(pessoaAdicionavel);
		return;
	}

	public void inserir(Pessoa pessoaAdicionavel, int posicao) {
		listaPessoas.inserir(pessoaAdicionavel, posicao);
	}

	public void inserirFinal(Pessoa pessoaAdicionavel) {
		listaPessoas.inserirFinal(pessoaAdicionavel);
		return;
	}

	// REVISAR
	public void remover(String pessoaRemovivel) {

    	No<Pessoa> nodeAux = listaPessoas.getInicio();

		while (nodeAux != null) {
			Pessoa pessoaAux = nodeAux.getDado();

			if (pessoaRemovivel.equals(pessoaAux.getNome())) {
				listaPessoas.remover(pessoaAux);
				//System.out.println("\n" + nomePessoa + " foi removida da lista.");
				return;
			}
			nodeAux = nodeAux.getProximo();
		}
		//System.out.println("\n" + nomePessoa + " não encontrada.");
	}

	// REVISAR
	public int buscar(String pessoaBuscavel) {

		No<Pessoa> nodeAux = listaPessoas.getInicio();
		int indice = 0;

		while (nodeAux != null) { //REVISAR condição; usar indice<tamanho ou nodeAux!=null?
			Pessoa pessoaAux = nodeAux.getDado();

			if (pessoaBuscavel.equals(pessoaAux.getNome())) {
				System.out.println("\n" + nodeAux.getDado().toString() + " está na posição: " + indice);
				return indice;
			}
			nodeAux = nodeAux.getProximo();
			indice++;
		}

		System.out.println(pessoaBuscavel + " não encontrada.");
		return -1;
	}

	public void percorrer() {
		listaPessoas.percorrer();
	}
}
