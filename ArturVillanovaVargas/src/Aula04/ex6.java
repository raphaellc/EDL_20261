package Aula04;

public class ex6 {
    public static void imprimir(int x, int y) {
        System.out.println(x);

        if (x == y) {
            return;
        }

        if (x < y) {
            imprimir(x + 1, y);
        } else {
            imprimir(x - 1, y);
        }
    }
}
