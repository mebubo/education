package c14_java.e14_06;

import java.util.Iterator;

public class CircularArray<T> implements Iterable {

    T[] array;
    int head = 0;

    public CircularArray(T[] array) {
        this.array = array;
    }

    public CircularArray(int size) {
        array = (T[]) new Object[size];
    }

    public void rotate(int amount) {
        head = convert(amount);
    }

    private int convert(int i) {
        i = i % array.length;
        if (i < 0) {
            i = array.length + i;
        }
        return (head + i) % array.length;
    }

    public T get(int i) {
        return array[convert(i)];
    }

    public void set(int i, T e) {
        array[convert(i)] = e;
    }

    public T[] toArray() {
        T[] result = (T[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = get(i);
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int i = 0;

            @Override
            public boolean hasNext() {
                return i < array.length;
            }

            @Override
            public T next() {
                return get(i++);
            }
        };
    }
}
