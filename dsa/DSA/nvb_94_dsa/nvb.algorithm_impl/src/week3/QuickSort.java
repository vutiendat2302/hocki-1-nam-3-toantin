package week3;

import java.util.Scanner;

public class QuickSort {
    private static final Scanner getData = new Scanner(System.in);
    public static void main(String[] args) {
        testQuickSort();
    }

    private static void testQuickSort() {
        System.out.println("Enter the size of the array : ");
        int size = getData.nextInt();
        int [] array = new int[size];
        System.out.println("Enter the elements of the array (separate by ' ') : ");

        for (int i = 0; i < size; i++) {
            array[i] = getData.nextInt();
        }

        System.out.println("QUICK SORT.....");
        quickSort(array, 0, array.length - 1);
        printArray(array);

        getData.close();

    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private static int partition(int [] array, int left, int right) {
        int pivot = array[right];
        int index = left - 1;

        for (int i = left; i < right; i++) {
            if (array[i] < pivot) {
                index++;
                swap(array, index, i);
            }
        }

        swap(array, index + 1, right);

        return index + 1;
    }

    private static void swap(int [] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
