package c01_arrays_and_strings;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HashMapTest {

    private HashMap<String, String> map;

    private static class Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Entry<String, String>> generateEntries() {
        ArrayList<Entry<String, String>> result = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            result.add(new Entry<>(Integer.toString(i), Integer.toString(i*i)));
        }
        return result;
    }

    @Before
    public void setUp() throws Exception {
        map = new HashMap<>();
        map.put("foo", "bar");
    }

    @Test
    public void testPutGet() throws Exception {
        for (Entry<String, String> entry : generateEntries()) {
            map.put(entry.key, entry.value);
        }
        for (Entry<String, String> entry : generateEntries()) {
            assertEquals(map.get(entry.key), entry.value);
        }
    }

    @Test
    public void testRemove() throws Exception {
        assertEquals(map.get("foo"), "bar");
        assertEquals(map.remove("foo"), "bar");
        assertNull(map.get("foo"));
        assertNull(map.remove("foo"));
    }
}
