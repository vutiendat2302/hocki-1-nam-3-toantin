package baitap1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap do dai cua mang:");
        int[] size = {10, 100, 1000, 10000};



    }

    public void inputNumber(Scanner sc, int n) {

    }

    public void selectionSort(Scanner sc, int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(arr, i, j);
            }
        }
    }

    // thuat toan insertion sort
    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                shiftElement(arr, i);
            }
        }
    }

    public void shiftElement(int[] arr, int i) {
        int value = arr[i];
        while (i > 0) {
            if (arr[i -1] > value) {
                arr[i] = arr[i - 1];
                i--;
            }
        }
        arr[i] = value;
    }

    // thuat toan buble sort
    public void bubleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swaped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                    swaped = true;
                }
            }
            if (!swaped) {
                break;
            }
        }
        printArray(arr);
    }

    // In day
    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // Doi cho 2 phan tu trong mang
    public void swap(int[] arr, int index1, int index2) {
        int value = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = value;
    }

    // Sinh ra mot mang
    public int[] generatorNumber(int size) {
        int[] numbers = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100000);
        }
        return numbers;
    }
}
