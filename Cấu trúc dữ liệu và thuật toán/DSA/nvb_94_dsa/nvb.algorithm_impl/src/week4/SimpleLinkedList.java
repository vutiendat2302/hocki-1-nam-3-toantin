package week4;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;
    }

    private Node top;
    private Node bot;
    private int n = 0;

    public void add(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = top;
        top = newNode;
        n++;
    }

    public void addBottom(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = bot;
        bot = newNode;
        n++;
    }

    public T get(int index) {
        int i = 0;
        Node current = top;
        while (i < index) {
            current = current.next;
            i++;
        }

        return current.data;
    }

    public void set(int index, T data) {
        int i = 0;
        Node current = top;
        while (i < index) {
            current = current.next;
            i++;
        }
        current.data = data;
    }

    public boolean isContains(T data) {
        Node current = top;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public int size() {
        Node current = top;
        while (current != null) {
            n++;
            current = current.next;
        }

        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T removeTop() {
        T data = top.data;
        top = top.next;

        return data;
    }

    public T removeBottom() {
        T data = bot.data;
        bot = null;

        return data;
    }

    public void remove(T data) {
        Node current = top;
        while (current.data == data) {
            current = current.next;
        }
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
            }
        }
    }
}
