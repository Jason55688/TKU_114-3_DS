import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RepairSchedulingSystem {

    public static void main(String[] args) {

        ArrayList<RepairTask> allTasks =
                new ArrayList<>();

        Queue<RepairTask> waitingQueue =
                new LinkedList<>();

        Stack<RepairTask> completedStack =
                new Stack<>();

        allTasks.add(
                new RepairTask(
                        "R001",
                        "Printer",
                        3,
                        1));

        allTasks.add(
                new RepairTask(
                        "R002",
                        "Laptop",
                        5,
                        2));

        allTasks.add(
                new RepairTask(
                        "R003",
                        "Projector",
                        4,
                        3));

        allTasks.add(
                new RepairTask(
                        "R004",
                        "Printer",
                        5,
                        4));

        allTasks.add(
                new RepairTask(
                        "R005",
                        "Scanner",
                        2,
                        5));

        // 排序
        RepairAlgorithms.mergeSort(
                allTasks,
                0,
                allTasks.size() - 1);

        System.out.println(
                "=== 維修優先排序 ===");

        for (RepairTask task : allTasks) {

            System.out.println(task);

            waitingQueue.offer(task);
        }

        // 完成兩筆工作
        completedStack.push(
                waitingQueue.poll());

        completedStack.push(
                waitingQueue.poll());

        System.out.println(
                "\n=== 下一筆待維修 ===");

        if (!waitingQueue.isEmpty()) {

            System.out.println(
                    waitingQueue.peek());
        }

        // 搜尋設備
        System.out.println(
                "\n=== 搜尋 Printer ===");

        RepairAlgorithms.searchByEquipment(
                allTasks,
                "Printer");

        // 復原最近完成
        System.out.println(
                "\n=== 復原最近完成 ===");

        if (!completedStack.isEmpty()) {

            RepairTask undoTask =
                    completedStack.pop();

            waitingQueue.offer(
                    undoTask);

            System.out.println(
                    "已復原："
                            + undoTask);
        }

        // 統計
        System.out.println(
                "\n=== 工作統計 ===");

        System.out.println(
                "全部工作數："
                        + allTasks.size());

        System.out.println(
                "等待工作數："
                        + waitingQueue.size());

        System.out.println(
                "完成工作數："
                        + completedStack.size());

        // 空 Queue 測試
        Queue<RepairTask> emptyQueue =
                new LinkedList<>();

        if (emptyQueue.isEmpty()) {

            System.out.println(
                    "\n空 Queue 測試成功");
        }

        // 空 Stack 測試
        Stack<RepairTask> emptyStack =
                new Stack<>();

        if (emptyStack.isEmpty()) {

            System.out.println(
                    "空 Stack 測試成功");
        }

        // 找不到設備
        System.out.println(
                "\n=== 搜尋 Server ===");

        RepairAlgorithms.searchByEquipment(
                allTasks,
                "Server");
    }
}