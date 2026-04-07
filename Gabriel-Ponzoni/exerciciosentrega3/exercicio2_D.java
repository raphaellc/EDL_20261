package exerciciosentrega3;

// Implementar Recursividade: Calcular a soma dos dígitos de um número inteiro e positivo, onde o número é fornecido 
// como parâmetro. Por exemplo, a chamada da função para o valor 12345 deve retornar 15;

// Dica, para ter um int de apenas um valor é so pegar o resto (%) de 10, para pegar os primeiros numeros precisa usar dividido (/) 10

public class exercicio2_D {
    public static int soma_valores(int n){ 
        if (n == (n % 10)){
            return n;
        }
        int resultadParcial = soma_valores(n / 10) + n % 10; 
        return resultadParcial;
    }
    public static void main(String[] args){
        int numeros = 12344;
        int resultado = soma_valores(numeros);
        IO.println(resultado);
    }
}
