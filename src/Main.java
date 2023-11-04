
public class Main {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        DiningTable diningTable = new DiningTable(numPhilosophers);

        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, diningTable);
            philosophers[i].start();
        }
    }
}

