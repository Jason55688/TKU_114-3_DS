public class BuildLinkedList {

    // Node 類別
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        // 建立節點
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);

        // 使用 next 連接
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // head 指向第一個節點
        Node head = node1;

        // 空串列檢查
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        // 走訪並輸出
        Node current = head;
        int count = 0;
        int sum = 0;

        System.out.println("Linked List:");

        while (current != null) {
            System.out.print(current.data + " ");
            count++;
            sum += current.data;
            current = current.next;
        }

        System.out.println();
        System.out.println("Node Count: " + count);
        System.out.println("Sum: " + sum);
    }
}