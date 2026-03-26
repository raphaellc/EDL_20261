package exerciciosentrega3;

public class pot_base_dois_1_3 {
    public static long potencia_base_2(int n){
        if (n == 0){
            return 1;
        }
        long resultadoParcial = (2 * potencia_base_2(n - 1));
        return resultadoParcial;
    }
    public static void main(String[] args){
        long resultado = potencia_base_2(4);
        IO.println(resultado);
    }
}
