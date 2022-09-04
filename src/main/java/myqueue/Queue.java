package myqueue;

public interface Queue<E>{
    void add(E value);
    void remove(E index);
    void clear();
    int size() ;
    E peek() ;
    E poll() ;

}
