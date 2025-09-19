package week12;

public interface SimpleTable <Key extends Comparable<Key>, Value> {
    void put(Key key, Value value);
    Value get(Key key);
    void delete(Key key);
    boolean contains(Key key);
    boolean isEmpty();
    int size();
    Iterable<Key> keys();
}
