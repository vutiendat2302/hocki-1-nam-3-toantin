public class MergeSort implements Sort{
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
        mergeSort(arr, left, right);
        long end = System.nanoTime();
        System.out.println("start: " + start);
        System.out.println("end: " + end);
        System.out.println("Time: " + (end - start)/1e6 + " ms");
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        mergeParts(arr, l, mid, r);
//        System.out.println("MergeSort (" + l + "," + r + "):");
//        printArray(arr);
    }

    public void mergeParts(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            comparisons++;
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < n1) {
            comparisons++;
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
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
