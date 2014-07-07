package c08_object_oriented_design.E08_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {

    List<Queue<Employee>> employees = new ArrayList<>();
    List<Queue<Call>> calls = new ArrayList<>();

    private final int[] EMPLOYEE_COUNTS = {100, 10, 1};

    public CallCenter() {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            Queue<Employee> queue = new ConcurrentLinkedQueue<>();
            for (int i = 0; i < EMPLOYEE_COUNTS[rank.ordinal()]; i++) {
                queue.add(Employee.create(rank, i));
            }
            employees.add(queue);
            calls.add(new ConcurrentLinkedQueue<>());
        }
    }

    private static CallCenter instance = new CallCenter();

    public static CallCenter getInstance() {
        return instance;
    }

    public void dispatchCall(Call call) {
        Employee employee = getAvailableEmployee(call);
        if (employee != null) {
            employee.handleCall(call);
        } else {
            enqueueCall(call);
        }
    }

    private void enqueueCall(Call call) {
        Queue<Call> queue = getCallsQueue(call.getRank());
        queue.add(call);
    }

    private Employee getAvailableEmployee(Call call) {
        Queue<Employee> queue = getEmployeeQueue(call.getRank());
        return queue.poll();
    }

    public void reportAvailable(Employee employee) {
        getEmployeeQueue(employee.getRank()).add(employee);
        Call nextCall = getCallsQueue(employee.getRank()).poll();
        if (nextCall != null) {
            dispatchCall(nextCall);
        }

    }

    private Queue<Employee> getEmployeeQueue(Rank rank) {
        return employees.get(rank.ordinal());
    }

    private Queue<Call> getCallsQueue(Rank rank) {
        return calls.get(rank.ordinal());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            CallCenter.getInstance().dispatchCall(new Call());
        }
    }
}
