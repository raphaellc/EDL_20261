package pessoas;
import java.util.ArrayList;
import java.util.LinkedList;
import pessoas.seres;

public class listapessoas {
	
	private seres<T> inicio;
	private int tamanho;
	
	public void listaencadeada() {
		this.inicio = null;
		this.tamanho = 0;
		
	}
	
	public void adicionar(T pessoa) {
		if (this.inicio == null) {
			this.inicio = new seres<T>();
			tamanho++;
			return;
			
		}
		
		seres<T> noAux = this.inicio;
		while (noAux.getProx() != null) {
			noAux = noAux.getProx();
		}
			noAux.setProx(new seres<T>());
			tamanho++;
			return;
		
	}
	
	public void mostrar() {
		if (inicio == null) {
			System.out.println("Lista vazia");
			return;
			}
		seres<T> noAux = this.inicio;
		while(noAux != null) {
			System.out.println(noAux.getNome());
			System.out.println(noAux.getIdade());
			noAux = noAux.getProx();
			}
		System.out.println("Fim da lista");
		
	}
}	
	
	public static void main(String[] args) {
		
		
	
}
