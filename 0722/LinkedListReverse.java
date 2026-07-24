public class LinkedListReverse {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // 反轉鏈結串列
    public static Node reverse(Node head) {

        Node previous = null;
        Node current = head;

        while (current != null) {

            Node next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        return previous;
    }

    // 印出串列
    public static void printList(Node head) {

        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        Node current = head;

        while (current != null) {

            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // 測試1：空串列
        Node emptyHead = null;

        System.out.println("Test 1: Empty List");
        printList(emptyHead);

        emptyHead = reverse(emptyHead);

        System.out.println("After Reverse:");
        printList(emptyHead);

        // 測試2：單一節點
        Node singleHead = new Node(10);

        System.out.println("\nTest 2: Single Node");
        printList(singleHead);

        singleHead = reverse(singleHead);

        System.out.println("After Reverse:");
        printList(singleHead);

        // 測試3：多節點
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("\nTest 3: Multiple Nodes");
        printList(head);

        head = reverse(head);

        System.out.println("After Reverse:");
        printList(head);
    }
}