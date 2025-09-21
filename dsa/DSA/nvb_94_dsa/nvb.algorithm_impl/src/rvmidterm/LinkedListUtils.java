package rvmidterm;

public class LinkedListUtils {
    public static ListNode<Integer> reverseList(ListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode<Integer> current = head;
        ListNode<Integer> prev = null;
        ListNode<Integer> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static boolean isPalindrome(ListNode<Integer> head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode<Integer> reverse = reverseList(slow);
        ListNode<Integer> current = head;

        while (reverse != null) {
            if (reverse.data != current.data) {
                return false;
            }
            reverse = reverse.next;
            current = current.next;
        }

        return true;
    }

    public ListNode<Integer> removeNthFromEnd(ListNode<Integer> head, int n) {
        if (head == null) {
            return null;
        }
        ListNode<Integer> current = head;
        ListNode<Integer> temp = current.next;

        for (int i = 0; i < n; i++) {
            temp = temp.next;
        }

        while (temp != null) {
            current = current.next;
            temp = temp.next;
        }

        current.next = current.next.next;

        return head;
    }

    public ListNode<Integer> removeDuplicateValues(ListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode<Integer> current = head;
        while (current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> merge = new ListNode<>(-1);
        ListNode<Integer> current = merge;

        while (l1 != null && l2 != null ) {
            if (l1.data < l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }

        return merge.next;
    }

    public static void printList(ListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
