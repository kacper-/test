package comt.codility;

import java.util.HashSet;
import java.util.Set;

public class CTest {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 5, 6}));
    }

    public static int solution(int[] A) {
        Set<Integer> filter = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0)
                filter.add(A[i]);
        }

        for (int i = 1; i < 1000000; i++) {
            if (!filter.contains(i))
                return i;
        }

        return 1;
    }
}
