package week12;

public interface OrderedSimpleTable<Key extends Comparable<Key>, Value> extends SimpleTable<Key, Value> {
    Key minKey();
    Key maxKey();
    Key floorKey(Key key);
    Key ceilingKey(Key key);
    int rank(Key key);
    Key select(int index);
    void deleteMin();
    void deleteMax();
    int size(Key u, Key v);
    Iterable<Key> keys(Key u, Key v);
}
