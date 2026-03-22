package aula4.exercicios.e;

public class InversorInteiro {
    public static int inverter(int n) {
        if((n % 10) == n) return n; // Menor que 10 retorna direto

        var digitoAtual = n % 10;
        var logDigitos = (int) Math.log10(n);
        var padding = (int) Math.pow(10, logDigitos);

        return (digitoAtual * padding) + inverter(n / 10);
    }
}
