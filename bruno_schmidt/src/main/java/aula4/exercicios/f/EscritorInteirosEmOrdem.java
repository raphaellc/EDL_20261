package aula4.exercicios.f;

public class EscritorInteirosEmOrdem {

    public enum Ordem {
        CRESCENTE(1), DECRESCENTE(-1);

        private final int incremento;

        Ordem(int incremento) {
            this.incremento = incremento;
        }
    }

    public static void escrever(int x, int y, Ordem ordem) {
        if(x == y) {
            IO.println(x);
            return;
        }

        IO.print(x + " ");

        escrever(x + ordem.incremento, y, ordem);
    }
}