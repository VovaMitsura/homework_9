package list;

public class MyArrayList<E> implements List<E> {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);

        list.display();

        list.remove(3);
        list.remove(1);
        list.remove(2);
        list.remove(4);
        list.remove(5);
        list.remove(0);
        list.remove(1);
        list.remove(2);
        list.remove(3);
        list.remove(0);
        list.remove(1);
        list.remove(0);
        list.remove(0);

        System.out.println(list.size());
        list.display();
        System.out.println(list.size());

        list.clear();

    }

    private static final int DEFAULT_CAPACITY = 10;

    private E[] array;
    private int size;

    public MyArrayList() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(E value) {
        if (size < array.length) {
            array[size++] = value;
        } else {
            E[] temp = array;
            array = (E[]) new Object[(int) (array.length * 1.5 + 1)];
            System.arraycopy(temp, 0, array, 0, temp.length);
            array[size++] = value;
        }
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            E[] temp = array;
            array = (E[]) new Object[array.length - 1];
            System.arraycopy(temp, 0, array, 0, index);
            System.arraycopy(temp, index + 1, array, index, size - index);
            size--;
        }
    }

    @Override
    public void clear() {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                array[i] = null;
            }
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        } else
            return null;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.println(array[i]);
            } else
                System.out.print(array[i] + ", ");
        }
    }
}
