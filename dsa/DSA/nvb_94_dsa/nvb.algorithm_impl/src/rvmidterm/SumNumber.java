package rvmidterm;

public class SumNumber {
    public static int dfs(TreeNode<Integer> root, int currentSum) {
        if (root == null) {
            return 0;
        }

        currentSum = currentSum * 10 + root.data;

        if (root.left == null && root.right == null) {
            return currentSum;
        }

        return dfs(root.left, currentSum) + dfs(root.right, currentSum);
    }
}
