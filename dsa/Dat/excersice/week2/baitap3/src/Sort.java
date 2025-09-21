public interface Sort<T extends Comparable<T>> {
    void sort(T[] arr);
    int getComparisons(); // In ra soso lanaf so sansh
    int getSwaps(); // In ra so lan doi cho
}
