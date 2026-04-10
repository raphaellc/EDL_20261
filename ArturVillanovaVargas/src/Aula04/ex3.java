package Aula04;

public class ex3 {
    public static int contarChar(String s, char c, int index) {
        if (index == s.length()) {
            return 0;
        }

        if (s.charAt(index) == c) {
            return 1 + contarChar(s, c, index + 1);
        } else {
            return contarChar(s, c, index + 1);
        }
    }
}
