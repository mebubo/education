package c14_java.e14_06;

public class CircularArray<T> {

    T[] array;
    int head;

    public CircularArray(int size) {
        array = (T[]) new String[size];
        head = 0;
    }

    public void rotate(int amount) {
        head = convert(amount);
    }

    private int convert(int i) {
        i = i % array.length;
        if (i < 0) {
            i = array.length - i;
        }
        return (head + i) % array.length;
    }
}
