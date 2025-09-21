package week4.homework;

public class IsPalindromeLinkedList extends ReverseLinkedList{
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);

        Node.printList(head);
        System.out.println();
        Node.printList(copyNode(head));
        System.out.println();

        System.out.println(isPalindrome(head));
    }

    static boolean isPalindrome(Node head) {
        Node clone = copyNode(head);

        clone = reverse(clone);

        while (clone != null) {
            if (clone.data != head.data) {
                return false;
            }
            clone = clone.next;
            head = head.next;
        }

        return true;
    }

    static Node copyNode(Node head) {
        if (head == null) {
            return null;
        }

        Node copyHead = new Node(head.data);

        Node current = head.next;
        Node copyCurrent = copyHead;

        while (current != null) {
            copyCurrent.next = new Node(current.data);

            copyCurrent = copyCurrent.next;
            current = current.next;
        }

        return copyHead;
    }

}
