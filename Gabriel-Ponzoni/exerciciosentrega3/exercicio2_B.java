package exerciciosentrega3;

// Implemente a recursividade:  Verificar se uma palavra é um palíndromo;

import java.util.ArrayList;
import java.util.List;

public class exercicio2_B {
    public static boolean verifica_palindrome(String a){
        // palavra de 1 caractere sempre vai ser um palindromo = Caso base
        if (a.length() == 1){
            return true;
        }
        // primeira letra e ultima diferentes? n é um palíndromo = Caso base
        if (a.charAt(0) != a.charAt(a.length() - 1)){
            return false;
        }
        //   passo indutivo quebra a string na posicao 0, 1< e vaia te a n-1 e pega o caractere anterior (particulariedade do substring)
        boolean respostaParcial = verifica_palindrome(a.substring(1, a.length() - 1)); // exemplo: arara -> "rar"
        return respostaParcial;
    }
    public static void main(String[] args){
        List<String> palavrasList = new ArrayList<>(List.of("arara", "radar", "banana", "reviver"));
        for (String p : palavrasList){
            boolean ehPalindrome = verifica_palindrome(p);
            if (ehPalindrome){
                IO.println(String.format("A palavra %s é um palíndrome.",p));
            } else {
                IO.println(String.format("A palavra %s NÃO é um palíndrome.",p));
            }
        }
    }
}
