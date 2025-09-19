package rvmidterm;

public interface MaxPriorityQueue<Key extends Comparable<Key>> {
    public void insert(Key key);
    public Key delete();
    public boolean isEmpty();
    public Key max();
    public int size();
}
