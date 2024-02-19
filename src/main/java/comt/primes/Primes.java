package comt.primes;

import java.util.Date;

public class Primes {
    public static void main(String[] args) {
        long from = 100000000L;
        long to = 100010000L;
        int count = (int) (to - from);
        int[] a = new int[count];

        long start = new Date().getTime();

        double m = Math.sqrt(count + from);
        for (long j = from; j < from + count; j++) {
            for (long i = 2; i <= m; i++) {
                if ((j % i) == 0) {
                    a[(int) (j - from)] = 1;
                    break;
                }
            }
        }

        long stop = new Date().getTime();

//        for (int i = 0; i < count; i++) {
//            if (a[i] == 0) {
//                System.out.println(from + i);
//            }
//        }
        System.out.println("Time: " + (stop - start) + " ms");
    }
}
