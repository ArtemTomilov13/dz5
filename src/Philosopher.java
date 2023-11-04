class Philosopher extends Thread {
    private int id;
    private DiningTable diningTable;
    private int numEats;

    public Philosopher(int id, DiningTable diningTable) {
        this.id = id;
        this.diningTable = diningTable;
        this.numEats = 0;
    }

    @Override
    public void run() {
        while (numEats < 3) {
            think();
            if (diningTable.takeForks(id, (id + 1) % 5)) {
                eat();
                diningTable.releaseForks(id, (id + 1) % 5);
                numEats++;
            }
        }
    }

    private void think() {
        System.out.println("Философ " + id + " размышляет");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        System.out.println("Философ " + id + " ест");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
