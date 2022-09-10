package list;

public class MyLinkedList<E> implements MyList<E> {

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
    public void remove(int index) {
        if (root != null && index >= 0 && index < size) {
            if (index == 0 && size == 1) {
                root = tail = null;
            } else if (index == 0) {
                root = root.next;
                root.prev = null;
            } else if (index == size - 1) {
                tail = tail.prev;
                tail.next = null;
            } else if (index > size / 2) {
                Node temp = tail;

                int i = size - 1;
                while (i > index) {
                    temp = temp.prev;
                    i--;
                }

                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
            } else {
                Node temp = root;

                int i = 0;
                while (i < index) {
                    temp = temp.next;
                    i++;
                }

                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            size--;
        }
    }

    @Override
    public void display() {
        if (root != null) {
            Node temp = root;
            System.out.print(temp.data + " ");
            while (temp.next != null) {
                temp = temp.next;
                System.out.print(temp.data + " ");
            }
        }
    }

    @Override
    public void clear() {
        if (root != null) {
            root = tail = null;
            size = 0;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (root != null && index >= 0 && index < size) {
            if (index == 0) {
                return root.data;
            } else if (index == size - 1) {
                return tail.data;
            } else if (index > size / 2) {
                Node temp = tail;

                int i = size - 1;
                while (i > index) {
                    temp = temp.prev;
                    i--;
                }

                return temp.data;
            } else {
                Node temp = root;

                int i = 0;
                while (i < index) {
                    temp = temp.next;
                    i++;
                }

                return temp.data;
            }
        } else
            return null;
    }
}
