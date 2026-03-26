package AugustoFeltrin.Aula04;

public class ExercicioF {
    
    public static String intervalo(int x, int y) {
        if (x == y) {
            return String.valueOf(x);
        }

        if (x < y) {
            return x + " " + intervalo(x + 1, y);
        } else {
            return x + " " + intervalo(x - 1, y);
        }
    }

    public static void main(String[] args) {
        int inicio = 10;
        int fim = 5;
        
        System.out.println("Sequência de " + inicio + " a " + fim + ": " + intervalo(inicio, fim));
    }
}