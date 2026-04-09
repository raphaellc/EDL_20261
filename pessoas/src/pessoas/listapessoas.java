package pessoas;
import java.util.ArrayList;
import java.util.LinkedList;
import pessoas.seres;

public class listapessoas {
	
		ArrayList<String> lista = new ArrayList<>();
		LinkedList<String> listaLigada = new LinkedList<>();
		
		
	public void inserir(pessoas.seres) {
		lista.add(seres(this.nome, this.idade));
		
	}
	
	public static void main(String[] args) {
		
		lista.inserir(seres("arthur", 35));
		
	}
	
}
