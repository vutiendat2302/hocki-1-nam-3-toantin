package stack;

import java.rmi.server.ExportException;

public class StackArray {
    protected int cap;
    public static final int CAP = 16;
    public static final int MIN = 1;
    protected int[] stack;
    protected int top = -1;

    public StackArray() {

    }

    public StackArray(int cap) {
        this.cap = cap;
        stack = new int[cap];
    }

    public int size() {
        return (top + 1);
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public void push(int data) throws Exception {
        if (size() == cap) {
            expand();
        }

        stack[++top] = data;
    }

    private void expand() {
        int length = size();
        int[] newStack = new int[length * 2];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
        this.cap = this.cap * 2;
    }

    // Thu nhỏ mảng
    private void shrink() {
        int length = top + 1;
        if (length <= MIN || top * 4 >= length) {
            return;
        }

        length = length + (top * 2);
        if (top < MIN) {
            length = MIN;
        }
        int[] newStack = new int[length];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
        this.cap = length;
    }

    public int top() {
        if (isEmpty()) {
            throw new NullPointerException("Stack is empty");
        }
        return stack[top];
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Emptu");
        }

        int data;
        data = stack[top];
        stack[top--] = Integer.MIN_VALUE;
        shrink();
        return data;
    }


}
