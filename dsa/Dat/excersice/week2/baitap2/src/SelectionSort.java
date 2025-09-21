public class SelectionSort<T extends Comparable<T>> implements Sort<T> {
    private int comparisons = 0;
    private int swaps = 0;

    @Override
    public void sort(T[] arr) {
        long start = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) / 1e6 + " ms");
    }

    @Override
    public int getSwaps() {
        return swaps;
    }

    @Override
    public int getComparisons() {
        return comparisons;
    }

    private void swap(T[] arr, int index1, int index2) {
        T tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
        swaps++;
    }

    public void printArray(T[] arr) {
        for (T item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
