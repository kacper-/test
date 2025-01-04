package comt.vthreads;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static AtomicInteger threadStarted = new AtomicInteger(0);
    static AtomicInteger threadFinished = new AtomicInteger(0);

    static int k;
    static ThreadMXBean mx = ManagementFactory.getThreadMXBean();

    public static void main(String[] args) {
        new Thread(() -> {
            long start = new Date().getTime();
            while (threadFinished.get() < 10) {
                System.out.printf("count = %d / %d%n", threadStarted.get() - threadFinished.get(), mx.getAllThreadIds().length);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            long stop = new Date().getTime();
            System.out.println("time = " + (stop - start));
        }).start();

        for (k = 0; k < 10; k++) {
            start(k);
        }
    }

    static void start(final int k) {
        Thread.ofVirtual().start(() -> {
            threadStarted.incrementAndGet();
            int n = k;
            double a = (n + 2);
            for (int i = 0; i < 50; i++) {
                try {
                    for (int j = 0; j < 10000000; j++) {
                        a += Math.log(a);
                    }
                    Thread.sleep(8 + (12 * (long) n));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread " + n + " finished with = " + a);
            threadFinished.incrementAndGet();
        });
    }
}
