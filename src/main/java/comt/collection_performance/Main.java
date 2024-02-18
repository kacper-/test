package comt.collection_performance;

import java.util.*;

public class Main {
    public static void main(String[] ars) {
        Deque<String> ll = new LinkedList<>();
        Deque<String> ad = new ArrayDeque<>(10000000);

        addElements(ll);
        addElements(ad);

        long start = new Date().getTime();

        playStack(ll);
        //playStack(ad);

        System.out.printf("execution time = %d\n", new Date().getTime() - start);
    }

    private static void playStack(Deque<String> deque) {
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++)
                deque.removeFirst();
            for (int j = 0; j < 10000; j++)
                deque.addFirst(UUID.randomUUID().toString());
        }
    }

    private static void addElements(Deque<String> deque) {
        for (int i = 0; i < 10000000; i++)
            deque.addFirst(UUID.randomUUID().toString());
    }

}
