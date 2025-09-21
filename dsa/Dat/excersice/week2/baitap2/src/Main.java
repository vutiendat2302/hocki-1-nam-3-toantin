import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = inputNumber();
        printArray(arr1);
        testSort(arr1);

        int[] size = {100, 1000, 10000, 100000};
        for (int i = 0; i < size.length; i++) {
            Integer[] arr = generatorNumber(size[i]);
            testSort(arr);
        }

        Double[] arrDouble = generatorDouble(10);
        System.out.println("Mảng Double ban đầu:");
        printArray(arrDouble);
        testSort(arrDouble);

        // Test với String[] (tên sinh viên)
        String[] students = {
                "Minh", "An", "Bình", "Chi", "Dũng", "Hà",
                "Khánh", "Linh", "Phương", "Quang"
        };
        System.out.println("\nDanh sách sinh viên ban đầu:");
        printArray(students);
        testSort(students);
    }

    public static void testSort(Integer[] arr) {
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        MergeSort<Integer> mergeSort = new MergeSort<>();
        QuickSort<Integer> quickSort = new QuickSort<>();
        SelectionSort<Integer> selectionSort = new SelectionSort<>();
        InsertionSort<Integer> insertionSort = new InsertionSort<>();

        // copy mảng để mỗi sort chạy độc lập
        Integer[] clone;

        System.out.println("------Test BubbleSort------");
        clone = arr.clone();
        bubbleSort.sort(clone);
        System.out.println("So lan so sanh: " + bubbleSort.getComparisons());
        System.out.println("So lan doi cho: " + bubbleSort.getSwaps());

        System.out.println("------Test Selection sort------");
        clone = arr.clone();
        selectionSort.sort(clone);
        System.out.println("So lan so sanh: " + selectionSort.getComparisons());
        System.out.println("So lan doi cho: " + selectionSort.getSwaps());

        System.out.println("------Test Insertion sort------");
        clone = arr.clone();
        insertionSort.sort(clone);
        System.out.println("So lan so sanh: " + insertionSort.getComparisons());
        System.out.println("So lan doi cho: " + insertionSort.getSwaps());

        System.out.println("------Test mergesort------");
        clone = arr.clone();
        mergeSort.sort(clone);
        System.out.println("So lan so sanh: " + mergeSort.getComparisons());
        System.out.println("So lan doi cho: " + mergeSort.getSwaps());

        System.out.println("------Test quick sort------");
        clone = arr.clone();
        quickSort.sort(clone);
        System.out.println("So lan so sanh: " + quickSort.getComparisons());
        System.out.println("So lan doi cho: " + quickSort.getSwaps());
    }

    public static Integer[] inputNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập kích thước mảng: ");
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        System.out.println("Nhập các phần tử: ");
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }



    // In dãy Integer[] (cho bài 2 generic)
    public static void printArray(Integer[] arr) {
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Sinh ra mot mang
    public static Integer[] generatorNumber(int size) {
        Integer[] numbers = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100000);
        }
        return numbers;
    }

    // Hàm testSort generic (dùng lại cho Double, String...)
    public static <T extends Comparable<T>> void testSort(T[] arr) {
        BubbleSort<T> bubbleSort = new BubbleSort<>();
        MergeSort<T> mergeSort = new MergeSort<>();
        QuickSort<T> quickSort = new QuickSort<>();
        SelectionSort<T> selectionSort = new SelectionSort<>();
        InsertionSort<T> insertionSort = new InsertionSort<>();

        T[] clone;

        System.out.println("------Test BubbleSort------");
        clone = arr.clone();
        bubbleSort.sort(clone);
        System.out.println("So lan so sanh: " + bubbleSort.getComparisons());
        System.out.println("So lan doi cho: " + bubbleSort.getSwaps());
        printArray(clone);

        System.out.println("------Test Selection sort------");
        clone = arr.clone();
        selectionSort.sort(clone);
        System.out.println("So lan so sanh: " + selectionSort.getComparisons());
        System.out.println("So lan doi cho: " + selectionSort.getSwaps());

        System.out.println("------Test Insertion sort------");
        clone = arr.clone();
        insertionSort.sort(clone);
        System.out.println("So lan so sanh: " + insertionSort.getComparisons());
        System.out.println("So lan doi cho: " + insertionSort.getSwaps());

        System.out.println("------Test mergesort------");
        clone = arr.clone();
        mergeSort.sort(clone);
        System.out.println("So lan so sanh: " + mergeSort.getComparisons());
        System.out.println("So lan doi cho: " + mergeSort.getSwaps());

        System.out.println("------Test quick sort------");
        clone = arr.clone();
        quickSort.sort(clone);
        System.out.println("So lan so sanh: " + quickSort.getComparisons());
        System.out.println("So lan doi cho: " + quickSort.getSwaps());
        printArray(clone);
    }

    // Sinh mảng Double[]
    public static Double[] generatorDouble(int size) {
        Double[] numbers = new Double[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextDouble() * 100; // số thực 0-100
        }
        return numbers;
    }

    // In dãy generic
    public static <T> void printArray(T[] arr) {
        for (T item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}
