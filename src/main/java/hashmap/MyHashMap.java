package hashmap;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;

    private int size;
    private final int capacity;
    private Node<K, V>[] buckets;

    public MyHashMap() {
        this.capacity = DEFAULT_CAPACITY;
        this.buckets = new Node[capacity];
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Node[capacity];
    }

    private int hash(K key) {
        if (key != null) {
            return key.hashCode() % capacity;
        } else
            return -1;
    }

    public void put(K key, V value) {
        if (key != null) {
            int index = hash(key);
            Node<K, V> node = new Node<>(key, value);
            boolean inserted = false;
            if (buckets[index] == null) {
                buckets[index] = node;
                inserted = true;
            } else {
                inserted = buckets[index].putNode(key, value);
            }

            if (inserted)
                size++;
        }
    }

    @Override
    public V get(K key) {
        V returnValue = null;

        if (key != null) {
            int index = hash(key);
            Node<K, V> temp = buckets[index];
            if (temp != null) {
                Node<K, V> node = temp.getNode(key);
                if (node != null)
                    returnValue = node.value;
            }
        }

        return returnValue;
    }

    @Override
    public void remove(K key) {
        if (key != null) {
            int index = hash(key);
            boolean deleted = false;
            Node<K, V> temp = buckets[index];

            if (temp != null) {
                if (temp.key.equals(key)) {
                    buckets[index] = temp.next;
                    deleted = true;
                } else {

                    Node<K, V> prev = temp;
                    temp = temp.next;

                    while (temp != null) {
                        if (temp.key.equals(key)) {
                            prev.next = temp.next;
                            deleted = true;
                        }
                        prev = temp;
                        temp = temp.next;
                    }
                }
            }
            if (deleted)
                size--;
        }
    }

    @Override
    public void clear() {
        Node<K, V>[] temp = buckets;
        if (temp != null) {
            for (int i = 0; i < size; i++) {
                temp[i] = null;
            }
            size = 0;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<K, V> {
        private Node<K, V> next;
        private final K key;
        private final V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private Node<K, V> getNode(K key) {
            Node<K, V> temp = this;

            while (temp.next != null) {
                if (temp.key.equals(key))
                    return temp;
                temp = temp.next;
            }

            if (temp.key.equals(key))
                return temp;
            else
                return null;
        }

        private boolean putNode(K key, V value) {
            Node<K, V> newNode = new Node<>(key, value);
            Node<K, V> temp = this;

            while (temp.next != null) {
                if (temp.key.equals(newNode.key)) {
                    return true;
                } else
                    temp = temp.next;
            }
            if (!temp.key.equals(newNode.key)) {
                temp.next = newNode;
                return true;
            }
            return false;
        }
    }
}
