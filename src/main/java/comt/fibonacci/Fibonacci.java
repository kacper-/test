package comt.fibonacci;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(6));
        System.out.println(fibonacciR(5));
    }

    static int fibonacci(int a) {
        int p = 0;
        int pp = 1;
        int tmp;
        while (a > 0) {
            tmp = p;
            p += pp;
            pp = tmp;
            a--;
        }
        return p;
    }

    static int fibonacciR(int a) {
        if (a <= 1)
            return 1;
        return fibonacciR(a - 1) + fibonacciR(a - 2);
    }
}
