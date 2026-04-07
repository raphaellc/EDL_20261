package exerciciosentrega3;

import java.util.ArrayList;
import java.util.List;

public class exercicio1_5somatorio {
    public static long somatorio(int n, List<Integer> a){
        if (n == 0){
            return a.get(0);
        }
        long respostaParcial = a.get(n) + somatorio(n - 1, a);
        return respostaParcial;
    }

    public static void main(String[] args){
        List<Integer> valoresSomaList = new ArrayList<>(List.of(5, 4, 8, 9));
        long resposta = somatorio(3, valoresSomaList);
        IO.println(resposta);
    }
}
