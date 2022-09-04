package list;

public interface List <E>{
    void add(E value);
    void remove(int index);
    void clear();
    int size();
    E get(int index);
}
