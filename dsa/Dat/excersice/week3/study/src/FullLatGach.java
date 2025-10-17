import java.util.Scanner;

public class FullLatGach {
    /*Bài toán lát gạch
    *  Chomộtnềnnhàhìnhvuông,kíchthước2n×2n.Người tadànhriêng
 mộtôđểthoátnước.HãytìmcáchxếpnhữngviêngạchhìnhchữLtrên
 nềnnhà, saochonềnnhàđượclátkíngạch(trừôvuôngđượcdùngđể
 thoátnước)
    * */
    private static int tile = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập k (kích thước là 2^k): ");
        int k = sc.nextInt();
        int size = (int) Math.pow(2, k);

        int[][] board = new int[size][size];

        System.out.println("Nhập vị trí ô thoát nước (row col): ");
        int holeRow = sc.nextInt();
        int holeCol = sc.nextInt();
        board[holeRow][holeCol] = -1;

        tile(board, size, holeRow, holeCol, 0, 0);

        printMatrix(board);
    }

    // Hàm lát nền theo Algorithm 3
    public static void tile(int[][] board, int n, int holeRow, int holeCol, int topRow, int topCol) {
        if (n == 2) { // Base case: lát 2x2
            int t = tile++;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (topRow + i != holeRow || topCol + j != holeCol) {
                        board[topRow + i][topCol + j] = t;
                    }
                }
            }
            return;
        }

        int mid = n / 2;

        // Xác định phần tư chứa ô thoát nước
        int quadrant;
        if (holeRow < topRow + mid && holeCol < topCol + mid) {
            quadrant = 0; // trên trái
        } else if (holeRow < topRow + mid && holeCol >= topCol + mid) {
            quadrant = 1; // trên phải
        } else if (holeRow >= topRow + mid && holeCol < topCol + mid) {
            quadrant = 2; // dưới trái
        } else {
            quadrant = 3; // dưới phải
        }

        // Đặt viên gạch L ở trung tâm
        int t = tile++;
        // Tạo 3 ô "thoát nước" giả
        if (quadrant != 0) board[topRow + mid - 1][topCol + mid - 1] = t;
        if (quadrant != 1) board[topRow + mid - 1][topCol + mid] = t;
        if (quadrant != 2) board[topRow + mid][topCol + mid - 1] = t;
        if (quadrant != 3) board[topRow + mid][topCol + mid] = t;

        // Gọi đệ quy cho 4 phần
        // Trên trái
        tile(board, mid,
                (quadrant == 0 ? holeRow : topRow + mid - 1),
                (quadrant == 0 ? holeCol : topCol + mid - 1),
                topRow, topCol);

        // Trên phải
        tile(board, mid,
                (quadrant == 1 ? holeRow : topRow + mid - 1),
                (quadrant == 1 ? holeCol : topCol + mid),
                topRow, topCol + mid);

        // Dưới trái
        tile(board, mid,
                (quadrant == 2 ? holeRow : topRow + mid),
                (quadrant == 2 ? holeCol : topCol + mid - 1),
                topRow + mid, topCol);

        // Dưới phải
        tile(board, mid,
                (quadrant == 3 ? holeRow : topRow + mid),
                (quadrant == 3 ? holeCol : topCol + mid),
                topRow + mid, topCol + mid);
    }

    // In ma trận
    private static void printMatrix(int[][] M) {
        for (int[] row : M) {
            for (int val : row) {
                System.out.printf("%3d", val);
            }
            System.out.println();
        }
    }

}
