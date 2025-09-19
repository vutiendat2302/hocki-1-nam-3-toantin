package week4;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private final int defaultSize = 100;

    SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T data) {
        if (n == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[n] = data;

    }

    @Override
    public T get(int index) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(array[index])) {
                return array[i];
            }
        }

        return null;
    }

    @Override
    public void set(int index, T data) {
        array[index] = data;
    }

    @Override
    public void remove(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                for (int j = i; j < n; j++) {
                    array[j] = array[j + 1];
                }
            }
        }
    }

    @Override
    public boolean isContains(T data) {
        for (T t : array) {
            if (t.equals(data)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
