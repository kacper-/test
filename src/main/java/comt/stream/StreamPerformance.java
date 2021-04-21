package comt.stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StreamPerformance {
    public static void main(String[] args) {
        long start, stop, sum;
        List<Long> numbers = createList();

        // using stream
        start = new Date().getTime();
        sum = numbers.stream().reduce(0L, Long::sum);
        stop = new Date().getTime();
        System.out.printf("result %d in %d ms%n", sum, stop - start);

        // using for
        start = new Date().getTime();
        sum = 0;
        for (Long a : numbers) {
            sum += a;
        }
        stop = new Date().getTime();
        System.out.printf("result %d in %d ms%n", sum, stop - start);
    }

    private static List<Long> createList() {
        List<Long> list = new ArrayList<>();
        for (long i = 1; i <= 10000000; i++) {
            list.add(i);
        }
        return list;
    }
}
