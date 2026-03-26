package exerciciosentrega3;

import java.util.ArrayList;
import java.util.List;

// Implementar Recrusividade: Achar maior elemento de um vetor;

public class exercicio2_H {//                               contadora
    public static int maior_valor_vetor(List<Integer> vetor, int i){
        if (i == vetor.size() - 1){
            return vetor.get(i);
        }
        int atual = vetor.get(i);
        int respostaParcial = maior_valor_vetor(vetor, i + 1);
        if (atual > respostaParcial){
            return atual;
        } else {
            return respostaParcial;
        }
    }
    public static void main(String[] args){
        List<Integer> vetorList = new ArrayList<>(List.of(1, 5, 3, 5, 8, 2, 4, 6, 1));
        int resposta = maior_valor_vetor(vetorList, 0);
        IO.println(resposta);
    }
}
