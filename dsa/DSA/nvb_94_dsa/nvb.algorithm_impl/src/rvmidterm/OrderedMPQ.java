package rvmidterm;

public class OrderedMPQ<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {
    private Key [] queue;
    private int size;

    public OrderedMPQ(int capacity) {
        queue = (Key []) new Comparable[capacity];
        size = 0;
    }

    public Key[] toArray() {
        return queue;
    }

    @Override
    public void insert(Key key) {
        int i = size - 1;
        while (i >= 0 && queue[i].compareTo(key) > 0) {
            queue[i + 1] = queue[i];
            i--;
        }
        queue[i + 1] = key;
        size++;
    }

    @Override
    public Key delete() {
        Key top = queue[size - 1];
        size--;
        return top;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Key max() {
        if (isEmpty()) {
            throw new ArrayStoreException("Queue is empty");
        }
        return queue[size - 1];
    }

    @Override
    public int size() {
        return size;
    }
}
