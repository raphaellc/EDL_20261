package Aula04;

public class ex5 {
    public static int reverter(int n, int resultado) {
        if (n == 0) {
            return resultado;
        }

        resultado = resultado * 10 + (n % 10);

        return reverter(n / 10, resultado);
    }
}
