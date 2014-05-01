package c03_stacks_and_queues;

public class E03_04 {
    static class Tower extends Stack<Integer> {
        private String name;

        @Override
        public String toString() {
            return name;
        }

        Tower(String name) {
            this.name = name;
        }

        @Override
        public void push(Integer e) {
            Integer prev = peek();
            if (prev != null && prev < e) {
                throw new IllegalArgumentException(String.format("Cannot place %d on top of %d", e, prev));
            }
            super.push(e);
        }
    }

    public static void move(int count, Tower from, Tower to, Tower spare) {
        if (count == 0) {
            return;
        }
        move(count - 1, from, spare, to);
        primitiveMove(from, to);
        move(count - 1, spare, to, from);
    }

    private static void primitiveMove(Tower from, Tower to) {
        Integer e = from.pop();
        System.out.println(String.format("Moving %s: %s -> %s", e, from, to));
        to.push(e);
    }

    public static void main(String[] args) {
        Tower t1 = new Tower("1");
        t1.push(4);
        t1.push(3);
        t1.push(2);
        t1.push(1);
        Tower t2 = new Tower("2");
        Tower t3 = new Tower("3");
        move(4, t1, t3, t2);
    }
}
