package c01_arrays_and_strings;

public class HashMap<K, V> implements Map<K, V> {
    static class Entry<K, V> {
        private final K key;
        private final V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int SIZE = 32;
    private Entry<K, V>[] buckets = new Entry[SIZE];

    private int indexForObject(Object o) {
        return o.hashCode() % SIZE;
    }

    @Override
    public V put(K key, V value) {
        int index = indexForObject(key);
        Entry<K, V> head = buckets[index];
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (head == null) {
            buckets[index] = newEntry;
            return null;
        }
        if (head.key.equals(key)) {
            buckets[index] = newEntry;
            newEntry.next = head.next;
            return head.value;
        }
        Entry<K, V> parent = findMatch(head, key);
        return replace(parent, newEntry);
    }

    private V replace(Entry<K, V> parent, Entry<K, V> newEntry) {
        Entry<K, V> child = parent.next;
        parent.next = newEntry;
        if (child != null) {
            newEntry.next = child.next;
            return child.value;
        }
        return null;
    }

    private Entry<K, V> findMatch(Entry<K, V> entry, K key) {
        while (entry.next != null ) {
            if (entry.next.key.equals(key)) {
                break;
            }
            entry = entry.next;
        }
        return entry;
    }

    @Override
    public V get(Object key) {
        int index = indexForObject(key);
        Entry<K, V> head = buckets[index];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = indexForObject(key);
        Entry<K, V> head = buckets[index];
        if (head == null) {
            return null;
        }
        if (head.key.equals(key)) {
            buckets[index] = head.next;
            return head.value;
        }
        while (head.next != null) {
            head = head.next;
            if (head.key.equals(key)) {
                return head.value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(Integer.toString(i), "bar");
        }
        System.out.println(map.put("44", "baz"));
        System.out.println(map.get("44"));
        System.out.println(map.remove("44"));
        System.out.println(map.get("44"));
        System.out.println("end");
    }
}
