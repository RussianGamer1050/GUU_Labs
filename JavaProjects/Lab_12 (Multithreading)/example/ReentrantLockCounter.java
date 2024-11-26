import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockCounter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public synchronized void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}
