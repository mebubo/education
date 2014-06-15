package c09_recursion_and_dynamic_programming;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static c09_recursion_and_dynamic_programming.E09_04.subsets;
import static c09_recursion_and_dynamic_programming.Utils.getSet;
import static org.junit.Assert.*;

public class E09_04Test {

    @Test
    public void testSubsets() throws Exception {
        assertEquals(createListOfSets(), subsets(new HashSet<String>(Arrays.asList("a", "b", "c"))));
    }

    private Set<Set<String>> createListOfSets() {
        return new HashSet<>(Arrays.asList(
                getSet(),
                getSet("a"),
                getSet("b"),
                getSet("c"),
                getSet("a", "b"),
                getSet("a", "c"),
                getSet("b", "c"),
                getSet("a", "b", "c")
        ));
    }

}