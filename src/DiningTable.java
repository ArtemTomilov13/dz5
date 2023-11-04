import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningTable {
    private Lock[] forks;

    public DiningTable(int numForks) {
        forks = new ReentrantLock[numForks];
        for (int i = 0; i < numForks; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public boolean takeForks(int leftForkIndex, int rightForkIndex) {
        if (forks[leftForkIndex].tryLock()) {
            if (forks[rightForkIndex].tryLock()) {
                return true;
            } else {
                forks[leftForkIndex].unlock();
            }
        }
        return false;
    }

    public void releaseForks(int leftForkIndex, int rightForkIndex) {
        forks[leftForkIndex].unlock();
        forks[rightForkIndex].unlock();
    }
}
