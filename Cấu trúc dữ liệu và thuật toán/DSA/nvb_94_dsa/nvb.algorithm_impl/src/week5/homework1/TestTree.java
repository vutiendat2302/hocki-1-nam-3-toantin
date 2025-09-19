package week5.homework1;

public class TestTree {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);

        System.out.println("Height of tree: " + TreeUtils.getHeight(root));
        System.out.println("Size of tree: " + TreeUtils.getSize(root));
        System.out.println("Leaves of tree: " + TreeUtils.getLeaves(root));
        System.out.println("Read tree: ");
        TreeUtils.read(root);
        System.out.println("Is full tree: " + TreeUtils.isFull(root));
    }

}
