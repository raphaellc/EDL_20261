public class questaoD {

    public static int somaDigitos(int n) {
 
        if (n == 0) {
            return 0;
        }


        int ultimo = n % 10;

        return ultimo + somaDigitos(n / 10);
    }
    
}