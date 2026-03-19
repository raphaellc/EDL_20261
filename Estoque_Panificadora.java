package main;
import java.util.ArrayList;


public class Estoque_Panificadora {

	private ArrayList<String> estoque = new ArrayList<String>();
	
	private int num;
	
	public Estoque_Panificadora(int num, ArrayList<String> estoque) {
		this.num = num;
		this.estoque = estoque;
	};
	
	public int getOrdem() {
		return this.num;
	};

	public ArrayList<String> getEstoque() {
		return this.estoque;
	};
	
	
};
