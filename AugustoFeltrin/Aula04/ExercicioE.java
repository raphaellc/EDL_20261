package AugustoFeltrin.Aula04;

public class ExercicioE {
    public static int inverso(int n, int total){
        if (n == 0){
            return total;
        }

        return inverso(n / 10, total * 10 + (n % 10));
    }
    public static void main(String[] args) {
        int numero = 14;
        
        System.out.println("Inverso do número " + numero + ": " + inverso(numero, 0));
    }
}
