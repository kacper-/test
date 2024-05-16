package comt.codility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class INGTest {
    public static void main(String[] args) {
        System.out.println(task1(new int[]{1, 2, 3, 5, 6}));
    }

    public static boolean task1(int[] A) {
        if (A == null || A.length < 2)
            return false;

        Set<Integer> unique = new HashSet<>();
        for (int i : A)
            unique.add(i);

        for (int i : A) {
            if (unique.contains(i - 1) || unique.contains(i + 1))
                return true;
        }

        return false;
    }

    public static int task2(int[] A) {


        return 1;
    }

    public static int task3(int[] A, int[] B, int N) {
        if (A == null || B == null)
            return 0;

        if (A.length == 0 || B.length == 0 || B.length != A.length)
            return 0;

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i : A)
            graph.putIfAbsent(i, new HashSet<>());
        for (int i : B)
            graph.putIfAbsent(i, new HashSet<>());

        for (int i = 0; i < N; i++)
            graph.get(A[i]).add(B[i]);
        for (int i = 0; i < N; i++)
            graph.get(B[i]).add(A[i]);

        int max = 0;
        for (int i : graph.keySet()) {
            for (int j : graph.get(i))
                max = Math.max(max, graph.get(i).size() + graph.get(j).size() - 1);
        }
        return max;
    }

}
