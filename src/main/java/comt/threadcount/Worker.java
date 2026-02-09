package comt.threadcount;

public class Worker  implements Runnable {

    private final int number;

    public Worker(int i) {
        number = i;
    }

    @Override
    public void run() {
        System.out.println("\tstart "+number);
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\tstop "+number);
    }
}
