package week11;

public class SortedLinkedListToBST {
    TNode sortedArrayToBST(LNode head, LNode start , LNode end){
        if (start == end) return null;


        LNode slow = start;
        LNode fast = start;
        while(fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next.next;
        }
        TNode root = new TNode(slow.data);

        root.left = sortedArrayToBST(head,start,slow);
        root.right = sortedArrayToBST(head,slow.next,end);
        return root;
    }

    public TNode sortedListToBST(LNode head) {
        // code here
        LNode start = head;
        LNode end = head;
        while(end != null){
            end = end.next;
        }
        TNode root = sortedArrayToBST(head, start , end);
        return root;
    }
}
