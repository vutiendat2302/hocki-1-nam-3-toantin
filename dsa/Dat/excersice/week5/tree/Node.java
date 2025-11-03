package tree;

public class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
    }

    // Tìm chiều cao của cây
    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        int hleft = height(node.left);
        int rleft = height(node.right);
        return Math.max(hleft, rleft) + 1;
    }

    // Đếm số nút là trên cây
    public int countLeavees(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }

        return countLeavees(node.left) + countLeavees(node.right);
    }

    // Kiem tra cac nut la co cung muc ko
    int level = 0;
    boolean check(Node root) {
        return checkLevel(root, 0);
    }

    boolean checkLevel(Node root, int clevel) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            if (level == 0) {
                level = clevel;
                return true;
            }
            return level == clevel;
        }

        return checkLevel(root.left, clevel + 1) && checkLevel(root.right, clevel + 1);
    }
}
