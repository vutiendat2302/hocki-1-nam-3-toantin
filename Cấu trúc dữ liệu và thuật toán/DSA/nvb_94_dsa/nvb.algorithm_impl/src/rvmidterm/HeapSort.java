package rvmidterm;

public class HeapSort {

//    public static void heapSort(int [] array) {
//        int n = array.length;
//
//        //xay dung max heap
//        for (int i = n / 2 - 1; i >= 0; i--) {
//            heapify(array, n, i);
//        }
//
//        //sort
//        for (int i = n - 1; i > 0; i--) {
//            swap(array, 0, i);
//
//            heapify(array, i, 0);
//        }
//    }
//
//    public static void heapify(int [] array, int size, int rootIndex) {
//        int largestIndex = rootIndex;
//        int left = 2 * rootIndex + 1;
//        int right = 2 * rootIndex + 2;
//
//        if (left < size && array[left] > array[largestIndex]) {
//            largestIndex = left;
//        }
//
//        if (right < size && array[right] > array[largestIndex]) {
//            largestIndex = right;
//        }
//
//        if (largestIndex != rootIndex) {
//            swap(array, rootIndex, largestIndex);
//
//            heapify(array, size, largestIndex);
//        }
//    }

    public static void heapSort(int [] array) {
        int size = array.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, size, i);
        }

        for (int i = size - 1; i > 0; i--) {
            swap(array, 0, i);

            heapify(array, i, 0);
        }
    }

    public static void heapify(int [] array,int size, int rootIndex) {
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;
        int largestIndex = rootIndex;

        if (left < size && array[left] > array[largestIndex]) {
            largestIndex = left;
        }
        if (right < size && array[right] > array[largestIndex]) {
            largestIndex = right;
        }

        if (largestIndex != rootIndex) {
            swap(array, largestIndex, rootIndex);

            heapify(array, size, largestIndex);
        }
    }

    private static void swap(int [] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
