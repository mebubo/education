package c11_sorting_and_searching.e11_08;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class TrackingTest {

    private Tracking tracking;

    @Before
    public void setUp() {
        this.tracking = new Tracking();
        Tracking tracking = this.tracking;
        Integer[] input = {5, 10, 13, 15, 20, 20, 23, 24, 25};
        Collections.shuffle(Arrays.asList(input));
        System.out.println(Arrays.asList(input));
        for (int i : input) {
            tracking.track(i);
        }
    }

    @Test
    public void testGetRankOfNumber() throws Exception {
        assertEquals(-1, tracking.getRankOfNumber(19));
        assertEquals(1, tracking.getRankOfNumber(5));
        assertEquals(2, tracking.getRankOfNumber(10));
        assertEquals(3, tracking.getRankOfNumber(13));
        assertEquals(4, tracking.getRankOfNumber(15));
        assertEquals(6, tracking.getRankOfNumber(20));
        assertEquals(7, tracking.getRankOfNumber(23));
        assertEquals(8, tracking.getRankOfNumber(24));
        assertEquals(9, tracking.getRankOfNumber(25));
    }
}