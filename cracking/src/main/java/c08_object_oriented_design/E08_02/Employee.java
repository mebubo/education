package c08_object_oriented_design.E08_02;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class Employee {
    private final int id;
    private final Random random = new Random();
    protected Rank rank;

    private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public Employee(int i) {
        this.id = i;
    }

    public void handleCall(Call call) {
        double r = random.nextGaussian();
        int delay = (int) (r * 1000 + 1000);
        if (delay < 0) {
            delay = 0;
        }
        executor.schedule(() -> doHandleCall(call), delay, TimeUnit.MILLISECONDS);
    }

    private void doHandleCall(Call call) {
        if (random.nextInt(10) < 8) {
            System.out.printf("employee %s ended call %s\n", this, call);
            call.end();
        } else if (call.getRank() == Rank.Director) {
            System.out.printf("employee %s failed call %s\n", this, call);
            call.fail();
        }
        else {
            System.out.printf("employee %s escalated call %s\n", this, call);
            call.incrementRank();
            CallCenter.getInstance().dispatchCall(call);
        }
        CallCenter.getInstance().reportAvailable(Employee.this);
    }

    public Rank getRank() {
        return rank;
    }

    public static Employee create(Rank rank, int i) {
        switch (rank) {
            case Responder:
                return new Responder(i);
            case Manager:
                return new Manager(i);
            case Director:
                return new Director(i);
            default:
                throw new IllegalArgumentException("unknown rank");
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", rank=" + rank +
                '}';
    }
}
