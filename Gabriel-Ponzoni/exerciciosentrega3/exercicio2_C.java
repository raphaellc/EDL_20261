package exerciciosentrega3;

// Implemente a Recursividade: Contar quantas vezes o caractere c ocorre na string s, onde o caractere e a string são 
// fornecidos como parâmetro;

public class exercicio2_C {
    public static int contador_caractere(char c, String s){
        if (s.length() == 0){
            return 0;
        }
        if (c == s.charAt(0)){
            return 1 + contador_caractere(c, s.substring(1));
        }
        int respostaParcial = 0 + contador_caractere(c, s.substring(1));
        return respostaParcial;
    }
    public static void main(String[] args){
        int resposta = contador_caractere('n', "banana");
        IO.println(resposta);
    }
}
