package week7;

public class BSTSearchUtils {

    public static void main(String[] args) {
        BSTNode<Integer> root = new BSTNode<>(8);
        insert(root, 5);
        insert(root, 3);
        insert(root, 10);
        insert(root, 9);
        insert(root, 4);
        insert(root, 6);
        insert(root, 7);

        System.out.println("Is contain 6 in tree: " + searchWithLoop(root, 6));
        System.out.println("Is contain 6 in tree: " + searchWithRecursion(root, 6).data);
        System.out.println("Is contain 8 in tree: " + searchWithRecursion(root, 6).right.data);
    }

    public static BSTNode<Integer> searchWithRecursion(BSTNode<Integer> root, int target) {
        if (root == null || root.data == target) {
            return root;
        }

        if (root.data > target) {
            return searchWithRecursion(root.left, target);
        }

        return searchWithRecursion(root.right, target);

    }

    public static boolean searchWithLoop(BSTNode<Integer> root, int target) {
        if (root == null) {
            return false;
        }

        BSTNode<Integer> current = root;
        while (current != null) {
            if (current.data == target) {
                return true;
            }

            if (current.data > target) {
                current = current.left;
            }
            if (current.data < target) {
                current = current.right;
            }
        }

        return false;
    }

    public static BSTNode<Integer> max(BSTNode<Integer> root) {
        while (root.right != null) {
            root = root.right;
        }

        return root;
    }

    public static BSTNode<Integer> min(BSTNode<Integer> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static BSTNode<Integer> insertInto(BSTNode<Integer> root, int data) {
        if (root == null) {
            return new BSTNode<>(data);
        }

        if (data < root.data) {
            root.left = insertInto(root.left, data);
        }
        else if (data > root.data) {
            root.right = insertInto(root.right, data);
        }

        return root;
    }

    static void insert(BSTNode<Integer> root, int data) {
        root = insertInto(root, data);
    }

    static void deleteLeaf(BSTNode<Integer> root, int deleteData) {

    }

    static void deleteHaveLeftChild(BSTNode<Integer> root, int deleteData) {

    }

    static void deleteHaveRightChild(BSTNode<Integer> root, int deleteData) {

    }

//    static BSTNode<Integer> deleteHaveAllChild(BSTNode<Integer> root, int deleteData) {
//        if (root == null || searchWithRecursion(root, deleteData) == null) {
//            return null;
//        }
//
//        BSTNode<Integer> current = searchWithRecursion(root, deleteData);
//
//        BSTNode<Integer> mostLeftChild = min(root.right);
//    }
}
