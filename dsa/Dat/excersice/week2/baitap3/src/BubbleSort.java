public class BubbleSort<T extends Comparable<T>> implements Sort<T> {
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
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
//            System.out.println("BubbleSort " + (i + 1));
//            printArray(arr);
        }
        long end = System.nanoTime();
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        System.out.println("Time: " + (end - start)/1e6 + " ms");
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
