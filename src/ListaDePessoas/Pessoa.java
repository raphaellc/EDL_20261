package ListaDePessoas;
import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + ", " + idade + " anos";
    }
}