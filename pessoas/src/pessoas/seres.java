package pessoas;

public class seres<T> {
	
	private T nome;
	private T idade;
	private seres<T> prox;
	
	public T getNome() {
		return this.nome;
		
	}
	
	public T getIdade() {
		return this.idade;
		
	}
	
	public seres<T> getProx() {
		return this.prox;
	}
	
	public void setNome(T nome) {
		this.nome = nome;
		
	}
	
	public void setIdade(T idade) {
		this.idade = idade;
	}
	
	public void setProx (seres<T> prox) {
		this.prox = prox;
		
	}
	
}
