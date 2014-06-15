package c09_recursion_and_dynamic_programming;

import org.junit.Test;

import static c09_recursion_and_dynamic_programming.E09_07.paintFill;
import static c09_recursion_and_dynamic_programming.Utils.mapToCharArray;
import static org.junit.Assert.*;

public class E09_07Test {

    @Test
    public void testPaintFill() throws Exception {
        char[][] screen = mapToCharArray(SCREEN);
        paintFill(screen, 15, 1, '*');
        assertArrayEquals(mapToCharArray(FILLED), screen);
    }

    private static String[] SCREEN = new String[] {
            "...........x............",
            "..........x.............",
            ".........x............ff",
            "........x.............f.",
            "........x.............f.",
            "........x............f..",
            "........x............fff",
            "xxxxxxxxx...............",
            "...........c............",
            "..........c.c..........."
    };

    private static String[] FILLED = new String[] {
            "...........x************",
            "..........x*************",
            ".........x************ff",
            "........x*************f.",
            "........x*************f.",
            "........x************f..",
            "........x************fff",
            "xxxxxxxxx***************",
            "***********c************",
            "**********c.c***********"
    };
}