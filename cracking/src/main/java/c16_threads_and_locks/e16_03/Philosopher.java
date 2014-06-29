package c16_threads_and_locks.e16_03;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable {

    private final List<Chopstick> chopsticks;
    private final int id;

    public Philosopher(int id, List<Chopstick> chopsticks) {
        this.id = id;
        this.chopsticks = chopsticks;
    }

    @Override
    public void run() {
        dine();
    }

    private void dine()  {
        int first = id % 2 == 0 ? 0 : 1;
        int second = id % 2 == 0 ? 1 : 0;
        Chopstick left = takeChopstick(first);
        left.lock();
        try {
            System.out.println(String.format("Philosopher %d took a chopstick at %d", id, first));
            Chopstick right = takeChopstick(second);
            try {
                right.lock();
                System.out.println(String.format("Philosopher %d took a chopstick at %d", id, second));
                eat();
            } finally {
                right.unlock();
            }
        } finally {
            left.unlock();
        }
        System.out.println(String.format("Philosopher %d has finished", id));
    }

    private void eat() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private Chopstick takeChopstick(int offset) {
        int i = (id + offset) % chopsticks.size();
        if (i < 0) {
            i = chopsticks.size() + i;
        }
        return chopsticks.get(i);

    }
}
