package week3;

import java.util.Scanner;

public class MergeSort2 {

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

    public static int [] merge(int [] array, int left, int mid, int right) {
        int lSize = mid - left + 1;
        int rSize = right - mid;

        int [] leftArray = new int[lSize];
        int [] rightArray = new int[rSize];

        for (int i = left; i <= mid; i++) {
            leftArray[i - left] = array[i];
        }
        for (int j = mid + 1; j <= right; j++) {
            rightArray[j - mid - 1] = array[j];
        }
        int i = 0, j = 0, index= left;
        while (i < lSize && j < rSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[index++] = leftArray[i++];
            } else {
                array[index++] = rightArray[j++];
            }
        }

        while (i < lSize) {
            array[index++] = leftArray[i++];
        }

        while (j < rSize) {
            array[index++] = rightArray[j++];
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

    static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}
