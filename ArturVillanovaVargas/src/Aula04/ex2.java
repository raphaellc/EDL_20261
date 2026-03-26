package Aula04;

public class ex2 {
    public static boolean palindromo(String palavra, int inicio, int fim) {
        if (inicio >= fim) {
            return true;
        }

        if (palavra.charAt(inicio) != palavra.charAt(fim)) {
            return false;
        }

        return palindromo(palavra, inicio + 1, fim - 1);
    }
}
