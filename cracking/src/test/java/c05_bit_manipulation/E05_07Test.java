package c05_bit_manipulation;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static c05_bit_manipulation.E05_07.findMissing;
import static org.junit.Assert.*;

public class E05_07Test {

    @Test
    public void testFindMissing() throws Exception {
        assertEquals(10, findMissing(createListWithMissing(100, 10)));
        assertEquals(0, findMissing(createListWithMissing(100, 0)));
        assertEquals(0, findMissing(createListWithMissing(1, 0)));
        assertEquals(1, findMissing(createListWithMissing(2, 1)));
        assertEquals(2, findMissing(createListWithMissing(3, 2)));
    }

    private List<E05_07.BitInteger> createListWithMissing(int length, int missing) {
        return IntStream.range(0, length)
                .filter(x -> x != missing)
                .mapToObj(E05_07.BitInteger::create)
                .collect(Collectors.toList());
    }
}