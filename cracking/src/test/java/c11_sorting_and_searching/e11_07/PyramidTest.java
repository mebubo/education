package c11_sorting_and_searching.e11_07;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static c11_sorting_and_searching.e11_07.Pyramid.findLongestPyramid;
import static org.junit.Assert.*;

public class PyramidTest {

    private List<Person> staff;
    private List<Person> correctSolution;

    @Before
    public void setUp() {
        staff = Arrays.asList(p(65, 100), p(70, 150), p(56, 90), p(75, 190), p(60, 95), p(68, 110));
        correctSolution = Arrays.asList(p(75, 190), p(70, 150), p(68, 110), p(65, 100), p(60, 95), p(56, 90));
    }

    private static Person p(int h, int w) {
        return new Person(h, w);
    }

    @Test
    public void testFindLongestPyramid() throws Exception {
        assertEquals(correctSolution, findLongestPyramid(staff));
    }
}