package AugustoFeltrin.Aula04;

public class ExercicioC {
    public static int contaLetras(String s, char c){
        if(s.isEmpty()){
            return 0;
        }
        
        int confere = (Character.toLowerCase(s.charAt(0)) == Character.toLowerCase(c)) ? 1 : 0;
        return confere + contaLetras(s.substring(1), c);
    }

    public static void main(String args[]) {
        int resultado = contaLetras("Cachorro", 'c'); 
        System.out.println("Quantidade de letras 'C' em Cachorro: " + resultado);
    }
}
