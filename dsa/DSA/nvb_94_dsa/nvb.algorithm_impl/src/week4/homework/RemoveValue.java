package week4.homework;

public class RemoveValue {
    Node removeValue(Node root, int value) {
        if (root == null) {
            return null;
        }

        while (root != null && root.data.equals(value)) {
            root = root.next;
        }

        Node current = root;

        while (current != null && current.next != null) {
            if (current.next.data.equals(value)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return root;
    }
}
