import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DeliveryProcessingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<DeliveryTask> waitingQueue =
                new LinkedList<>();

        Stack<DeliveryTask> completedStack =
                new Stack<>();

        int option;

        do {

            printMenu();

            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:
                    addTask(sc, waitingQueue);
                    break;

                case 2:
                    completeTask(
                            waitingQueue,
                            completedStack);
                    break;

                case 3:
                    showNextTask(waitingQueue);
                    break;

                case 4:
                    undoLastCompleted(
                            waitingQueue,
                            completedStack);
                    break;

                case 5:
                    showStatistics(
                            waitingQueue,
                            completedStack);
                    break;

                case 6:
                    showCompletedHistory(
                            completedStack);
                    break;

                case 0:
                    System.out.println("系統結束");
                    break;

                default:
                    System.out.println("無效選項！");
            }

            System.out.println();

        } while (option != 0);

        sc.close();
    }

    // 顯示選單
    public static void printMenu() {

        System.out.println("=== Delivery System ===");
        System.out.println("1. 新增配送工作");
        System.out.println("2. 完成下一筆配送");
        System.out.println("3. 查看下一筆配送");
        System.out.println("4. 復原最近完成");
        System.out.println("5. 顯示統計");
        System.out.println("6. 顯示完成紀錄");
        System.out.println("0. 離開");
    }

    // 新增配送工作
    public static void addTask(
            Scanner sc,
            Queue<DeliveryTask> queue) {

        System.out.print("訂單編號：");
        String orderId = sc.nextLine();

        System.out.print("客戶姓名：");
        String customer = sc.nextLine();

        queue.offer(
                new DeliveryTask(orderId, customer));

        System.out.println("新增成功！");
    }

    // 完成配送
    public static void completeTask(
            Queue<DeliveryTask> queue,
            Stack<DeliveryTask> completed) {

        if (queue.isEmpty()) {
            System.out.println("目前沒有待配送工作");
            return;
        }

        DeliveryTask task = queue.poll();

        completed.push(task);

        System.out.println(
                "完成配送：" + task);
    }

    // 下一筆配送
    public static void showNextTask(
            Queue<DeliveryTask> queue) {

        if (queue.isEmpty()) {
            System.out.println("目前沒有待配送工作");
            return;
        }

        System.out.println(
                "下一筆：" + queue.peek());
    }

    // 復原最近完成
    public static void undoLastCompleted(
            Queue<DeliveryTask> queue,
            Stack<DeliveryTask> completed) {

        if (completed.isEmpty()) {
            System.out.println("沒有可復原紀錄");
            return;
        }

        DeliveryTask task = completed.pop();

        queue.offer(task);

        System.out.println(
                "已復原：" + task);
    }

    // 統計
    public static void showStatistics(
            Queue<DeliveryTask> queue,
            Stack<DeliveryTask> completed) {

        System.out.println(
                "待配送數量：" + queue.size());

        System.out.println(
                "已完成數量：" + completed.size());
    }

    // 完成紀錄
    public static void showCompletedHistory(
            Stack<DeliveryTask> completed) {

        if (completed.isEmpty()) {
            System.out.println("尚無完成紀錄");
            return;
        }

        System.out.println(
                "=== Completed Tasks ===");

        for (DeliveryTask task : completed) {
            System.out.println(task);
        }
    }
}