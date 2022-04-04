package comt.broadcast;

public class Main {
    public static void main(String args[]) {
        new Thread(new Receiver()).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //new Thread(new Sender()).start();
    }
}
