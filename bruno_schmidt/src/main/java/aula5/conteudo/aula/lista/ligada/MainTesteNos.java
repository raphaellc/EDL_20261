package aula5.conteudo.aula.lista.ligada;

public class MainTesteNos {
    static void main() {
        NoSimples<Integer> no1 = new NoSimples<>(10);
        NoSimples<Integer> no2 = new NoSimples<>(30);
        NoSimples<Integer> no3 = new NoSimples<>(50);

        no1.setProximo(no2);
        no2.setProximo(no3);

        NoSimples<Integer> no4 = new NoSimples(40, no1);

        IO.println(no4.getProximo().getProximo().getDado());

        NoSimples<Integer> novoNo = no4.getProximo().getProximo().getProximo();

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
}
