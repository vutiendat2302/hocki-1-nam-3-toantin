package rvmidterm;

public class SortUtils {
    public static void main(String[] args) {

    }

    public static int partition(int [] array, int left, int right) {
        int pivot = array[right];
        int index = left - 1;
        for (int i = left; i < right; i++) {
            if (array[i] < pivot) {
                swap(array, ++index, i);
            }
        }
        swap(array, ++index, right);

        return index;
    }

    private static void swap(int [] array, int val1, int val2) {
        int temp = array[val1];
        array[val1] = array[val2];
        array[val2] = temp;
    }

    public static void quickSort(int [] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    public static int [] merge(int [] array, int left, int mid, int right) {
        int lSize = mid - left + 1;
        int rSize = right - mid;

        int [] l = new int[lSize];
        int [] r = new int[rSize];

        for (int i = left; i <= mid; i++) {
            l[i - left] = array[i];
        }

        for (int j = mid + 1; j <= right; j++) {
            r[j - mid - 1] = array[j];
        }

        int index = left;
        int i1 = 0, i2 = 0;

        while (i1 < lSize && i2 < rSize) {
            if (l[i1] < r[i2]) {
                array[index++] = l[i1++];
            } else {
                array[index++] = r[i2++];
            }
        }

        while (i1 < lSize) {
            array[index++] = l[i1++];
        }

        while (i2 < rSize) {
            array[index++] = r[i2++];
        }

        return array;
    }

    public static void mergeSort(int [] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

}
