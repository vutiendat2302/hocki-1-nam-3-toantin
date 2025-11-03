package stack;

public class StackNode<E> {
    class Node<E> {
        E data;
        Node next;

    }
    Node stack = null; // Stack trỏ tới đỉnh của ngăn xép


    public void push(E data) {
        Node node = new Node();
        node.data = data;
        node.next = stack;
        stack = node;
    }

    public E pop() {
        E data = stack.data;
        stack = stack.next;
        return data;
    }
}
