package aula4.exercicios.g;

public class MaximoDivisorComum {
    // Algoritmo de Euclides
    public static int encontrarMdc(int primeiroNumero, int segundoNumero) {
        if (segundoNumero == 0) {
            return primeiroNumero;
        }
        return encontrarMdc(segundoNumero, primeiroNumero % segundoNumero);
    }
}
