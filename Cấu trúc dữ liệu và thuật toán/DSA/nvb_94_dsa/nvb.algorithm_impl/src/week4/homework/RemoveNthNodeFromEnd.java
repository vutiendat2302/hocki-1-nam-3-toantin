package week4.homework;

public class RemoveNthNodeFromEnd {
    static Node<Integer> removeNthNodeFromEnd(Node<Integer> head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node iterator1 = dummy;
        Node iterator2 = dummy;

        for (int i = 1; i <= n; i++) {
            iterator1 = iterator1.next;
        }

        while (iterator1 != null && iterator1.next != null) {
            iterator1 = iterator1.next;
            iterator2 = iterator2.next;
        }

        iterator2.next = iterator2.next.next;

        return dummy.next;
    }
}
