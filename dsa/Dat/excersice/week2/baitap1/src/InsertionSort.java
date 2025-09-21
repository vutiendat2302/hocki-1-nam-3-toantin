public class InsertionSort implements Sort {
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
    public void sort(int[] arr) {
        long start = System.nanoTime();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
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

    public void shiftElement(int[] arr, int j) {
        int value = arr[j];
        while (j > 0 && arr[j - 1] > value) {
            comparisons++;
            swaps++;
            arr[j] = arr[j - 1];
            j--;
        }
        arr[j] = value;
    }

    public void swap(int[] arr, int index1, int index2) {
        int wap = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = wap;
        swaps++;
    }

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] +  " ");
        }
        System.out.println(" ");;
    }
}
