package rvmidterm;

public class HasPath {
    public boolean hasPathSum(TreeNode<Integer> root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.data == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.data)
                || hasPathSum(root.right, targetSum - root.data);
    }
}
