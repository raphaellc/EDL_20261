package Aula04;

public class ex1 {
    public static int multiplicar(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return a + multiplicar(a, b - 1);
    }
}
