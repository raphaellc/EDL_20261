package main;

public class No<T> {
	
	//SOCORRO.
	
	private T Dado;
	private No<T> Proximo;
	
	public T Get_Dado() { return Dado; };
	public void Set_Dado(T D) { this.Dado = D; };
	
	public No<T> Get_Prox() { return Proximo; };
	public void Set_Prox(No<T> Prox) { this.Proximo = Prox; };
	
	public No(T Dado) {	this.Dado = Dado; this.Proximo = null; }
	public No(T Dado, No<T> Proximo) { this.Dado = Dado; this.Proximo = Proximo; }
		
};