package c09_recursion_and_dynamic_programming.e09_10;

public class Box implements Comparable<Box> {
    int width, height, depth;

    public Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public int compareTo(Box o) {
        if (width < o.width && height < o.height && depth < o.depth) {
            return -1;
        }
        if (width > o.width && height > o.height && depth > o.depth) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Box{" +
                width +
                ", " + height +
                ", " + depth +
                '}';
    }
}
