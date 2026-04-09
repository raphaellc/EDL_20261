/*
GASPAR CAON

Programa compilado nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

// Gerenciando uma lista de pessoas, implementando-a com ArrayList;

import java.util.ArrayList;

public class ListaPessoasArrayList {

	private ArrayList<Pessoa> listaPessoas = new ArrayList<>();

	/// MÉTODOS
	public void inserirInicio(Pessoa pessoaAdicionavel) {
		listaPessoas.add(0, pessoaAdicionavel);
		return;
	}

	public void inserir(Pessoa pessoaAdicionavel, int posicao) {
		listaPessoas.add(posicao, pessoaAdicionavel);
		return;
	}

	public void inserirFinal(Pessoa pessoaAdicionavel) {
		listaPessoas.add(pessoaAdicionavel);
		return;
	}

	public void remover(String nomePessoa) {
		for (int i=0; i<listaPessoas.size(); i++) {
			if (nomePessoa.equals(listaPessoas.get(i).getNome())) {
				listaPessoas.remove(i);
				System.out.println("\n" + nomePessoa + " foi removida da lista.");
				return;
			}
		}
		return;
	}

	// revisar: deve retornar int ou void? comparar com ListaLigada.java
 	public int buscar(String nomePessoa) {
		for (int i=0; i<listaPessoas.size(); i++) {
			if (nomePessoa.equals(listaPessoas.get(i).getNome())) {
				System.out.println("\n" + listaPessoas.get(i).toString() + " está na posição: " + i);
				return i;
			}
		}
		System.out.println(nomePessoa + " não encontrada.");
		return -1;
	}

	public void percorrer() {
		System.out.println("");
		listaPessoas.forEach(p -> {
			System.out.println(p.toString());
		});
	}
}
