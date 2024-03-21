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

    public static int task3(int[] A, int B[], int N) {
        if (A == null || B == null)
            return 0;

        if (A.length == 0 || B.length == 0 || B.length != A.length)
            return 0;

        Element max;
        Element max2;

        Map<Integer, Element> graph = new HashMap<>();
        for (int i : A)
            graph.putIfAbsent(i, new Element(i));
        for (int i : B)
            graph.putIfAbsent(i, new Element(i));

        for (int i = 0; i < N; i++)
            graph.get(A[i]).edges.add(B[i]);
        for (int i = 0; i < N; i++)
            graph.get(B[i]).edges.add(A[i]);

        Object[] arr = graph.values().toArray();

        int realMax = 0;
        int val;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = arr.length - 1; j > 0; j--) {
                if (i == j)
                    continue;

                max = (Element) arr[i];
                max2 = (Element) arr[j];

                if (max.edges.contains(max2.vertex) || max2.edges.contains(max.vertex)) {
                    val = max.getSize() + max2.getSize() - 1;
                } else {
                    val = Math.max(max2.getSize(), max.getSize());
                }

                if (val > realMax)
                    realMax = val;
            }
        }
        return realMax;
    }

    static class Element {

        public Element(int vertex) {
            this.vertex = vertex;
        }

        int vertex;
        Set<Integer> edges = new HashSet<>();

        public int getSize() {
            return edges.size();
        }
    }
}
