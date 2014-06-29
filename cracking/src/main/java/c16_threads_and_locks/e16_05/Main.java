package c16_threads_and_locks.e16_05;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(() -> foo.thirdWrapper()).start();
        new Thread(() -> foo.secondWrapper()).start();
        new Thread(() -> foo.firstWrapper()).start();
    }
}
