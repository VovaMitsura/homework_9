package hashmap;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private Node root;
    private int size;

    private class Node {
        private Node next;
        private K key;
        private V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(K key, V value) {
        if (!containsKey(key)) {
            Node newNode = new Node(key, value);
            if (root == null) {
                root = newNode;
            } else {
                Node temp = root;

                while (temp.next != null) {
                    temp = temp.next;
                }

                temp.next = newNode;
            }
            size++;
        }
    }

    @Override
    public void remove(K key) {
        if (containsKey(key)) {
            if (root.key.equals(key)) {
                root = root.next;
            } else {
                Node temp = root.next;
                Node prev = root;

                while (temp.next != null) {
                    if (temp.key.equals(key)) {
                        break;
                    }
                    prev = prev.next;
                    temp = temp.next;
                }

                prev.next = temp.next;
            }
            size--;
        }
    }

    @Override
    public V get(K key) {
        if (containsKey(key)) {
            Node temp = root;

            V value = null;

            while (temp.next != null) {
                if (temp.key.equals(key)) {
                    value = temp.value;
                    break;
                }
                temp = temp.next;
            }

            if (temp.key.equals(key)) {
                value = temp.value;
            }

            return value;
        } else
            return null;
    }

    @Override
    public void clear() {
        if (root != null) {
            root = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        if (root != null) {
            Node temp = root;

            while (temp.next != null) {
                if (temp.key.equals(key)) {
                    return true;
                }
                temp = temp.next;
            }

            return temp.key.equals(key);
        } else
            return false;
    }
}
