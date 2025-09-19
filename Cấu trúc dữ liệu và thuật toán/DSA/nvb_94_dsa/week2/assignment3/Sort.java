package nvb.assignment3;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        int size [] = {100, 1000, 10000, 100000};
        for (int i = 0; i < 4; i++) {
            int [] numbers = generateNumber(size[i]);

            Instant start1 = Instant.now();
            bubbleSort(numbers.clone());
            Instant end1 = Instant.now();
            Duration duration1 = Duration.between(start1, end1);
            System.out.println("Size = " + size[i] + ", Process time of bubble sort " + duration1.toNanos() + "ns");

            Instant start2 = Instant.now();
            selectionSort(numbers.clone());
            Instant end2 = Instant.now();
            Duration duration2 = Duration.between(start2, end2);
            System.out.println("Size = " + size[i] + ", Process time of selection sort " + duration2.toNanos() + "ns");

            Instant start3 = Instant.now();
            insertionSort(numbers.clone());
            Instant end3 = Instant.now();
            Duration duration3 = Duration.between(start3, end3);
            System.out.println("Size = " + size[i] + ", Process time of insertion sort " + duration3.toNanos() + "ns");

            Instant start4 = Instant.now();
            mergeSort(numbers.clone(), 0, size[i] - 1);
            Instant end4 = Instant.now();
            Duration duration4 = Duration.between(start4, end4);
            System.out.println("Size = " + size[i] + ", Process time of merge sort " + duration4.toNanos() + "ns");
        }

    }

    //method to generate numbers
    public static int [] generateNumber(int size) {
        int [] numbers = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(1000000);
        }

        return numbers;
    }

    //method to swap 2 integers in an array
    private static void swap(int [] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    //method to print an array
    public static void printArray(int [] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
    }

    //bubble sort
    public static void bubbleSort(int [] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    swap(numbers, j, j + 1);
                }
            }
        }
    }

    //selection sort
    public static void selectionSort(int [] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if( numbers[i] > numbers[j]) {
                    swap(numbers, i, j);
                }
            }
        }
    }

    //insertion sort
    public static void insertionSort(int [] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                shift(numbers, i);
            }
        }
    }

    private static void shift(int [] array, int index) {
        int value = array[index];
        while(index > 0 && value < array[index - 1]) {
            array[index] = array[index - 1];
            index--;
        }

        array[index] = value;
    }

    //merge sort
    private static int [] merge(int [] array, int left, int mid, int right) {
        int [] l = new int[mid - left + 1];
        int [] r = new int[right - mid];

        for (int i = left; i <= mid; i++) {
            l[i - left] = array[i];
        }

        for (int j = mid + 1; j <= right; j++) {
            r[j - mid - 1] = array[j];
        }

        int i = 0, j = 0, index = left;

        while (i < l.length && j < r.length) {
            if (l[i] <= r[j]) {
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
