package week4.homework;

public class MultiplyTwoLinkedList {
    public long multiplyTwoList(Node<Integer> headA, Node<Integer> headB) {
        long MOD = 1000000007;

        long n1 = 0;
        long n2 = 0;

        while (headA != null) {
            n1 =  (n1 * 10) + headA.data;
            headA = headA.next;
        }

        while (headB != null) {
            n2 = (n2 * 10) + headB.data;
            headB = headB.next;
        }

        return (n1 * n2) % MOD;
    }
}
