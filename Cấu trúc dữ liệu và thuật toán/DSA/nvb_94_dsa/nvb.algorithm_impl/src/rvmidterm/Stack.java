package rvmidterm;

public interface Stack <T> extends Iterable<T> {
    public void push(T item);

    public T pop();

    public boolean isEmpty();
}
