package comt.threadcount;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        long start = new Date().getTime();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Worker(i)).start();
        }
        System.out.println("started in " + (new Date().getTime() - start) + "ms");
    }
}
