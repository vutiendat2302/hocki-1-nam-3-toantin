import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Binary: ");
        System.out.println(toBinary(n));
        System.out.println(binary(n));
    }

    public static String toBinary(int n) {
        if (n <= 1) {
            return String.valueOf(n);
        }
        return toBinary(n / 2) + String.valueOf(n % 2);
    }

    public static String binary(int n) {
        String str = "";
        if (n == 0) {
            return "0";
        }
        while (n > 0) {
            str = (n % 2) + str;
            n = n / 2;
        }
        return str;
    }
}
