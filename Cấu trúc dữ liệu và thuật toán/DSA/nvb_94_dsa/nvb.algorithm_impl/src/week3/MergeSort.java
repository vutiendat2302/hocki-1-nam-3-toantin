package week3;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner getData = new Scanner(System.in);
        System.out.println("Enter numbers of elements : ");
        int n = getData.nextInt();
        int [] data = new int[n];
        System.out.println("Enter elements (Separate by space) : ");
        for (int i = 0; i < n; i++) {
            data[i] = getData.nextInt();
        }
        System.out.println();
        printArray(data);
        System.out.println("After sort: ");
        mergeSort(data, 0, data.length - 1);
        printArray(data);

        getData.close();
    }

    public static void merge(int [] array, int left, int mid, int right) {
        int [] l = new int[mid - left + 1];
        int [] r = new int[right - mid];

        for (int m = left; m <= mid; m++) {
            l[m - left] = array[m];
        }

        for (int n = mid + 1; n <= right; n++) {
            r[n - mid - 1] = array[n];
        }

        int i = 0, j = 0, index = left;

        while (i < l.length && j < r.length) {
            if(l[i] <= r[j]) {
                array[index++] = l[i++];
            } else {
                array[index++] = r[j++];
            }
        }

        while (i < l.length) {
            array[index++] = l[i++];
        }

        while (j < r.length) {
            array[index++] = r[j++];
        }

    }

    public static void mergeSort(int [] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
