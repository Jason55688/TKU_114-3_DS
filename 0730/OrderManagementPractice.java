import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class OrderManagementPractice {

    public static void main(String[] args) {

        Order[] orders = {

            new Order("O001", "Amy", 1500),
            new Order("O002", "John", 3200),
            new Order("O003", "Amy", 2800),
            new Order("O004", "David", 900),
            new Order("O005", "Lisa", 5000),
            new Order("O006", "Tom", 2200)
        };

        System.out.println("=== 原始訂單 ===");

        for (Order order : orders) {
            System.out.println(order);
        }

        // Merge Sort
        OrderAlgorithms.mergeSort(
                orders,
                0,
                orders.length - 1);

        System.out.println("\n=== 依金額降冪排序 ===");

        for (Order order : orders) {
            System.out.println(order);
        }

        // 搜尋客戶全部訂單
        System.out.println("\n=== 搜尋 Amy ===");

        OrderAlgorithms.searchByCustomer(
                orders,
                "Amy");

        // Queue
        Queue<Order> processingQueue =
                new LinkedList<>();

        processingQueue.offer(orders[0]);
        processingQueue.offer(orders[1]);

        System.out.println(
                "\n下一筆待處理：");

        if (!processingQueue.isEmpty()) {
            System.out.println(
                    processingQueue.peek());
        }

        // 空 Queue 測試
        Queue<Order> emptyQueue =
                new LinkedList<>();

        System.out.println(
                "\n空 Queue 測試：");

        if (emptyQueue.isEmpty()) {
            System.out.println("Queue 為空");
        }

        // Stack
        Stack<Order> completedStack =
                new Stack<>();

        completedStack.push(orders[0]);
        completedStack.push(orders[1]);

        System.out.println(
                "\n最近完成訂單：");

        if (!completedStack.isEmpty()) {
            System.out.println(
                    completedStack.peek());
        }

        // 空 Stack 測試
        Stack<Order> emptyStack =
                new Stack<>();

        System.out.println(
                "\n空 Stack 測試：");

        if (emptyStack.isEmpty()) {
            System.out.println("Stack 為空");
        }

        // 重複編號測試
        System.out.println(
                "\n重複編號檢查：");

        System.out.println(
                "O001 -> "
                + OrderAlgorithms
                .isDuplicateOrderId(
                        orders,
                        "O001"));

        // 找不到資料測試
        System.out.println(
                "\n搜尋 Kevin：");

        OrderAlgorithms.searchByCustomer(
                orders,
                "Kevin");
    }
}