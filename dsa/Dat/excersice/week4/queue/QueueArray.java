package queue;

public class QueueArray<E> {
    E queue[];
    int front = 0;
    int rear = 0;
    int count = 0;

    public void enqueue(E data) {
        if (count < queue.length) {
            queue[front + count] = data;
            count++;
        }
    }

    public E dequeue() {
        if (count > 0) {
            count--;
            return queue[front++];
        }
        return null;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
