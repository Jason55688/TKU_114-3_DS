import java.util.Scanner;

public class TaskLinkedListSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TaskLinkedList tasks =
                new TaskLinkedList();

        int option;

        do {

            System.out.println("\n=== Task System ===");
            System.out.println("1. 新增緊急工作");
            System.out.println("2. 新增一般工作");
            System.out.println("3. 完成工作");
            System.out.println("4. 刪除已完成工作");
            System.out.println("5. 顯示全部工作");
            System.out.println("6. 顯示統計");
            System.out.println("0. 離開");
            System.out.print("請輸入選項：");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:

                    System.out.print("工作代碼：");
                    String urgentId = sc.nextLine();

                    System.out.print("工作說明：");
                    String urgentDesc = sc.nextLine();

                    tasks.addFirst(
                            urgentId,
                            urgentDesc);

                    System.out.println("新增成功");
                    break;

                case 2:

                    System.out.print("工作代碼：");
                    String normalId = sc.nextLine();

                    System.out.print("工作說明：");
                    String normalDesc = sc.nextLine();

                    tasks.addLast(
                            normalId,
                            normalDesc);

                    System.out.println("新增成功");
                    break;

                case 3:

                    System.out.print("工作代碼：");
                    String finishId = sc.nextLine();

                    if (tasks.completeTask(finishId)) {
                        System.out.println("已標記完成");
                    } else {
                        System.out.println("找不到工作");
                    }

                    break;

                case 4:

                    tasks.removeCompletedTasks();
                    System.out.println("已刪除完成工作");
                    break;

                case 5:

                    tasks.displayTasks();
                    break;

                case 6:

                    System.out.println(
                            "總工作數："
                                    + tasks.getTaskCount());

                    System.out.println(
                            "未完成工作數："
                                    + tasks.getPendingCount());

                    break;

                case 0:

                    System.out.println("系統結束");
                    break;

                default:

                    System.out.println("無效選項");
            }

        } while (option != 0);

        sc.close();
    }
}