package c16_threads_and_locks.e16_05;

import java.util.concurrent.CountDownLatch;

public class Foo {

    CountDownLatch firstCalled = new CountDownLatch(1);
    CountDownLatch secondCalled = new CountDownLatch(1);

    public void first() {
        System.out.println("Foo.first");
    }

    public void second() {
        System.out.println("Foo.second");
    }

    public void third() {
        System.out.println("Foo.third");
    }

    public void firstWrapper() {
        first();
        firstCalled.countDown();
    }

    public void secondWrapper() {
        try {
            firstCalled.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        second();
        secondCalled.countDown();
    }

    public void thirdWrapper() {
        try {
            secondCalled.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        third();
    }
}
