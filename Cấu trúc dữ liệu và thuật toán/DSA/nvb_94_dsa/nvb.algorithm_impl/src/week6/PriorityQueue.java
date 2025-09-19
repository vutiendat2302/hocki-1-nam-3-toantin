package week6;

public class PriorityQueue<Key extends Comparable<Key>> implements MaxPriority<Key> {
    private Key[] queue;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        queue = new Key[capacity];
        size = 0;
    }

    public void addToQueue() {}

    public Key removeMax() {
        if (size == 0) {
            return -1;
        }

        int maxIndex = 0;

        for (int i = 0; i < size; i++) {
            if (queue[i].compareTo(queue[maxIndex]) > 0) {

            }
        }

        queue[maxIndex] = queue[size - 1];

        return queue[--size];
    }
}
