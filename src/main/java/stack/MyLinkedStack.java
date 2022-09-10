package stack;

public class MyLinkedStack<E> implements MyStack<E> {

    private Node root;
    private Node tail;
    private int size;

    private class Node {
        private Node next;
        private Node prev;
        private E data;

        private Node(E data) {
            this.data = data;
        }
    }

    @Override
    public void push(E value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = tail = new Node(value);
        } else {
            Node temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.prev = temp;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void remove(E object) {
        if (containsValue(object)) {
            if (root == tail && root.data.equals(object)) {
                root = tail = null;
            } else if (root.data.equals(object)) {
                root = root.next;
                root.prev = null;
            } else if (tail.data.equals(object)) {
                tail = tail.prev;
                tail.next = null;
            } else {
                Node temp = root;
                while (temp.next != null) {
                    if (temp.data.equals(object)) {
                        temp.prev.next = temp.next;
                        temp.next.prev = temp.prev;
                        break;
                    }
                    temp = temp.next;
                }
            }
            size--;
        }
    }

    @Override
    public void clear() {
        if (root != null) {
            root = tail = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E peek() {
        if (tail != null) {
            return tail.data;
        } else
            return null;
    }

    @Override
    public E pop() {
        if (tail != null) {
            E data = tail.data;
            if (tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            } else
                root = tail = null;
            size--;
            return data;
        } else
            return null;
    }

    public boolean containsValue(E value) {
        if (root != null && value != null) {
            if (root.data.equals(value)) {
                return true;
            } else if (tail.data.equals(value)) {
                return true;
            } else {
                Node temp = root;
                while (temp.next != null) {
                    if (temp.data.equals(value)) {
                        break;
                    }
                    temp = temp.next;
                }
                return temp.data.equals(value);
            }
        } else
            return false;
    }
}
