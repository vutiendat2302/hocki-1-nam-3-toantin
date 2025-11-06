package buoi2;

public class SumTree {
    // Đề bài cho một cây và tính tổng của các đường đi, một đường đi từ gốc đến
    // lá biểu diễn một số
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    class SumTest {
        public int sumNumbers(TreeNode root) {

        }

        private int dfs(TreeNode node, int currentSum) {
            if (node == null) {
                return 0;
            }

            currentSum = currentSum * 10 + node.val;


        }
    }
}
