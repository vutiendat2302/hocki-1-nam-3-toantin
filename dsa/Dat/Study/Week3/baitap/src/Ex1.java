import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        /*
        * Cho bài toán có n phẩn từ sắp xếp tăng dần và một giá trị x bất kỳ
        * kiểm tra xem phần tử x có ở trong mảng đó không
        *
        * */

        int[] arr = {1, 4, 8, 20, 75, 100, 140};
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập một số x:  ");
        int x = sc.nextInt();
        System.out.println(Arrays.toString(arr));
        if (binarySearch(arr, 0, arr.length - 1, x) < 0) {
            System.out.println("khong toofn taij");
        } else {
            System.out.println("ton tai gia tri trong mang");
        }
    }

    public static int binarySearch(int[] arr, int l, int r, int x) {
        if (l == r) {
            return (x == arr[l] ? l : -1);
        } else {
            int m = (l + r) / 2;
            if (arr[m] == x) {
                return m;
            } else {
                if (arr[m] < x) {
                    return binarySearch(arr, m + 1, r, x);
                } else {
                    return binarySearch(arr, l, m, x);
                }
            }
        }
    }
}
