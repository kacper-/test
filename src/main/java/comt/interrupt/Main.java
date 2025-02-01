package comt.interrupt;

public class Main {
    public  static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i=0;i<10;i++) {
                System.out.println("start");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }
        });
        t.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t.interrupt();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end");
    }
}
