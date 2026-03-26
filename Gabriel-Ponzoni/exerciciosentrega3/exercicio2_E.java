package exerciciosentrega3;

// Retornar um valor inteiro e positivo em ordem reversa, onde o valor é fornecido como 
// parâmetro. Por exemplo, a chamada da função para o valor 123 deve retornar 321. Obs.: 
// Não utilizar string para representar o valor;

public class exercicio2_E {
    public static int reverte_numero(int n, int acumulador){ // 1 e 432
        if (n == 0){ // 1 == 1?
            return acumulador; // 1
        }
        acumulador = (acumulador * 10) + (n % 10); // 432 * 10 + 1 = 4321
        // IO.println(n +","+ acumulador);
        int respostaParcial = reverte_numero(n / 10, acumulador); // 0.1 , 4321
        return respostaParcial;
    }

    public static void main(String[] args){
        int numero = 1234;
        int numeroInvertido = reverte_numero(numero, 0);
        IO.println(numeroInvertido);
    }
}
