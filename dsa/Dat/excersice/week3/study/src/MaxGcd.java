import java.util.Calendar;
import java.util.Scanner;

public class MaxGcd {
    // Tìm ước chung lớn nhất
    public static void main(String[] args) {
        System.out.println("Nhập a: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Nhập b:");
        int b = sc.nextInt();
        System.out.println("gcd1: " + gcd1(a, b));
        System.out.println("gcd2: " + gcd2(a, b));

    }

    public static int gcd1(int a, int b) {
        if (b == 0) return a;
        else return gcd1(a, a % b);
    }

    public static int gcd2(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
