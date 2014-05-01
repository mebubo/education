package c03_stacks_and_queues;

public class E03_05<T> {
    private Stack<T> to = new Stack<>();
    private Stack<T> from = new Stack<>();

    public void enqueue(T e) {
        to.push(e);
    }

    public T dequeue() {
        if (from.size() == 0) {
            transferAll(to, from);
        }
        return from.pop();
    }

    private void transferAll(Stack<T> from, Stack<T> to) {
        while (from.peek() != null) {
            to.push(from.pop());
        }
    }
}
