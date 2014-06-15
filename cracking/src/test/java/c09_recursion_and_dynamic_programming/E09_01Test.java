package c09_recursion_and_dynamic_programming;

import org.junit.Test;

import static c09_recursion_and_dynamic_programming.E09_01.countWaysToSkipSteps;
import static org.junit.Assert.*;

public class E09_01Test {

    @Test
    public void testCountWaysToSkipSteps() throws Exception {
        assertEquals(0, countWaysToSkipSteps(-1));
        assertEquals(0, countWaysToSkipSteps(-2));
        assertEquals(1, countWaysToSkipSteps(0));
        assertEquals(1, countWaysToSkipSteps(1));
        assertEquals(2, countWaysToSkipSteps(2));
        assertEquals(4, countWaysToSkipSteps(3));
    }
}