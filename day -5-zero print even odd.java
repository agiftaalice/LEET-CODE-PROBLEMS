class ZeroEvenOdd {
    private int n;
    private int current = 1;
    private boolean zeroTurn = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x"
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            while (!zeroTurn)
                wait();

            printNumber.accept(0);
            zeroTurn = false;
            notifyAll();
        }
        notifyAll();
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            while (zeroTurn || current % 2 != 0)
                wait();

            if (current > n)
                break;

            printNumber.accept(current);
            current++;
            zeroTurn = true;
            notifyAll();
        }
        notifyAll();
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            while (zeroTurn || current % 2 == 0)
                wait();

            if (current > n)
                break;

            printNumber.accept(current);
            current++;
            zeroTurn = true;
            notifyAll();
        }
        notifyAll();
    }
}
