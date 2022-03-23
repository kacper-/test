package comt.islands;

import java.util.Arrays;

public class IslandRemover {
    private int[] m;

    public IslandRemover(int[] m) {
        this.m = m;
    }

    public int[] remove()
    {
        int s = (int)Math.sqrt(m.length);
        int[] result = new int[m.length];
        Arrays.fill(result, -1);


        return result;
    }
}
