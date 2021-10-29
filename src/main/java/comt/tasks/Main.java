package comt.tasks;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String args[]) {
        Runner runner = new Runner();
        runner.setVal(1);

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(runner, 0, TimeUnit.SECONDS);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(runner.getVal());

        service.shutdown();
        try {
            service.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdownNow();
    }
}
