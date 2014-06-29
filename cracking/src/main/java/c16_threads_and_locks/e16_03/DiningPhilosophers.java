package c16_threads_and_locks.e16_03;

import java.util.ArrayList;
import java.util.List;

public class DiningPhilosophers {

    List<Philosopher> philosophers;
    List<Chopstick> chopsticks;

    public DiningPhilosophers(int size) {
        chopsticks = new ArrayList<Chopstick>();
        for (int i = 0; i < size; i++) {
            chopsticks.add(new Chopstick());
        }
        philosophers = new ArrayList<Philosopher>();
        for (int i = 0; i < size; i++) {
            philosophers.add(new Philosopher(i, chopsticks));
        }
    }

    public static void main(String[] args) {
        new DiningPhilosophers(3).dine();
    }

    private void dine() {
        for (Philosopher philosopher : philosophers) {
            new Thread(philosopher).start();
        }
    }
}
