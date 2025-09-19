package week11;

public class ArrayToBST {
    public Node sortedArrayToBST(int[] nums) {
        // Code here
        int n = nums.length;
        Node root = solveBST(0, n-1, nums);
        return root;
    }

    Node solveBST(int low, int high, int[] arr) {
        if(low > high) return null;

        int mid = low + (high - low)/2;
        Node root = new Node(arr[mid]);

        root.left = solveBST(low, mid-1, arr);
        root.right = solveBST(mid+1, high, arr);

        return root;
    }
}
