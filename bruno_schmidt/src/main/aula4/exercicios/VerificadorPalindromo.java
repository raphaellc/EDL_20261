package aula4.exercicios;

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

        // Isso aqui é apenas pra manter a imutabilidade do array
        // No Java os arrays são como objetos, não são pass by reference mas
        // o valor do objeto é a referência dele, para arrays é o mesmo.
        var posDestino = palavra.length - pos - 1;
        buff[posDestino] = palavra[pos];

        return inverterCharsPalavra(palavra, buff, pos + 1);
    }
}
