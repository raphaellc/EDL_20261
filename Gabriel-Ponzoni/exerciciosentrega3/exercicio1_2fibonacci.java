package exerciciosentrega3;

public class exercicio1_2fibonacci {
    public static long fibonacci(int n){
        if (n <= 1){
            return n;
        } 
        long resultadoParcial = fibonacci(n - 1) + fibonacci(n - 2);
        return resultadoParcial;
    }
    public static void main(String[] args){
        long resposta = fibonacci(10);
        IO.println(resposta);
    }
}
