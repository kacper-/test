package comt.collection_performance;

import java.util.Date;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.UUID;

public class QueueTree {
    public static void main(String[] args) {
        String[] uuids = new String[1000000];
        for (int i = 0; i < 1000000; i++)
            uuids[i] = UUID.randomUUID().toString();

        TreeMap<String, String> map = new TreeMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>();

        long start = new Date().getTime();

        for (int i = 0; i < 1000000; i++)
            map.put(uuids[i],uuids[i]);
            //queue.add(uuids[i]);

        System.out.printf("adding time = %d\n", new Date().getTime() - start);

        for (int i = 0; i < 10; i++)
            System.out.println(queue.poll());
    }
}
