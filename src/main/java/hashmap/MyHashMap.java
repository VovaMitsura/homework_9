package hashmap;

public class MyHashMap<K, V> implements Map<K, V> {

    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "Vo");
        hashMap.put(1, "4");
        hashMap.put(3, "eq");
        hashMap.put(4, "qw");

        System.out.println(hashMap.get(3));

        System.out.println(hashMap.get(4));
        System.out.println(hashMap.get(5));

        hashMap.remove(2);
        hashMap.remove(4);
        hashMap.remove(3);
        hashMap.remove(1);
        hashMap.remove(1);

    }

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
