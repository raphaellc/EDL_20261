public class questaoF {

    public static int imprimirOrdem(int x, int y) {
        if (x == y) {
            System.out.println(x);
            return 0;
        }
 
        System.out.println(x);
   
        if (x < y) {
           return imprimirOrdem(x + 1, y);
        } 

        else {
           return imprimirOrdem(x - 1, y);
        }
    }

}
