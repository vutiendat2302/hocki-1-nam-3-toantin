import java.util.Scanner;

public class MinMax {
    /*
    *Chomảngacó n phầntử.Tìmgiátrị lớnnhất(max),giátrịnhỏnhất
 (min)trongđoạnal...ar củamảng
    * */

    public static void main(String[] args) {
        int[] arr = {1, 80, 27, 5, 89, 20, 27, 100};
        System.out.println("min: " + min(arr, 0, arr.length - 1));
        System.out.println("min: "  + min(arr));

        System.out.println("max:" + max(arr, 0, arr.length - 1));

    }

    public static int min(int[] a, int l, int r) {
        if (l == r) {
            return a[l];
        } else {
            int m = (l + r) / 2;
            int min1 = min(a, l, m);
            int min2 = min(a, m + 1, r);
            return (min1 < min2) ? min1 : min2;
        }
    }

    public static int max(int[] a, int l, int r) {
        if (l == r) {
            return a[l];
        } else {
            int m = (l + r) / 2;
            int max1 = max(a, l, m);
            int max2 = max(a, m + 1, r);
            return (max1 > max2) ? max1 : max2;
        }
    }

    public static int min(int[] a) {
        int n = a.length;
        int min = a[0];
        if (n == 0) {
            return a[0];
        } else {
            for (int i = 0; i < a.length; i++) {
                if (min > a[i]) {
                    min = a[i];
                }
            }
        }
        return min;
    }
}
