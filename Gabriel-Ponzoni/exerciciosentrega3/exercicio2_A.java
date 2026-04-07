package exerciciosentrega3;

//  Implemente a recursividade: Multiplicar inteiros por meio de somas sucessivas;

public class exercicio2_A {
    public static long multiplica(int n, int a){ 
        if (n == 0){
            return 0;
        }
        long respostaParcial = a + multiplica(n - 1, a);
        IO.println(respostaParcial);
        return respostaParcial; 
    }
    public static void main(String[] args){
        multiplica(3, 3);
    }
}
