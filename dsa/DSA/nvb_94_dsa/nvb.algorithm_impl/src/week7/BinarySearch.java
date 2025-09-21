package week7;

public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {1, 3, 4, 9, 11, 13, 14, 19};
        System.out.println("Index of value 4 is " + binarySearch(arr, 4));
    }
    public static int binarySearch(int [] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            }
            if (arr[mid] > target) {
                right =  mid - 1;
            }
        }
        return -1;
    }

//    public static int resBinarySearch(int [] arr, int target) {
//
//    }

}
