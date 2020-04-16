package comt.stampedlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {
    private static final StampedLock sl = new StampedLock();
    private static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static long ws = 0;

    public static void main(String[] args) {
        Thread r = new Thread(StampedLockTest::report);
        r.start();
//        new Thread(StampedLockTest::read).start();
//        new Thread(StampedLockTest::read).start();
//        new Thread(StampedLockTest::read).start();
//        new Thread(StampedLockTest::read).start();
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
        try {
            //ws = sl.readLock();
            rwl.readLock().lock();
            System.out.println("locked with " + ws);
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void write() {
        long stamp = 0;
        try {
            Thread.sleep(3000);
            System.out.println("unlocking read");
            rwl.readLock().unlock();
            //sl.unlockRead(ws);
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
