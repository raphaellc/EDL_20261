package aula4.exercicios.a;

public class SomasSucessivas {
    public static int multiplicar(int x, int y) {
        if(y == 0) {
            return 0;
        }

        if(y < 0) {
            return -multiplicar(x, -y);
        }

        return x + multiplicar(x, y - 1);
    }
}
