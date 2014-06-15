package c09_recursion_and_dynamic_programming;

import org.junit.Test;

import static c09_recursion_and_dynamic_programming.E09_02.countRobotPaths;
import static c09_recursion_and_dynamic_programming.E09_02.findPaths;
import static c09_recursion_and_dynamic_programming.Utils.mapToCharArray;
import static org.junit.Assert.*;

public class E09_02Test {

    @Test
    public void testCountRobotPaths() throws Exception {
        assertEquals(2, countRobotPaths(2, 2));
        assertEquals(3, countRobotPaths(2, 3));
        assertEquals(3, countRobotPaths(3, 2));
    }

    @Test
    public void testFindPaths() throws Exception {
        char[][] map = mapToCharArray(new String[] {
                "  X",
                " X ",
                "X  "});
        System.out.println(findPaths(map, 0, 0));
    }
}