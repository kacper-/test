package comt.sequence;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        long[] a = new long[]{1, 2, 3};
        long temp = 0;
        long start = new Date().getTime();
        for (int i = 4; i < 33554434; i++) {
            temp = 3 * a[2] - 2 * a[1] + a[0];
            a[0] = a[1];
            a[1] = a[2];
            a[2] = temp % 1000000;
        }
        long stop = new Date().getTime();
        System.out.println(temp);
        System.out.println(stop - start);
    }
}
