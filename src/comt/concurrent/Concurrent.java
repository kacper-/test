package comt.concurrent;

public class Concurrent {
    private static boolean test = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Concurrent.test = true;
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2000; i++) {
                    System.out.println(Concurrent.test);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
