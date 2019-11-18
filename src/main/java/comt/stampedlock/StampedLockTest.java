package comt.stampedlock;

import java.util.Random;
import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {
    private static final StampedLock sl = new StampedLock();

    public static void main(String[] args) {
        Thread r = new Thread(StampedLockTest::report);
        r.start();
        new Thread(StampedLockTest::read).start();
        new Thread(StampedLockTest::read).start();
        new Thread(StampedLockTest::read).start();
        new Thread(StampedLockTest::read).start();
        new Thread(StampedLockTest::read).start();
        new Thread(StampedLockTest::write).start();
        try {
            r.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void report() {
        try {
            for (int i = 0; i < 10; i++) {
                //System.out.println("count = " + sl.getReadLockCount());
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void read() {
        long stamp = 0;
        try {
            Thread.sleep(new Random().nextInt(5000));
            stamp = sl.readLock();
            System.out.println("locked with " + stamp);
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sl.unlockRead(stamp);
            System.out.println("unlocked with " + stamp);
        }
    }

    private static void write() {
        long stamp = 0;
        try {
            Thread.sleep(5000);
            System.out.println("writing lock attempt");
            stamp = sl.writeLock();
            System.out.println("locked for writing with " + stamp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sl.unlockWrite(stamp);
            System.out.println("unlocked writing with " + stamp);
        }
    }
}
