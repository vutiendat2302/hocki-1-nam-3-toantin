import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = inputNumber();
        printArray(arr1);
        testSort(arr1);
        int[] size = {100, 1000, 10000, 100000};
        for (int i = 0; i < size.length; i++) {
            int[] arr = generatorNumber(size[i]);
            testSort(arr);
        }
    }

    public static void testSort(int[] arr) {
        BubbleSort bubbleSort = new BubbleSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertionSort insertionSort = new InsertionSort();

        System.out.println("------Test BubbleSort------");
//        printArray(arr.clone());
        bubbleSort.sort(arr.clone());
        System.out.println("So lan so sanh: " + bubbleSort.getComparisons());
        System.out.println("So lan doi cho: " + bubbleSort.getSwaps());

        System.out.println("------Test Selection sort------");
//        printArray(arr.clone());
        selectionSort.sort(arr.clone());
        System.out.println("So lan so sanh: " + selectionSort.getComparisons());
        System.out.println("So lan doi cho: " + selectionSort.getSwaps());

        System.out.println("------Test Insertion sort------");
//        printArray(arr.clone());
        insertionSort.sort(arr.clone());
        System.out.println("So lan so sanh: " + insertionSort.getComparisons());
        System.out.println("So lan doi cho: " + insertionSort.getSwaps());

        System.out.println("------Test mergesort------");
//        printArray(arr.clone());
        mergeSort.sort(arr.clone());
        System.out.println("So lan so sanh: " + mergeSort.getComparisons());
        System.out.println("So lan doi cho: " + mergeSort.getSwaps());

        System.out.println("------Test quick sort------");
//        printArray(arr.clone());
        quickSort.sort(arr.clone());
        System.out.println("So lan so sanh: " + quickSort.getComparisons());
        System.out.println("So lan doi cho: " + quickSort.getSwaps());
    }

    public static int[] inputNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập kích thước mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử: ");
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }



    // In day
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println(" ");
    }

    // Sinh ra mot mang
    public static int[] generatorNumber(int size) {
        int[] numbers = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100000);
        }
        return numbers;
    }

    /*
    * Nhận xét:
    * N = 100: BubbleSort, InsertionSort, SelectionSort vẫn chạy nhanh vì dữ liệu nhỏ.
    *N = 1000: O(n²) bắt đầu chậm hơn, nhưng vẫn chấp nhận được.
    *N = 10000: O(n²) cực kỳ chậm, chỉ MergeSort/QuickSort chạy mượt.
    * N = 100000: Gần như chỉ MergeSort và QuickSort chạy được trong thời gian hợp lý
    * */
}
