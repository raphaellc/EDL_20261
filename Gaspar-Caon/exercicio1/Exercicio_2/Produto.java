/*
Programa compilado na versão:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

import java.util.Scanner;
import java.util.Random;

public class Produto {

	private float preco;
	private int estoque;
	
	////////////////
	// Construtor //
	////////////////
	
	public Produto (float preco_informado, int estoque_informado) {
		
		if (preco_informado < 0) {
			this.preco = 0;
		} else {
			this.preco = preco_informado;
		}
		
		if (estoque_informado < 0) {
			this.estoque = 0;
		} else {
			this.estoque = estoque_informado;
		}
		
	}
	
	///////////////////////
	// Getters & Setters //
	///////////////////////
	
	public float getPreco() {
		return this.preco;
	}
	
	public void setPreco(float preco_informado) {
		if (preco_informado < 0) {
			System.out.println("AVISO: o preço NÃO foi alterado; impossível atribuir preço negativo.");
		} else {
			this.preco = preco_informado;
		}
	}
	
	public int getEstoque() {
		return this.estoque;
	}
	
	public void setEstoque(int estoque_informado) {
		if (estoque_informado < 0) {
			System.out.println("AVISO: o estoque NÃO foi alterado; impossível atribuir estoque negativo.");
		} else {
			this.estoque = estoque_informado;
		}
	}
		
}
