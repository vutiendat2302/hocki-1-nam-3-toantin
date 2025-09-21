package rvmidterm;

public class MyQueue<Key extends Comparable<Key>> {
    ListNode<Key> front, rear;

    void enqueue(Key key) {
        ListNode<Key> nextNode = new ListNode<>(key);
        if (rear != null) {
            rear.next = nextNode;
        } else {
            front = rear = nextNode;
        }
    }

    Key dequeue() {
        if (front == null) {
            return null;
        } else {
            Key key = front.data;
            front = front.next;
            return key;
        }
    }
}
