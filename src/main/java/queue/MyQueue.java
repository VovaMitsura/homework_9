package queue;

public interface MyQueue<E>{
    void add(E value);
    void remove(E index);
    void clear();
    int size() ;
    E peek() ;
    E poll() ;

}
