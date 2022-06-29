package comt.dist;

import java.util.Random;

public class Dist {
    public static final int ITER = 10000000;
    static public void main(String argv[]) {
        int[] t = new int[5];
        for(int i=0;i<t.length;i++)
            t[i]=0;
        for(int i=0;i<ITER;i++)
            t[rand5()]++;
        for(int i=0;i<t.length;i++) {
            int diff = Math.abs((ITER/5) - t[i]);
            System.out.println(String.format("%d = %d diff = %f", i + 1, t[i], ((float)diff) / ((float) ITER/5)));
        }
    }

    public static int rand5() {
        int rr = 0;
        for(int i=0;i<5;i++) {
            rr += new Random().nextInt(6) + 1;
        }
        return (rr % 5);
    }
}
