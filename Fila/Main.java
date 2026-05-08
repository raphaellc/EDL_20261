public class Main {
    public static void main(String[] args) {
        Fila<String> filaPessoas = new Fila<String>();
        System.out.println("--------- Teste Fila Vazia -------");
        if(filaPessoas.removerFila() == null){
            System.out.println("Fila vazia - passou no teste");
        }else{
            System.out.println("Fila não vazia - falhou no teste");
        }

        System.out.println("--------- Teste Fila com uma pessoa -------");
        filaPessoas.inserirFila("Raphael");
        if(filaPessoas.removerFila() == null){
            System.out.println("Fila vazia - falhou no teste");
        }else{
            System.out.println("Fila não vazia - passou no teste");
        }

        if(filaPessoas.removerFila() == null){
            System.out.println("Fila vazia - passou no teste");
        }else{
            System.out.println("Fila não vazia - falhou no teste");
        }

        System.out.println("--------- Enfileirando Andre -> Denian e Felipe  -------");
        filaPessoas.inserirFila("Andre");
        filaPessoas.inserirFila("Denian");
        filaPessoas.inserirFila("Felipe");
        System.out.println("--------- Teste Frente da Fila -------");
        if("Andre".equals(filaPessoas.frenteFila())){
            System.out.println("Nome igual a Andre - passou no teste");
        }else{
            System.out.println("Nome diferente de Andre - falhou no teste");
        }

        System.out.println("--------- Teste Tamanho da Fila igual a 3 -------");
        if(filaPessoas.tamanhoFila() == 3){
            System.out.println("Tamanho igual a 3 => passou no teste");
        }else{
            System.out.println("Tamanho diferente de 3 => falhou no teste");
        }

        System.out.println("--------- Teste Remove uma pessoa - tamanho == 2 -------");
        filaPessoas.removerFila();
        if(filaPessoas.tamanhoFila() == 2){
            System.out.println("Tamanho igual a 2 => passou no teste");
        }else{
            System.out.println("Tamanho diferente de 2 => falhou no teste");
        }

        System.out.println("--------- Teste Frente Fila == Denian  -------");
        if("Denian".equals(filaPessoas.frenteFila())){
            System.out.println("Nome igual a Denian - passou no teste");
        }else{
            System.out.println("Nome diferente de Denian - falhou no teste");
        }        
    }
}
