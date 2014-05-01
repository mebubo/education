package c03_stacks_and_queues;

public class E03_02<T extends Comparable<? super T>> extends Stack<T> {
    private Stack<T> stackOfMins = new Stack<>();

    @Override
    public void push(T e) {
        super.push(e);
        if (min() == null || min().compareTo(e) >= 0) {
            stackOfMins.push(e);
        }
    }

    @Override
    public T pop() {
        T e = super.pop();
        if (min() != null && min().compareTo(e) == 0) {
            stackOfMins.pop();
        }
        return e;
    }

    public T min() {
        return stackOfMins.peek();
    }
}
