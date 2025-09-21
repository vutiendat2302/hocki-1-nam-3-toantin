package week4.homework;

public class DeleteMiddleOfLinkedList {
    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node temp1 = head;
        Node temp2 = head;
        int length = 0;

        while (temp1 != null) {
            length++;
            temp1 = temp1.next;
        }

        int mid = length / 2;

        for (int i = 1; i < mid; i++) {
            temp2 = temp2.next;
        }

        temp2.next = temp2.next.next;

        return head;
    }
}
