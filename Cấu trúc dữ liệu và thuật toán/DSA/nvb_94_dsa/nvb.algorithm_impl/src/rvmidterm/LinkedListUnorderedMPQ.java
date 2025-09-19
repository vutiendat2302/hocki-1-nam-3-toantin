package rvmidterm;

public class LinkedListUnorderedMPQ<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {

    private ListNode<Key> top;
    private int size;

    public LinkedListUnorderedMPQ() {
        top = null;
        size = 0;
    }

    @Override
    public void insert(Key key) {
        ListNode<Key> newTop = new ListNode<>(key);
        if (top == null) {
            top = newTop;
        }
        newTop.next = top;
        top = newTop;
        size++;
    }

    @Override
    public Key delete() {
        ListNode<Key> temp = top;
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Key maxKey = max();
        if (temp.data.compareTo(maxKey) == 0) {
            top = top.next;
        } else {
            while (temp.next != null) {
                if (temp.next.data.compareTo(maxKey) == 0) {
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
        }
        size--;
        return maxKey;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Key max() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        ListNode<Key> temp = top;
        Key max = temp.data;

        while (temp.next != null) {
            if (max.compareTo(temp.next.data) < 0) {
                max = temp.next.data;
            }
            temp = temp.next;
        }
        return max;
    }

    @Override
    public int size() {
        return size;
    }
}
