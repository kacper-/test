package comt.codility;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

    }

    static int solution(int[] A) {
        boolean[] marker = new boolean[A.length];
        Arrays.fill(marker, false);
        int result = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0)
                marker[A[i]] = true;
        }

        return result;
    }
}
