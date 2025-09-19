package week7;

public class AVLNode {
    int value, height;
    AVLNode left, right;
    public AVLNode(int value) {
        this.value = value;
        this.height = 1;
    }
}
