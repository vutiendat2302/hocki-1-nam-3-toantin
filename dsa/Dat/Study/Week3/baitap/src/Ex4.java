import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        /*
        * Cho 2 ma tran kich thuoc m * n va n * m
        * nhan 2 ma tran voi nhau
        * Dung thuat toan straseen*/
        Scanner sc = new Scanner(System.in);
        int[][] A = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] B = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        // Nhân thường
        int[][] C1 = multiplyNormal(A, B);
        System.out.println("Kết quả (Normal):");
        printMatrix(C1);

        // Nhân Strassen
        int[][] C2 = multiplyStraseen(A, B);
        System.out.println("Kết quả (Strassen):");
        printMatrix(C2);
    }

    private static void printMatrix(int[][] M) {
        for (int[] row : M) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    public static int[][] multiplyNormal(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j= 0; j  < n; j ++) {
                c[i][j] = 0;
                for (int k = 0; k < n; k++ ) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static int[][] multiplyStraseen(int[][] A, int[][] B) {
        int n = 2;

        int[][] A11 = subMatrix(A, 0, 0, n);
        int[][] A12 = subMatrix(A, 0, n, n);
        int[][] A21 = subMatrix(A, n, 0, n);
        int[][] A22 = subMatrix(A, n, n, n);

        int[][] B11 = subMatrix(B, 0, 0, n);
        int[][] B12 = subMatrix(B, 0, n, n);
        int[][] B21 = subMatrix(B, n, 0, n);
        int[][] B22 = subMatrix(B, n, n, n);

        // Tính 7 ma trận M1..M7
        int[][] M1 = multiply2x2(add(A11, A22), add(B11, B22));
        int[][] M2 = multiply2x2(add(A21, A22), B11);
        int[][] M3 = multiply2x2(A11, sub(B12, B22));
        int[][] M4 = multiply2x2(A22, sub(B21, B11));
        int[][] M5 = multiply2x2(add(A11, A12), B22);
        int[][] M6 = multiply2x2(sub(A21, A11), add(B11, B12));
        int[][] M7 = multiply2x2(sub(A12, A22), add(B21, B22));

        int[][] C11 = add(sub(add(M1, M4), M5), M7);
        int[][] C12 = add(M3, M5);
        int[][] C21 = add(M2, M4);
        int[][] C22 = add(sub(add(M1, M3), M2), M6);

        // Kết hợp thành ma trận 4x4
        int[][] C = new int[4][4];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                C[i][j] = C11[i][j];
                C[i][j + n] = C12[i][j];
                C[i + n][j] = C21[i][j];
                C[i + n][j + n] = C22[i][j];
            }

        return C;
    }

    // Cộng 2 ma trận
    private static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    private static int[][] sub(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }

    private static int[][] multiply2x2(int[][] A, int[][] B) {
        int[][] C = new int[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                C[i][j] = 0;
                for (int k = 0; k < 2; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        return C;
    }

    private static int[][] subMatrix(int[][] A, int row, int col, int size) {
        int[][] M = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                M[i][j] = A[row + i][col + j];
        return M;
    }
}
