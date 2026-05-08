public class Main {

    public static void main(String[] args) {
        Fila<String> filaPessoas = new Fila<String>();

        filaPessoas.inserirFila("Quinn Rourke");
        filaPessoas.inserirFila("Venator");
        filaPessoas.inserirFila("Father Quinn");

        if ("Quinn Rourke".equals(filaPessoas.frenteFila())) {
            System.out.println("LET ME BE STAINED BY THE BLOOD OF THE WICKED.");
        } else {
            System.out.println("Não tá aqui.");
        }

        if (filaPessoas.tamanhoFila() == 3) {
            System.out.println("In nomine Patris, et Filli, et Spiritus Sancti.");
        } else {
            System.out.println("In nomine Patris... Et Filli... Et Spiritus Sancti...");
        }
    }

}