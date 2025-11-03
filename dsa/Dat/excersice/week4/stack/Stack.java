package stack;

import java.util.ArrayList;

public class Stack<E> {

    E data;
    int top = 0;
    E[] stack;
    // Them phan tu
    public void push(E data) {
        stack[top] = data;
        top++;
    }

    public E pop() {
        top--;
        return stack[top];
    }
}
