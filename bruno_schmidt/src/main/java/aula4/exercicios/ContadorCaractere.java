package aula4.exercicios;

public class ContadorCaractere {
    public static int contar(char c, String s) {
        return contar(c, s, 0, 0);
    }

    private static int contar(char c, String s, int total, int pos) {
        var array = s.toCharArray();

        if(pos == array.length) {
            return total;
        }

        if(array[pos] == c) {
            total++;
        }

        return contar(c, s, total, pos + 1);
    }
}
