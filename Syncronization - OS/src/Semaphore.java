// A simple implementation of a semaphore
class Semaphore {
    // The internal counter representing the available resources
    protected int value = 0;

    // Default constructor initializes the semaphore with a value of 0
    protected Semaphore() {
        value = 0;
    }

    // Constructor that allows initialization with a specified value
    protected Semaphore(int initial) {
        value = initial;
    }

    // Acquire a resource (decrement the counter)
    public synchronized void P() {
        value--;

        // If the counter is negative, the thread must wait until a resource is available
        if (value < 0)
            try {
                wait();
            } catch (InterruptedException e) {
                // Exception handling if interrupted while waiting
            }
    }

    // Release a resource (increment the counter)
    public synchronized void V() {
        value++;

        // If there are waiting threads, notify one of them that a resource is available
        if (value <= 0)
            notify();
    }
}
