/*
GASPAR CAON

Programa compilado nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

public class Main {
    public static void main(String[] args) {

        System.out.println("USANDO ARRAY LIST");
        ListaPessoasArrayList listaPraxedes = new ListaPessoasArrayList();  

        listaPraxedes.inserirInicio(new Pessoa("Epaminondas", 63));
        listaPraxedes.inserirInicio(new Pessoa("Quincas", 57));
        listaPraxedes.inserirInicio(new Pessoa("Gertrudes", 75));
        listaPraxedes.inserirFinal(new Pessoa("Zé", 59));
        listaPraxedes.inserir(new Pessoa("Enzo", 8), 1);
        listaPraxedes.percorrer();
        listaPraxedes.remover("Quincas");
        listaPraxedes.percorrer();
        listaPraxedes.buscar("Zé");

        System.out.println("\n=============================");

        System.out.println("USANDO LISTA LIGADA feito em aula");
        ListaPessoasListaLigada listaPraxedes2 = new ListaPessoasListaLigada();
        listaPraxedes2.inserirInicio(new Pessoa("Epaminondas", 63));
        listaPraxedes2.inserirInicio(new Pessoa("Quincas", 57));
        listaPraxedes2.inserirInicio(new Pessoa("Gertrudes", 75));
        listaPraxedes2.inserirFinal(new Pessoa("Zé", 59));
        listaPraxedes2.inserir(new Pessoa("Enzo", 8), 1);

        listaPraxedes2.percorrer();
        listaPraxedes2.remover("Quincas");
        listaPraxedes2.percorrer();
        listaPraxedes2.buscar("Zé");

    }    
}
