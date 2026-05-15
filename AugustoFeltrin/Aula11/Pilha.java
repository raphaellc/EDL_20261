package AugustoFeltrin.Aula11;

public class Pilha <T>{
	private No<T> topo;
	private int tamanho;
	
	public Pilha() {
		this.topo = null;
		this.tamanho = 0;
	}
	
	public Pilha(T dado) {
		this.topo = new No<T>(dado);
		tamanho++;
	}
	
	public void empilhar(T dado) {
		if(estaVazia()) {
			topo = new No<T>(dado);
		} else {
			No<T> novo_no = new No<T>(dado);
			novo_no.setProximo(topo);
			topo = novo_no;
		}
		tamanho++;
	}
	
	public T getTopo() {
		if(estaVazia()) return null;
		return topo.getDado();
	}
	
	public T desempilhar() {
		if(estaVazia()) return null;
		tamanho--;
		T dado_temp = topo.getDado();
		topo = topo.getProximo();
		return dado_temp;
	}
	
	public int getTamanho(){
		return tamanho;
	}
	
	public boolean estaVazia() {
		return tamanho == 0;
	}
}
