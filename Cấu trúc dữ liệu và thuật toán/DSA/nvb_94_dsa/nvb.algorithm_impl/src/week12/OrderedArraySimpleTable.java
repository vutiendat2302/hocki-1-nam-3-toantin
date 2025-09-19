package week12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderedArraySimpleTable<Key extends Comparable<Key>, Value> implements OrderedSimpleTable<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int size;
    private static final int DEFAULT_CAPACITY = 19;

    @SuppressWarnings("unchecked")
    public OrderedArraySimpleTable() {
        keys = (Key[]) new Comparable[DEFAULT_CAPACITY];
        values = (Value[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public Key minKey() {
        if (size == 0) {
            return null;
        }
        return keys[0];
    }

    @Override
    public Key maxKey() {
        if (size == 0) {
            return null;
        }
        return keys[size - 1];
    }

    @Override
    public Key floorKey(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        }
        return keys[i - 1];
    }

    @Override
    public Key ceilingKey(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        int i = rank(key);
        if (i == size) {
            return null;
        }
        return keys[i];
    }

    @Override
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    @Override
    public Key select(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return keys[index];
    }

    @Override
    public void deleteMin() {
        if (isEmpty()) return;
        delete(keys[0]);
    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(Key u, Key v) {
        if (u == null || v == null) throw new IllegalArgumentException("Keys cannot be null");
        if (u.compareTo(v) > 0) return 0;
        int low = rank(u);
        int high = rank(v);
        if (high < size && keys[high].compareTo(v) == 0) {
            high++;
        }
        return Math.max(0, high - low);
    }

    @Override
    public Iterable<Key> keys(Key u, Key v) {
        if (u == null || v == null) throw new IllegalArgumentException("Keys cannot be null");
        List<Key> keyList = new ArrayList<>();
        if (u.compareTo(v) > 0) return keyList;

        int low = rank(u);
        int high = rank(v);
        for (int i = low; i < high; i++) {
            keyList.add(keys[i]);
        }
        if (high < size && keys[high].compareTo(v) == 0) {
            keyList.add(keys[high]);
        }
        return keyList;
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null || value == null) throw new IllegalArgumentException("Key or Value cannot be null");

        int i = findIndex(key);

        if (i >= 0) {
            values[i] = value;
            return;
        }

        int insertionPoint = -i - 1;

        extend();

        for (int j = size; j > insertionPoint; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[insertionPoint] = key;
        values[insertionPoint] = value;
        size++;
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");
        int i = findIndex(key);
        if (i >= 0) return values[i];
        return null;
    }

    @Override
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("Key cannot be null");

        int i = findIndex(key);
        if (i < 0) return;  // không tìm thấy

        for (int j = i; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }

        keys[size - 1] = null;
        values[size - 1] = null;
        size--;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
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
        return Arrays.asList(Arrays.copyOf(keys, size));
    }

    private void extend() {
        if (size == keys.length) {
            keys = Arrays.copyOf(keys, size * 2);
            values = Arrays.copyOf(values, size * 2);
        }
    }

    private int findIndex(Key key) {
        BinarySearch search = new BinarySearch();
        return search.binarySearch(keys, key);
    }
}
