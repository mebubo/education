package c09_recursion_and_dynamic_programming;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static c09_recursion_and_dynamic_programming.E09_06.parentheses;
import static org.junit.Assert.*;

public class E09_06Test {

    @Test
    public void testParentheses() throws Exception {
        assertEquals(new HashSet<>(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()")), parentheses(3));
        assertEquals(new HashSet<>(Arrays.asList("(())", "()()")), parentheses(2));
        assertEquals(new HashSet<>(Arrays.asList("()")), parentheses(1));
        assertEquals(new HashSet<>(Arrays.asList("")), parentheses(0));
    }
}