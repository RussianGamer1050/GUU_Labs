public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        // ReentrantLockCounter counter = new ReentrantLockCounter(); // Вышел в два раза дольше
        Thread[] threads = new Thread[10];

        long timer = System.nanoTime();

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Final count: " + counter.getCount());
        System.out.println("Time on work: " + (System.nanoTime() - timer));
    }
}
