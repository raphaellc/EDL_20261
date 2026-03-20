public class Factorial {
    static void main() {
        System.out.println(factorial(4));
    }

    public static int factorial(int num) {
        if (num == 0) return 1;

        return num * factorial(num - 1);
    }
}
