package c03_stacks_and_queues;

import java.util.ArrayList;
import java.util.List;

public class E03_03<T> {
    private List<Stack<T>> stacks = new ArrayList<>();

    public E03_03(int size) {
        this.size = size;
    }

    private int size;

    public void push(T e) {
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() >= size) {
            stacks.add(new Stack<T>());
        }
        stacks.get(stacks.size() - 1).push(e);

    }

    public T pop() {
        if (stacks.isEmpty()) {
            return null;
        }
        T result = stacks.get(stacks.size() - 1).pop();
        if (stacks.get(stacks.size() - 1).size() == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return result;
    }

    int size() {
        return stacks.size();
    }
}
