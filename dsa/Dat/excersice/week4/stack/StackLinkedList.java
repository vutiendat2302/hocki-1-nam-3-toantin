package stack;

import static sun.util.locale.LocaleUtils.isEmpty;

public class StackLinkedList<E> implements Stack<E> {
    private class Node {
        E data;
        Node next;
    }

    private Node stack = null;
    public void push(E data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = stack;
        stack = newNode;
    }

    public E pop() {
        if (isEmpty()) {
            return;
        }
        E data = stack.data;
        stack = stack.next;
        return data;
    }

    public boolean isEmpty() {
        return stack == null;
    }
}
