package queue;

public interface Queue {
    public void enqueue(E data);
    public void E dequeue();
    public boolean isEmpty();
}
