package binary_search;

import tree.Node;

public class FindNode {
    class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;
        int height = 0;
        public BSTNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // search - tìm kiếm nút có giá trị k trên cây
    // Tìm kiếm lặp
    public BSTNode searchI(BSTNode root, int key) {
        BSTNode current = root;
        while (current != null && current.data != key) {
            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }

    // Tìm kiếm đệ quy
    public BSTNode search(BSTNode root, int key) {
        if (root == null || root.data = key) {
            return root;
        }
        if (key < root.data) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    // find max - trả về nút có giá trị lớn nhất
    public int findMax(BSTNode root) {
        if (root == null) {
            throw new IllegalStateException("Tree is null");
        }
        if (root.right == null) {
            return root.data;
        }
        return findMax(root.right);
    }

    // find min - trả về nút có giá trị khóa nhỏ nhất
    public BSTNode findMin(BSTNode root) {
        if (root == null) {
            throw new IllegalStateException("a");
        }
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    //  chèn phần tử
    BSTNode root;
    void insert(int data) {
        root = insertNode(root, data);
    }

    BSTNode insertNode(BSTNode root, int data) {
        if (root == null) {
            root = new BSTNode(data);
            return root;
        } else if (data < root.data) {
            root.left = insertNode(root.left, data);
        } else if (data > root.data) {
            root.right = insertNode(root.right, data);
        }
        return root;
    }

    // Khi xoas phan tu can chu y 4 th:
    // xoa nut la
    // xoa nut con trai
    // xoa nut con phai
    // nut can xoa co 2 con

    public BSTNode deleteNode(BSTNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right,key);
        } else {;
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            BSTNode node = findMin(root.right);
            root.data = node.data;
            root.right = deleteNode(root.right, node.data);
        }
        return root;
    }

    // Duy trì sự cân bằng của cây
    // Mất cân bằng là độ dài nút con trái - độ dài nút con phải  > 1
    // mất cân bằng trái: tại nút f là gốc, sẽ đẩy nút f_l làm nên làm gốc thay f,
    // nút f_l_r sẽ là nút con trái của f_r
    // Hiểu là xoay phải tại f

    // Mất cân bằng lr: f -> f_l -> f_l-r
    // xoay kép - xoay trái trước ở nút f_l đẩy f_l_r lên thay f_l
    // sau đó quay về TH ll, xoay phải tại f

    // Mất cân bằng rl: f -> f_r -> f_r_l
    // Xoay phải tạoi nút f_r
    // sau đó xoay trái tại nút f

    public BSTNode insertToAVL(BSTNode root, int data) {
        if (root == null) {
            return new BSTNode(data);
        }
        if (data < root.data) {
            root.left = insertToAVL(root.left, data);
        } else if (data > root.data) {
            root.right = insertToAVL(root.right, data);
        } else {
            return root;
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));
        int balance = calculateBalanceFactor(root);

        if (balance > 1) {
            if (data > root.left.data) {
                root.left = rotateLeft(root.left);
            }
            return rotateRihgt(root);
        }
        if (balance < -1) {
            if (data < root.right.data) {
                root.right = rotateRight(root.right);
            }
            return rotateLeft(root);
        }

        return root;
    }
}
