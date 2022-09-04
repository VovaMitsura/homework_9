package myqueue;

public class MyQueue<E> implements Queue<E> {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

//        queue.remove(1);
//        queue.remove(3);
//        queue.remove(2);
//        queue.remove(5);
//        queue.remove(3);
//        queue.remove(4);
//        queue.remove(6);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());


    }

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
    public void add(E value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = tail = newNode;
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
            root = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E peek() {
        if (root != null) {
            return root.data;
        } else return null;
    }

    @Override
    public E poll() {
        if (root != null) {
            E data = root.data;
            if (root.next != null) {
                root = root.next;
                root.prev = null;
            } else root = tail = null;
            size--;
            return data;
        } else return null;
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
