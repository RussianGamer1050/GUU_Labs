public class Main {
    public static void main(String[] args) {
        // Через Thread
        // MyThread t1 = new MyThread();
        // MyThread t2 = new MyThread();
        // MyThread t3 = new MyThread();
        
        // Через Runnable
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        Thread t3 = new Thread(new MyRunnable());
        
        t1.start();
        t2.start();
        t3.start();

    }
}