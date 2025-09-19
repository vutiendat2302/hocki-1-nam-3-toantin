package rvmidterm;

public class UnorderedMPQ<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {
    private Key [] queue;
    private int size;

    public UnorderedMPQ(int capacity) {
        queue = (Key []) new Comparable[capacity];
        size = 0;
    }

    @Override
    public void insert(Key key) {
        queue[size] = key;
        size++;
    }

    @Override
    public Key delete() {
        if (isEmpty()) {
            throw new ArrayStoreException("The queue is empty");
        }
        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (queue[maxIndex].compareTo(queue[i]) < 0) {
                maxIndex = i;
            }
        }
        Key key = queue[maxIndex];
        queue[maxIndex] = queue[size - 1];
        queue[size - 1] = null;
        size--;
        return key;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Key max() {
        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (queue[maxIndex].compareTo(queue[i]) < 0) {
                maxIndex = i;
            }
        }
        return queue[maxIndex];
    }

    @Override
    public int size() {
        return size;
    }
}
