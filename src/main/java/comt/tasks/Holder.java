package comt.tasks;

import java.time.Instant;

public class Holder {
    private volatile int val = 1;
    private Instant time;

    public int getVal() {
        return val;
    }

    public int getTime() {
        return time.getNano();
    }

    public void update() {
        time = Instant.now();
        val++;
    }

}
