package comt.dist;

import java.util.Random;

public class Dist {
    public static final int ITER = 100000000;
    static public void main(String argv[]) {
        int[] t = new int[10];
        for(int i=0;i<t.length;i++)
            t[i]=0;
        for(int i=0;i<ITER;i++)
            t[new Random().nextInt(10)]++;
        for(int i=0;i<t.length;i++) {
            int diff = Math.abs((ITER/10) - t[i]);
            System.out.println(String.format("%d = %d \tdiff = %f", i + 1, t[i], ((float)diff) / ((float) ITER/10)));
        }
    }
}
