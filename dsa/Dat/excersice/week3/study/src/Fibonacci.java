import java.util.Scanner;

public class Fibonacci {
    // Tính tổng của dãy fibonacci
    // In dãy fibonacci đó ra
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhâp số lượng phần tử");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    // Dãy fibonacci bắt đầu từ số 0
    // Mỗi số đứng sau bằng tổng của 2 số liền trước nó
    // Định nghĩ f0 = 0, f1 = 1
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void printFibonacci() {
        int f0 = 0, f1 = 1;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Dayx fibonacci: ");
        for (int i = 0; i < n; i++) {
            System.out.println(f0 + " ");
            int next = f0 + f1;
            f0 = f1;
            f1 = next;
        }
    }
}
