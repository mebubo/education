package ch04;

interface Stack<T> {
    void push(T e);
    T pop();
    boolean isEmpty();
}

public class LinkedListStack<T> implements Stack<T> {

    private class Element {
        Element next;
        T data;

        Element(T data) {
            this.data = data;
        }
    }

    private Element head;

    @Override
    public void push(T data) {
        Element newHead = new Element(data);
        newHead.next = head;
        head = newHead;
    }

    @Override
    public T pop() {
        if (head == null) {
            throw new IllegalArgumentException("Attempt to pop from an empty stack");
        }
        Element oldHead = head;
        head = oldHead.next;
        return oldHead.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

}
