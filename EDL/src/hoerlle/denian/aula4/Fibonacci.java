public class Fibonacci {
    static void main(String[] args) {
        System.out.println(Fibonacci(10));
    }

    public static int Fibonacci(int num) {
        if (num <= 1) return num;

        return Fibonacci(num - 1) + Fibonacci(num - 2);
    }
}
