/*
GABRIEL PONZONI, GASPAR CAON, NOAH VARGAS

Última compilação do programa feita nas versões:

	javac 21.0.10

e executado na versão:

	openjdk version "21.0.10" 2026-01-20
	OpenJDK Runtime Environment (build 21.0.10+7-Ubuntu-124.04)
	OpenJDK 64-Bit Server VM (build 21.0.10+7-Ubuntu-124.04, mixed mode, sharing)
*/

/** A única diferença entre a fila comum e a fila prioritária é que a fila prioritária
 * é o tipo de dado utilizado: o dado "Cliente", que é um nó especial. Um cliente possui
 * uma senha e um tempo de atendimento. Consulte a documentação de Fila e Cliente.
*/
public class FilaPrioritaria<T> {

    public Fila<Cliente> filaPrioritaria = new Fila<Cliente>();

}