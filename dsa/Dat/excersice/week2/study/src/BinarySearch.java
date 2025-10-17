import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    //  Chomảngacónphầntửđượcsắptheothứtựtăngdầnvàmộtgiátrị x
    // bấtkỳ.Kiểmtraxemphầntửxcótrongmảnghaykhông?
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = {1, 2, 3, 5, 8, 20, 27, 100};

    }

    public static boolean binarySearch(int n, int[] arr, int left, int right) {
        if (left > right) return false;
        if (left == right) {
            return (n == arr[left]) ? true: false;
        } else {
            int mid = (left + right) / 2;
            if (n == arr[mid]) {
                return true;
            } else if (n < arr[mid]) {
                return binarySearch(n, arr, left, mid - 1);
            } else {
                return binarySearch(n, arr, mid + 1, right);
            }
        }
    }
}
