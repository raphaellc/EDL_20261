package AugustoFeltrin.Aula04;

public class ExercicioD {
    public static int somaDigitos(int num){
        if(num == 0){
            return 0;
        }

        return (num % 10) + somaDigitos(num / 10);   
    }
    public static void main(String[] args) {
        int numero = 12345;
        System.out.println("Soma de dígitos do " + numero + ": " + somaDigitos(numero));
    }
}
