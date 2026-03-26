

  public class questaoA {
    public static int multiplicar (int a, int b) {
            
            // 0x0=0 
            if (b==0) {
                return 0;
            }
            
            // se for numero negativo, vc positiviza 
           /* Java não aceita repetir uma ação -3 vezes.
            Então transformamos o problema:
                a * -b  =  -(a * b) */
            if (b < 0) { 
                return -multiplicar(a, -b); 
            }
        
            return a + multiplicar (a, b - 1);
            
        }
        
        /* multiplicar(5, 3)
           → 5 + multiplicar(5, 2)
              → 5 + multiplicar(5, 1)
                            → 5 + multiplicar(5, 0)
                                         → 0 */
                                         
    }                                 