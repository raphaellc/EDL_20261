package exerciciosentrega3;

public class fatorial1_1 {
    public static long fatorial(int n){
        IO.println("Calculando: " + n + "!");
        if (n < 1){
            IO.println("Cheguei no caso base (1! ou 0!), retornando 1");
            return 1;
        }
        long resultadoParcial = n * fatorial(n - 1);
        IO.println("Resolvido: " + n + " * " + (n-1) + "! = " + resultadoParcial);
        return resultadoParcial;
    }
    public static void main(String[] args){
        IO.println("-+-".repeat(10));
        IO.println("INICIANDO CÁLCULO DE FATORIAL");
        IO.println("-=-".repeat(10));

        long resultadoFinal = fatorial(5);

        IO.println("-=-".repeat(10));
        IO.println("RESULTADO FINAL: " + resultadoFinal);
        IO.println("-=-".repeat(10));

    }
}
