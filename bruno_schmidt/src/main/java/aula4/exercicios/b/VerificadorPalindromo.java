package aula4.exercicios.b;

public class VerificadorPalindromo {
    public static boolean isPalindromo(String palavra) {
        return palavra.equals(inverterPalavra(palavra));
    }

    private static String inverterPalavra(String palavra) {
        var charsInvertidos = inverterCharsPalavra(
            palavra.toCharArray(),
            new char[palavra.length()],
            0
        );

        return new String(charsInvertidos);
    }

    private static char[] inverterCharsPalavra(char[] palavra, char[] buff, int pos) {
        if(pos == palavra.length) {
            return buff;
        }

        var posDestino = palavra.length - pos - 1;
        buff[posDestino] = palavra[pos];

        return inverterCharsPalavra(palavra, buff, pos + 1);
    }
}
