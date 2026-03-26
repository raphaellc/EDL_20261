public class questaoE {

    public static int inverterNumero(int n) {
        return inverterNumeroAux(n, 0);
    }

    private static int inverterNumeroAux(int n, int resultado) {
        if (n == 0) {
            return resultado;
        }

        int ultimo = n % 10;

        resultado = resultado * 10 + ultimo;

        return inverterNumeroAux(n / 10, resultado);
    }
    
}