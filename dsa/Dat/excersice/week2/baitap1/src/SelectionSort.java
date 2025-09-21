import java.util.Scanner;

public class SelectionSort implements Sort {
    private int comparisons = 0;
    private int swaps = 0;

    @Override
    public void sort(int[] arr) {
        long start = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
//            System.out.println("SelectionSort " + (i + 1));
//            printArray(arr);
        }
        long end = System.nanoTime();
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        System.out.println("Time: " + (end - start)/1e6 + " ms");
    }

    @Override
    public int getSwaps() {
        return swaps;
    }

    @Override
    public int getComparisons() {
        return comparisons;
    }

    public void swap(int[] arr, int index1, int index2) {
        int wap = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = wap;
        swaps++;
    }

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int a : arr) {
            System.out.print(a +  " ");
        }
        System.out.println(" ");;
    }
}
