package exerciciosentrega3;

public class exercicio1_6dobro_mais_tres {
    public static long dobra_adiciona_tres(int n){
        if (n == 0){
            return 3;
        }
        long respostaParcial = (2 * dobra_adiciona_tres(n - 1)) + 3;
        IO.println(respostaParcial);
        return respostaParcial;
    }
    public static void main(String[] args){
        dobra_adiciona_tres(4);
    }
}
