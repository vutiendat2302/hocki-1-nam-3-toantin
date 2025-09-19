package rvmidterm;

public class LinkedListOrderedMPQ<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {
    private ListNode<Key> top;
    private int size;

    public LinkedListOrderedMPQ() {
        top = null;
        size = 0;
    }

    @Override
    public void insert(Key key) {
        ListNode<Key> newTop = new ListNode<>(key);
        if (top == null || top.data.compareTo(key) < 0) {
            newTop.next = top;
            top = newTop;
        }

        ListNode<Key> current = top;
        while (current.next != null && current.next.data.compareTo(key) > 0) {
            current = current.next;
        }
        newTop.next = current.next;
        current.next = newTop;

        size++;
    }

    @Override
    public Key delete() {
        if (top == null) {
            return null;
        }
        Key key = top.data;
        top = top.next;
        return key;
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
        return top.data;
    }

    @Override
    public int size() {
        return size;
    }
}
