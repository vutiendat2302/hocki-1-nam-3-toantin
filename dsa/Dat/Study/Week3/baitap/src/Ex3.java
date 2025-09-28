import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        /*
        * Cho mảng a có n phần tử, tìm giá trị max, min trong mảng*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập kichs thuocj của mảng");
        int x = sc.nextInt();
        int[] arr = new int[x];
        System.out.println("Nhập mảng");
        for (int i = 0; i < x; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Soso be nhat la: " + min(arr, 0, arr.length - 1));
    }

    public static int min(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        } else {
            int mid = (l + r) / 2;
            for (int i = l; i < r; i++ ) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(" ");
            int min1 = min(arr, l, mid);
            int min2 = min(arr, mid + 1, r);
            return (min1 < min2) ? min1 : min2;
        }
    }
}
