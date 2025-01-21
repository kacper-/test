package comt.vthreads;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static final int THREADS = 8;
    static AtomicInteger threadStarted = new AtomicInteger(0);
    static AtomicInteger threadFinished = new AtomicInteger(0);
    static AtomicInteger active = new AtomicInteger(0);

    static int k;
    static ThreadMXBean mx = ManagementFactory.getThreadMXBean();

    public static void main(String[] args) {
        new Thread(() -> {
            long start = new Date().getTime();
            while (threadFinished.get() < THREADS) {
                System.out.printf("count = [%d/%d] active = %d %n", threadStarted.get() - threadFinished.get(), mx.getAllThreadIds().length, active.get());
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            long stop = new Date().getTime();
            System.out.println("time = " + (stop - start));
        }).start();

        for (k = 0; k < THREADS; k++) {
            start(k);
        }
    }

    static void start(final int k) {
        Thread.ofPlatform().start(() -> {
            threadStarted.incrementAndGet();
            active.incrementAndGet();
            int n = k;
            double a = (n + 2);
            for (int i = 0; i < 50; i++) {
                try {
                    for (int j = 0; j < 10000000; j++) {
                        a += Math.log(a);
                    }
                    active.decrementAndGet();
                    Thread.sleep(8 + (12 * (long) n));
                    active.incrementAndGet();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            active.decrementAndGet();
            System.out.println("\t\tThread " + n + " finished with = " + a);
            threadFinished.incrementAndGet();
        });
    }
}
