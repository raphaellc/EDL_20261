package aula5.conteudo.aula.lista.ligada;

public class MainTesteNos {
    static void main() {
        No<Integer> no1 = new No<>(10);
        No<Integer> no2 = new No<>(30);
        No<Integer> no3 = new No<>(50);

        no1.setProximo(no2);
        no2.setProximo(no3);

        No<Integer> no4 = new No(40, no1);

        IO.println(no4.getProximo().getProximo().getDado());

        No<Integer> novoNo = no4.getProximo().getProximo().getProximo();

        IO.println(novoNo != null ? novoNo.getDado() : "Nulo");
        /* Isso é igual a:
         if(novoNo != null) {
             IO.println(novoNo.getDado());
         } else {
             IO.println("Nulo");
         }
         O operador ternário (?) é equivalente a um if resumido
        */
    }

    static void exemploTernario() {

    }
}
