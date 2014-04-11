package c01_arrays_and_strings;

public interface Map<K, V> {
    V put(K key, V value);
    V get(Object key);
    V remove(Object key);
}
