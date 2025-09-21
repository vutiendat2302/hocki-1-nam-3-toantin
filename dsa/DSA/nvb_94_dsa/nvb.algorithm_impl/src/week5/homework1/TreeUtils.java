package week5.homework1;

public class TreeUtils {
    public static int getHeight(TreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return  Math.max(leftHeight, rightHeight) + 1;
    }

    public static int getSize(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null ) {
            return 1;
        }

        int leftSize = getSize(root.left);
        int rightSize = getSize(root.right);

        return leftSize + rightSize + 1;
    }

    public static int getLeaves(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftLeaves = getLeaves(root.left);
        int rightLeaves = getLeaves(root.right);

        return leftLeaves + rightLeaves;
    }

    public static void read(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        read(root.left);
        read(root.right);
        System.out.println();
    }

    public static boolean isFull(TreeNode<Integer> root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        return isFull(root.left) && isFull(root.right);
    }

    public static boolean isAllLeavesHaveSameLevel(TreeNode<Integer> root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }
        int leftLevel = getHeight(root.left);
        int rightLevel = getHeight(root.right);

        if (leftLevel == rightLevel) {
            return isAllLeavesHaveSameLevel(root.left) && isAllLeavesHaveSameLevel(root.right);
        }
        return false;
    }

    private static Integer leafLevel = null;

    public static boolean areLeavesAtSameLevel(TreeNode<Integer> root) {
        leafLevel = null;
        return check(root, 0);
    }

    private static boolean check(TreeNode<Integer> node, int level) {
        if (node == null) return true;

        if (node.left == null && node.right == null) { // Nếu là lá
            if (leafLevel == null) leafLevel = level;  // Gán mức đầu tiên
            return leafLevel == level;
        }

        return check(node.left, level + 1) && check(node.right, level + 1);
    }

    public static boolean isPerfect(TreeNode<Integer> root) {
        int depth = findDepth(root);
        return checkPerfect(root, 0, depth);
    }

    private static boolean checkPerfect(TreeNode<Integer> node, int level, int depth) {
        if (node == null) return true;

        if (node.left == null && node.right == null) { // Nếu là lá
            return level + 1 == depth;
        }

        if (node.left == null || node.right == null) return false; // Nếu thiếu con

        return checkPerfect(node.left, level + 1, depth) &&
                checkPerfect(node.right, level + 1, depth);
    }

    private static int findDepth(TreeNode<Integer> node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
    }
}
