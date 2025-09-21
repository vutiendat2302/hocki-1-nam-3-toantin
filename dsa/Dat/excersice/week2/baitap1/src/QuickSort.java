public class QuickSort implements Sort {
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
        int right = arr.length - 1;
        int left = 0;
        int mid = (left + right) / 2;
        quickSort(arr, left, right);
        long end = System.nanoTime();
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        System.out.println("Time: " + (end - start)/1e6 + " ms");
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);

//            System.out.println("QuickSort (" + low + "," + high + "):");
//            printArray(arr);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
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
