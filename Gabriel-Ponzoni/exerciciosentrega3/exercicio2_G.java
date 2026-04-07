package exerciciosentrega3;

// Implemente Recursividade: Calcular o máximo divisor comum entre dois números inteiro e positivos, onde os dois 
// número são fornecidos como parâmetro;

public class exercicio2_G {
    public static int maximo_divisor_comum(int a, int b){ // 12 e 18
        //caso base
        if (b == 0){
            return a;
        }
        //passo indutivo
        // IO.println(a + "," + b);
        int respostaParcial = maximo_divisor_comum(b, a % b); 
        return respostaParcial;

    }
    public static void main(String[] args){
        int valor1 = 12;
        int valor2 = 18;
        int resultado = maximo_divisor_comum(valor1, valor2);
        IO.println(resultado);
    }
}
