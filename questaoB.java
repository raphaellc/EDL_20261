        
    
    public class questaoB {
        public static boolean ehPalindromo (int i, int j, String str) {
            
            // se for maior ou igual = quer dizer que é palindromo ex mirim m no inicio, m no final m=m = a palavra 
            // já é palindroma vai fazendo o checkup
            
            if (i>=j) {
                return true;
            }
            
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            
            i = i + 1;
            j = j - 1;
            
            return ehPalindromo(i, j, str);
            
        }
    }