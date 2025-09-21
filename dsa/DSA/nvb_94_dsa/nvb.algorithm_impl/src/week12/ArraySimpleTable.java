package week12;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySimpleTable<Key extends Comparable<Key>, Value> extends AbstractSimpleTable<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int size;
    private static final int DEFAULT_CAPACITY = 19;

    @SuppressWarnings("unchecked")
    public ArraySimpleTable() {
        keys = (Key[]) new Comparable[DEFAULT_CAPACITY];
        values = (Value[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        if (value == null) {
            delete(key);
            return;
        }
        extend();
        for (int i = 0; i < size; i++) {
            if (keys[i].compareTo(key) == 0) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        for (int i = 0; i < size; i++) {
            if (key.compareTo(keys[i]) == 0) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> keyList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            keyList.add(keys[i]);
        }
        return keyList;
    }

    private void extend() {
        if (size == keys.length) {
            keys = Arrays.copyOf(keys, size * 2);
            values = Arrays.copyOf(values, size * 2);
        }
    }
}
