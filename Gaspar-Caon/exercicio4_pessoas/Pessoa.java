/*
GASPAR CAON

Programa compilado nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

public class Pessoa {

    private String nome;
    private int idade;

    //CONSTRUTORES
    public Pessoa(String nomeInformado, int idadeInformada) {
        this.nome = nomeInformado;
        this.idade = idadeInformada;
    }

    //GETTERS-SETTERS
    public String getNome() {return this.nome;}

    public void setNome(String nomeInformado) {this.nome = nomeInformado;}

    public int getIdade() {return this.idade;}

    public void setIdade(int idadeInformada) {this.idade = idadeInformada;}

    // sugestões interessantes de IA:
    @Override
    public String toString() {
        return this.nome + ", " + this.idade;
    }

    @Override
    public boolean equals(Object objetoComparavel) {
        if (objetoComparavel == this) return true;
        if (objetoComparavel == null) return false;
        if (objetoComparavel instanceof Pessoa == false) return false;
        
        // Quando comparar um objeto Pessoa com outro objeto Pessoa, considerar apenas nome
        Pessoa outro = (Pessoa)objetoComparavel; 
        return (outro.nome.equals(this.nome));
    }
}