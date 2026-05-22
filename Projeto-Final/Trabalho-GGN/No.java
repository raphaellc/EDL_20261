/*
GABRIEL PONZONI, GASPAR CAON, NOAH VARGAS

Última compilação do programa feita nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

/** Cada nó armazena um dado de tipo genérico, e possui dois ponteiros:
* um para o nó anterior, um para o nó próximo. Dependendo do construtor,
* os ponteiros podem ou não ser nulos.
* @param dado
* @param proximo
* @param anterior
*/
public class No<T> {

	private T dado;
	private No<T> proximo;
	private No<T> anterior;
	
	/// CONSTRUTORES
	/** Construtor de nó quando somente for informado o dado.
	* Os ponteiros são nulos por 'default'.
 	* @param dado_informado
 	*/
	public No(T dado_informado) {
		dado = dado_informado;
		anterior = null;
		proximo = null;
	}

	/** Construtor de nó quando for informado o dado e ponteiros manualmente.
 	* @param dado_informado
 	* @param anterior_informado
	* @param próximo_informado
 	*/
	public No(T dado_informado, No<T> anterior_informado, No<T> proximo_informado) {
		this.dado = dado_informado;
		this.anterior = anterior_informado;
		this.proximo = proximo_informado;
	}
	
	/// GETTERS-SETTERS
	public T getDado() {return this.dado;}
	
	public void setDado(T dado_informado) {this.dado = dado_informado;}
	
	public No<T> getAnterior() {return this.anterior;}

	public void setAnterior(No<T> anterior_informado) {this.anterior = anterior_informado;}

	public No<T> getProximo() {return this.proximo;}
	
	public void setProximo(No<T> proximo_informado) {this.proximo = proximo_informado;}

	@Override
	public String toString() {
		//return "No{" + "dado=" + this.dado + "}";
		return "" + this.dado; // necessário usar "" para ocorrer a conversão implícita de this.dado para string. é mais seguro do que usar this.dado.toString(), pois este pode gerar NullPointerException.
	}
}
