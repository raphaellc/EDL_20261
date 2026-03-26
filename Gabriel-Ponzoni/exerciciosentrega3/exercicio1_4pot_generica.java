package exerciciosentrega3;

public class pot_generica1_4 {
    public static long potencia_generica(int a, int n){
        if (n == 0){
            return 1;
        }
        long respostaParcial = a * potencia_generica(a, n - 1); 
        return respostaParcial;
    }
    public static void main(String[] args){
        long resposta = potencia_generica(4, 2);
        IO.println(resposta);
    }
}
