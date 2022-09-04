package stack;

public interface Stack<E> {
    void push(E value);
    void remove(E object) ;
    void clear();
    int size();
    E peek();
    E pop();

}
