public class NumberHistoryList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node head;

    // 前端新增
    public static void addFirst(int value) {

        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;
    }

    // 尾端新增
    public static void addLast(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
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

    // 刪除
    public static boolean remove(int value) {

        if (head == null) {
            return false;
        }

        if (head.data == value) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.data == value) {
                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // 節點數量
    public static int count() {

        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    // 總和
    public static int sum() {

        int total = 0;
        Node current = head;

        while (current != null) {
            total += current.data;
            current = current.next;
        }

        return total;
    }

    // 最大值
    public static int max() {

        if (head == null) {
            return 0;
        }

        int max = head.data;
        Node current = head;

        while (current != null) {

            if (current.data > max) {
                max = current.data;
            }

            current = current.next;
        }

        return max;
    }

    // 最小值
    public static int min() {

        if (head == null) {
            return 0;
        }

        int min = head.data;
        Node current = head;

        while (current != null) {

            if (current.data < min) {
                min = current.data;
            }

            current = current.next;
        }

        return min;
    }

    // 印出串列
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

    public static void main(String[] args) {

        System.out.println("Operation 1");
        addFirst(20);

        System.out.println("Operation 2");
        addFirst(10);

        System.out.println("Operation 3");
        addLast(30);

        System.out.println("Operation 4");
        addLast(40);

        printList();

        System.out.println("\nOperation 5");
        System.out.println("Contains 30: " + contains(30));

        System.out.println("\nOperation 6");
        remove(10);
        printList();

        System.out.println("\nOperation 7");
        remove(40);
        printList();

        System.out.println("\nOperation 8");
        remove(99);
        printList();

        System.out.println("\n=== Statistics ===");
        System.out.println("Count: " + count());
        System.out.println("Sum: " + sum());
        System.out.println("Max: " + max());
        System.out.println("Min: " + min());
    }
}