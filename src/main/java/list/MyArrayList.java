package list;

public class MyArrayList<E> implements MyList<E> {

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

    @Override
    public void display() {
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.println(array[i]);
            } else
                System.out.print(array[i] + ", ");
        }
    }
}
