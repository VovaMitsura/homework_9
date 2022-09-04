package hashmap;

public interface Map<K, V> {
    void put(K key, V value);
    void remove(K key);
    V get(K key);
    void clear();
    int size();
}
