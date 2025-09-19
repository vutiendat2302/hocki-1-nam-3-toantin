package week4.homework;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(40);
        // 5 -> 10 -> 15 -> 40

        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);
        // 2 -> 3 -> 20

        Node merge = sortedMerge(head1, head2);

        printNode(merge);

    }

    static Node<Integer> sortedMerge(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        Node root = new Node(0);
        Node current = root;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        }

        if (head2 != null) {
            current.next = head2;
        }

        return root.next;
    }

    static void printNode(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
