package c02_linked_lists;

import org.junit.Test;

import static c02_linked_lists.E02_07.isPalindrome;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static c02_linked_lists.Node.createList;

public class E02_07Test {
    @Test
    public void testIsPalindrome() throws Exception {
        assertTrue(isPalindrome(createList(1, 2, 3, 2, 1)));
        assertFalse(isPalindrome(createList(1, 2, 3)));
    }
}
