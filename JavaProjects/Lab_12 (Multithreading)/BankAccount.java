class BankAccount {
    private int balance = 0;

    public int getBalance() {
        return balance;
    }


    public synchronized boolean deposit(int sum) {
        balance += sum;
        return true;
    }

    public synchronized boolean withdraw(int sum) {
        if (balance > sum) {
            balance -= sum;
            return true;
        } else {
            System.out.println("! На счету недостаточно средств !\n");
            return false;
        }
    }
}
