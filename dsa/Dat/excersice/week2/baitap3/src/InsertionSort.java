public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
    private int swaps;
    private int comparisons;

    @Override
    public int getSwaps() {
        return swaps;
    }

    @Override
    public int getComparisons() {
        return comparisons;
    }

    @Override
    public void sort(T[] arr) {
        long start = System.nanoTime();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i].compareTo(arr[i - 1]) < 0) {
                comparisons++;
                shiftElement(arr, i);
            }
//            System.out.println("InsertionSort " + (i + 1));
//            printArray(arr);
        }
        long end = System.nanoTime();
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        System.out.println("Time: " + (end - start)/1e6 + " ms");
    }

    public void shiftElement(T[] arr, int j) {
        T value = arr[j];
        while (j > 0 && arr[j - 1].compareTo(value) > 0) {
            comparisons++;
            swaps++;
            arr[j] = arr[j - 1];
            j--;
        }
        arr[j] = value;
    }

    public void swap(T[] arr, int index1, int index2) {
        T wap = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = wap;
        swaps++;
    }

    public void printArray(T[] arr) {
        int n = arr.length;
        for (T item : arr) {
            System.out.print(item +  " ");
        }
        System.out.println(" ");;
    }
}
