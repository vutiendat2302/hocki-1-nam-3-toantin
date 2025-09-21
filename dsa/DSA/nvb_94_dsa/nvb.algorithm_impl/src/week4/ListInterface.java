package week4;

public interface ListInterface<T> extends Iterable<T> {
    public void add(T data);
    public T get(int index);
    public void set(int index, T data);
    public void remove(T data);
    public boolean isContains(T data);
    public int size();
    public boolean isEmpty();
}
