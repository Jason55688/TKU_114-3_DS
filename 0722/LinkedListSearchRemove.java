public class LinkedListSearchRemove {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node head;

    public static void main(String[] args) {

        // 建立串列: 10 -> 20 -> 30 -> 40
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("Original List:");
        printList();

        System.out.println("\nContains 20: " + contains(20));
        System.out.println("Contains 99: " + contains(99));

        // 刪除 Head
        System.out.println("\nRemove 10 (Head)");
        removeValue(10);
        printList();

        // 刪除中間
        System.out.println("\nRemove 30 (Middle)");
        removeValue(30);
        printList();

        // 刪除最後
        System.out.println("\nRemove 40 (Last)");
        removeValue(40);
        printList();

        // 找不到
        System.out.println("\nRemove 99 (Not Found)");
        removeValue(99);
        printList();
    }

    // 搜尋
    public static boolean contains(int value) {

        Node current = head;

        while (current != null) {

            if (current.data == value) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // 刪除節點
    public static boolean removeValue(int value) {

        if (head == null) {
            System.out.println("List is empty.");
            return false;
        }

        // 刪除 head
        if (head.data == value) {
            head = head.next;
            System.out.println("Remove success.");
            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.data == value) {
                current.next = current.next.next;
                System.out.println("Remove success.");
                return true;
            }

            current = current.next;
        }

        System.out.println("Value not found.");
        return false;
    }

    // 印出鏈結串列
    public static void printList() {

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
}