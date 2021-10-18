package comt.daemon;

public class Daemon {
    public static void main(String args[]) {
        Thread user = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("user");
            }
        });
        user.start();
        Thread daemon = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("daemon");
            }
        });
        daemon.setDaemon(true);
        daemon.start();
    }
}
