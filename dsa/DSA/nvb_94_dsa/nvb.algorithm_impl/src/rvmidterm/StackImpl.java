package rvmidterm;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class StackImpl<T> implements Stack<T> {
    ListNode<T> stack = null;

    @Override
    public void push(T item) {
        ListNode<T> newHead = new ListNode<>(item);
        newHead.next = stack;
        stack = newHead;
    }

    @Override
    public T pop() {
        if (stack == null) {
            return null;
        }
        T top = stack.data;
        stack = stack.next;
        return top;
    }

    public T peek() {
        return stack.data;
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Stack.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Stack.super.spliterator();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
