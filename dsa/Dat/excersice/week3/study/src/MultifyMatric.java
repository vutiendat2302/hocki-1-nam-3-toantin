import java.util.Scanner;

public class MultifyMatric {
    /*
    * Nhân 2 ma trận vuông, kích thước n % 2 = 0 nếu ko tm điều kiện phải
    * nhân 2 ma trận theo cách thông thường
    * Dùng thuật toán Straseen với độ phức tạp n  mũ log2(7)*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Nhập kích thước ma trận A
        System.out.print("Nhập số hàng của ma trận A: ");
        int m = sc.nextInt();
        System.out.print("Nhập số cột của ma trận A: ");
        int n = sc.nextInt();

        // Nhập kích thước ma trận B
        System.out.print("Nhập số cột của ma trận B: ");
        int p = sc.nextInt();

        int[][] A = new int[m][n];
        int[][] B = new int[n][p];
        int[][] C = new int[m][p];

        System.out.println("Nhập ma trận A:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // Nhập ma trận B
        System.out.println("Nhập ma trận B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // Nhaan 2 ma tran
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                C[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        int[][] D = strassen(A, B);

        System.out.println("Kết quả ma trận C:");
        for (int[] row : D) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    public static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    public static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }

    public static int[][] strassen(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }

        int k = n / 2;
        int[][] A11 = new int[k][k];
        int[][] A12 = new int[k][k];
        int[][] A21 = new int[k][k];
        int[][] A22 = new int[k][k];
        int[][] B11 = new int[k][k];
        int[][] B12 = new int[k][k];
        int[][] B21 = new int[k][k];
        int[][] B22 = new int[k][k];

        // Tách ma trận thành 4 phần
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                A11[i][j] = A[i][j];
                A12[i][j] = A[i][j + k];
                A21[i][j] = A[i + k][j];
                A22[i][j] = A[i + k][j + k];
                B11[i][j] = B[i][j];
                B12[i][j] = B[i][j + k];
                B21[i][j] = B[i + k][j];
                B22[i][j] = B[i + k][j + k];
            }
        }

        // 7 phép nhân Strassen
        int[][] M1 = strassen(add(A11, A22), add(B11, B22));
        int[][] M2 = strassen(add(A21, A22), B11);
        int[][] M3 = strassen(A11, subtract(B12, B22));
        int[][] M4 = strassen(A22, subtract(B21, B11));
        int[][] M5 = strassen(add(A11, A12), B22);
        int[][] M6 = strassen(subtract(A21, A11), add(B11, B12));
        int[][] M7 = strassen(subtract(A12, A22), add(B21, B22));

        // Kết hợp kết quả
        int[][] C11 = add(subtract(add(M1, M4), M5), M7);
        int[][] C12 = add(M3, M5);
        int[][] C21 = add(M2, M4);
        int[][] C22 = add(subtract(add(M1, M3), M2), M6);

        // Gộp lại ma trận C
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                C[i][j] = C11[i][j];
                C[i][j + k] = C12[i][j];
                C[i + k][j] = C21[i][j];
                C[i + k][j + k] = C22[i][j];
            }
        }

        return C;
    }
}
