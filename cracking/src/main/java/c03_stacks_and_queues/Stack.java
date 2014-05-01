package c03_stacks_and_queues;

import c02_linked_lists.Node;

public class Stack<T> {

    private int size;

    public int size() {
        return size;
    }

    private static class Node<T> {

        Node<T> next;
        T data;
        public Node(T data) {
            this.data = data;
        }

        public Node(Node next, T data) {
            this.next = next;
            this.data = data;
        }

    }
    private Node<T> head;

    public void push(T e) {
        size++;
        head = new Node(head, e);
    }

    public T pop() {
        if (head == null) {
            return null;
        }
        size--;
        T result = head.data;
        head = head.next;
        return result;
    }

    public T peek() {
        return head == null ? null : head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
