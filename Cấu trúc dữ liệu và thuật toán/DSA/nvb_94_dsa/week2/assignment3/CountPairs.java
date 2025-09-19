package nvb.assignment3;

public class CountPairs {

    public static void main(String[] args) {
        int sum = 10000;
        int [] array = Sort.generateNumber(100000);
        Sort.mergeSort(array, 0, array.length - 1);
        Sort.printArray(array);
        System.out.println();
        System.out.println("Pairs : " + countPairs(array, sum));
    }

    public static int binarySearch(int [] array, int key) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < key) {
                left = mid + 1;
            } else if (array[mid] > key) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int countPairs(int [] array, int sum) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int key = sum - array[i];
            if (binarySearch(array, key) != -1) {
                count++;
            }
        }

        return count / 2;
    }
}
