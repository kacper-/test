package comt.tasks;

import java.time.Instant;

public class Runner implements Runnable {
    private Holder holder;
    private String name;

    public Runner(Holder holder, String name) {
        this.holder = holder;
        this.name = name;
    }

    @Override
    public void run() {
        while (holder.getVal() == 1) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        int now = Instant.now().getNano();
        System.out.println(name + " " + (now - holder.getTime()));
    }
}
