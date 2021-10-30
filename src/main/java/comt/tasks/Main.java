package comt.tasks;

public class Main {

    public static void main(String args[]) {
        Holder holder = new Holder();

        Runner r1 = new Runner(holder, "R1");
        Runner r2 = new Runner(holder, "R2");

        try {
            run(r1, r2, holder);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void run(Runner r1, Runner r2, Holder holder) throws InterruptedException {
        new Thread(r1).start();
        new Thread(r2).start();

        Thread.sleep(500);
        holder.update();
    }
}
