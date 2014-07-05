package c09_recursion_and_dynamic_programming.e09_10;

import java.util.List;

public class Solution {
    List<Box> stack;

    public Solution(List<Box> stack) {
        this.stack = stack;
    }

    public int getHeight() {
        return stack.stream().mapToInt(b -> b.height).sum();
    }
}
