package comt.vthreads;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static AtomicInteger threadCounter = new AtomicInteger(0);

    static int k;

    public static void main(String args[]) {
        new Thread(() -> {
            long start = new Date().getTime();
            while (threadCounter.get() < 10) {
                System.out.println("count = " + Thread.activeCount());
                System.out.println("group count = " + Thread.currentThread().getThreadGroup().activeGroupCount());
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
            threadCounter.incrementAndGet();
        });
    }
}
