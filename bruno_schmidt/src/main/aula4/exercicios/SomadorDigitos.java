package aula4.exercicios;

public class SomadorDigitos {
    public static int somar(int n) {
        if (n == 0) {
            return 0;
        }

        return (n % 10) + somar(n / 10);
    }
}
