/*
GASPAR CAON

Programa compilado nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

/*import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;*/

public class No<T> {

	private T dado;
	private No<T> proximo;
	
	/// CONSTRUTORES
	public No(T dado_informado) {
		this.dado = dado_informado;
		this.proximo = null;
	}

	public No(T dado_informado, No<T> proximo_informado) {
		this.dado = dado_informado;
		this.proximo = proximo_informado;
	}
	
	/// MÉTODOS
	public T getDado() {
		return this.dado;
	}
	
	public void setDado(T dado_informado) {
		this.dado = dado_informado;
	}
	
	public No<T> getProximo() {
		return this.proximo;
	}
	
	public void setProximo(No<T> proximo_informado) {
		this.proximo = proximo_informado;		
	}


}
