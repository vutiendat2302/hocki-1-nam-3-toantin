public class LinkedList<E> {
    class Node {
        E data;
        Node next;
        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    public int getLength() {
        int length = 0;
        Node currentNode = head;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

    public void insertAtStart(E data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(E data) {
        Node newNode = new Node(data);
        Node currentNode = head;

        if (head == null) {
            head = newNode;
        } else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }
    }

    public void insert(E data, int p) {
        Node newNode = new Node(data);
        if (p == 0) {
            insertAtStart(data);
        } else {
            if (p == getLength()) {
                insertAtEnd(data);
            } else {
                Node current = head;
                int count = 0;
                while (current != null && count < p - 1) {
                    current = current.next;
                    count++;
                    newNode.next = current.next;
                    current.next = newNode;
                }
            }
        }
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }

        head = head.next;
    }

    public void deleteEnd() {
        Node current = head;
        if (head.next == null) {
            head = null;
            return;
        }

        Node p = null;
        while (current.next != null) {
            p = current;
            current = current.next;
        }
        p.next = null;
    }

    public void deleteAt(int p) {
        if (head == null || p == 0) {
            deleteFirst();
            return;
        }
        Node pre  = null;
        Node current = head;
        int count = 0;
        while (current != null || count < p) {
            pre = current;
            current = current.next;
            count++;
        }

        if (current == null) {
            return;
        }

        pre.next = current.next;
        current = null;
    }
}
