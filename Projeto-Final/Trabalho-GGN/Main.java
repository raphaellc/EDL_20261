/*
GABRIEL PONZONI, GASPAR CAON, NOAH VARGAS

Última compilação do programa feita nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

import java.util.Scanner;

public class Main {

    int turno = 0; 
    Scanner inputUsuario = new Scanner(System.in);
    int quantidadePostosAtendimento = 5;
    Posto postosDeAtendimento[] = new Posto[quantidadePostosAtendimento];
    
    public static void main(String[] args) {
        
        Main BancoPraxedes = new Main();
        
        BancoPraxedes.inicializa();
        BancoPraxedes.lacoSimulador();

        System.out.println("Você saiu do simulador de fila de banco Praxedes.");
    }

    public void inicializa() {
        // Cria postos de atendimento do Banco Praxedes
        for (int i=0; i<5; i++) {
            postosDeAtendimento[i] = new Posto();
        }

        // Gera alguns clientes e encadeia-os

    }
    
    public void lacoSimulador() {

        while(true) {
            turno++;
            System.out.println("Turno atual: " + turno);

            System.out.println("(Enter para o próximo turno; 0 para sair)");
            String x = inputUsuario.nextLine();
            if ("0".equals(x) == true) return;
        }
    }

    

}
