public class Main {
    
   /* Use static quando:
        
        o método não depende de atributos do objeto
        você só quer uma função utilitária
        exemplo: Math.sqrt(), Math.pow()
        
        Use métodos normais quando:
        
        o método depende dos dados do objeto
        você precisa de instâncias diferentes
        exemplo: uma classe Aluno, Carro, Pessoa */
        
        public static void main(String[] argumentos ) {
            // teste questao A
            System.out.println(questaoA.multiplicar(5,4));
            //teste questao B
            System.out.println(questaoB.ehPalindromo(0, 5, "banana"));
            // texto questao C
            String texto = "recursividade";
            char caractere = 'e';
            int resultado = questaoC.contarOcorrencias(texto, caractere);
            System.out.println("O caractere '" + caractere + "' aparece " + resultado + " vezes em \"" + texto + "\".");
            //teste questao D 
            System.out.println(questaoD.somaDigitos(123));
            //teste questao E
            System.out.println(questaoE.inverterNumero(456));
            //teste questao F
            System.out.println(questaoF.imprimirOrdem(7,3));
             //teste questao G
             System.out.println(questaoG.mdc(4,8));
            //teste questao H
            int[] num = {27, 674, 6, 8, 6};
             System.out.println(questaoH.maiorElemento(num, 0));
            //teste questao I
            int[] numB = {1, 2, 3, 4, 5};
            int alvo = 2;
            int posicao = questaoI.buscaBinaria(numB, 0, numB.length- 1, alvo);
            if (posicao != -1) {
                System.out.println("Elemento " + alvo + " encontrado na posição: " + posicao);
            } else {
                System.out.println("Elemento " + alvo + " não encontrado.");
            }
    }
        }

