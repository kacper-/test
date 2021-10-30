package comt.tasks;

import java.time.Instant;

public class Runner implements Runnable {
    private Holder holder;
    private String name;
    private int v = 0;

    public Runner(Holder holder, String name) {
        this.holder = holder;
        this.name = name;
    }

    @Override
    public void run() {
        while (holder.getVal() == 1) {
            //v++;
        }
        int now = Instant.now().getNano();
        System.out.println(name + " " + (now - holder.getTime()));
    }
}
