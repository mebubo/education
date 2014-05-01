package c03_stacks_and_queues;

public class E03_06 {
    public static <T extends Comparable<T>> void sortStack(Stack<T> stack) {
        Stack<T> tmp = new Stack<>();
        Stack<T> sorted = new Stack<>();
        while (!stack.isEmpty() || !tmp.isEmpty()) {
            sorted.push(extractMax(stack, tmp));
        }
        while (!sorted.isEmpty()) {
            stack.push(sorted.pop());
        }
    }

    private static <T extends Comparable<T>> T extractMax(Stack<T> s1, Stack<T> s2) {
        if (s1.isEmpty() && s2.isEmpty()) {
            return null;
        }
        Stack<T> from, to;
        if (s1.isEmpty()) {
            to = s1;
            from = s2;
        } else if (s2.isEmpty()) {
            to = s2;
            from = s1;
        } else {
            throw new RuntimeException("One of stacks should be empty");
        }
        T max = from.pop();
        while (!from.isEmpty()) {
            T current = from.pop();
            if (max.compareTo(current) < 0) {
                to.push(max);
                max = current;
            } else {
                to.push(current);
            }
        }
        return max;
    }

}
