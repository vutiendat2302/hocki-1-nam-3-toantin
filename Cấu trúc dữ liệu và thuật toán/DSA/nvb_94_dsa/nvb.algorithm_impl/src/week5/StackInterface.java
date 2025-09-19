package week5;

public interface StackInterface<T> extends Iterable<T> {
    public void push(T item);
    public T pop();
    public boolean isEmpty();
}
