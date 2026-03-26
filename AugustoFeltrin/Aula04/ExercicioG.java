package AugustoFeltrin.Aula04;

public class ExercicioG {
    public static int calcularMDC(int a, int b){
        if (b == 0){
            return a;
        }
        return calcularMDC(b, a % b);
    }

    public static void main(String[] args) {
        int n1 = 48;
        int n2 = 18;

        System.out.println("MDC de " + n1 + " e " + n2 + " é: " + calcularMDC(n1, n2));
    }
}
