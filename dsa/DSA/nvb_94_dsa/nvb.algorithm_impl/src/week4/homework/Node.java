package week4.homework;

public class Node<T> {
    T data;
    Node<T> next;
    public Node(T data) {
        this.data = data;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
}
