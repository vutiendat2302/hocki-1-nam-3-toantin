package nvb.assignment3;

public class FindK {

    public static void main(String[] args) {
        int size = 15;
        int [] numbers = Sort.generateNumber(size);
        Sort.printArray(numbers);
        int key = 14;

        System.out.println();
        System.out.println("Kth lowest number : " + findKthLowestNumber(numbers, key));
    }

    public static int findKthLowestNumber(int[] arr, int k) { // find Kth lowest number
        int count = 0, index = 0;

        //sort array
        Sort.mergeSort(arr, 0, arr.length - 1);

        while (count < k && index < arr.length - 1) {
            if (arr[index] < arr[index + 1]) {
                count++;
                index++;
            }
        }

        return arr[index - 1];
    }
}
