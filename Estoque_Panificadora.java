package main;
import java.util.ArrayList;


public class Estoque_Panificadora {

	private ArrayList<String> estoque = new ArrayList<String>();
	
	public Estoque_Panificadora(ArrayList<String> estoque) {
		this.estoque = estoque;
		
		estoque.add("Pão Françês");
		estoque.add("Bolo de Cenoura");
		estoque.add("Pão de Queijo");
		estoque.add("Sonho");
		estoque.add("Bolo de Cenoura");
	};

	public ArrayList<String> getEstoque() {
		return this.estoque;
	};
	
	
};
