public class BubbleSort implements Sort{
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
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
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
