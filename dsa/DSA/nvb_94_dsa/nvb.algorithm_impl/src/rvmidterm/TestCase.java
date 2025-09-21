package rvmidterm;

import java.util.List;

import static rvmidterm.InfixToPostfix.infixToPostfix;
import static rvmidterm.LinkedListUtils.isPalindrome;
import static rvmidterm.RightSideView.rightSideView;

public class TestCase {
    private static final LinkedListUtils linkedListUtils = new LinkedListUtils();

    private static final StackUtils stackUtils = new StackUtils();

    public static void testEvaluatedFormula() {
        /**
         * test evaluate formula
         * @return a double
         */
        String testFormular = "( 5 + 3 ) * ( 8 - ( 1 + 2 ) )";
        double evaluatedValue = stackUtils.evaluateFormula(testFormular);
        System.out.println("Evaluated value is " + evaluatedValue);
    }

    public static void testHeapSort() {
        int [] array = {9, 1, 4, 3, 14, 25, 34, 99, 13};
        HeapSort.heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
    }

    public static void testMergeLinkedList() {
        ListNode<Integer> head1 = new ListNode<>(1);
        ListNode<Integer> head2 = new ListNode<>(2);
        head1.next = new ListNode<>(3);
        head1.next.next = new ListNode<>(4);
        head2.next = new ListNode<>(9);
        LinkedListUtils.printList(head1);
        System.out.println();
        LinkedListUtils.printList(head2);
        System.out.println();
        ListNode<Integer> merge = linkedListUtils.mergeTwoSortedLists(head1, head2);
        LinkedListUtils.printList(merge);
    }

    public static void testRightSideView() {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.left.left = new TreeNode<>(5);

        List<Integer> result = rightSideView(root);

        for (int node : result) {
            System.out.printf("%d ", node);
        }
    }

    public static void testPalindromeLinkedList() {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(2);
        head.next.next.next = new ListNode<>(1);
        System.out.println(isPalindrome(head));
    }

    public static void testInfixToPostfix() {
        String infix = "(A+B)-((C+7*T))^2";
        System.out.println(infixToPostfix(infix));
    }

    public static void main(String[] args) {
        //testEvaluatedFormula();
        testHeapSort();
        //testMergeLinkedList();
        //testRightSideView();
        //testPalindromeLinkedList();
        //testInfixToPostfix();
    }
}
