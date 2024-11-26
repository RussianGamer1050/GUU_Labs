class DepositThread extends Thread {
    private BankAccount account;
    private int sum;
    private boolean hasTask = false;
    private boolean closed = false;

    public DepositThread(BankAccount account) {
        this.account = account;
    }

    public boolean isTaskCoplete() {
        return !hasTask;
    }

    public synchronized void setSum(int sum) {
        this.sum = sum;
        hasTask = true;
        notify();
    }

    public synchronized void close() {
        closed = true;
        notify();
    }


    public void run() {
        while (true) { // выполнение пока поток не закроется
            synchronized(this) {
                // Ожидание задачи
                while (!hasTask && !closed) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                }
                // Выход при закрытии
                if (closed) {
                    break;
                }
                // Выполнение задачи
                account.deposit(sum);
                hasTask = false;
            }
        }
    }
}
