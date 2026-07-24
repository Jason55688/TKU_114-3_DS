public class TaskLinkedList {

    private TaskNode head;

    // 緊急工作加入前端
    public void addFirst(String id, String description) {

        TaskNode newNode =
                new TaskNode(id, description);

        newNode.next = head;
        head = newNode;
    }

    // 一般工作加入尾端
    public void addLast(String id, String description) {

        TaskNode newNode =
                new TaskNode(id, description);

        if (head == null) {
            head = newNode;
            return;
        }

        TaskNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // 完成工作
    public boolean completeTask(String id) {

        TaskNode task = findTask(id);

        if (task == null) {
            return false;
        }

        task.completed = true;
        return true;
    }

    // 刪除已完成工作
    public void removeCompletedTasks() {

        while (head != null && head.completed) {
            head = head.next;
        }

        if (head == null) {
            return;
        }

        TaskNode current = head;

        while (current.next != null) {

            if (current.next.completed) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // 找工作
    public TaskNode findTask(String id) {

        TaskNode current = head;

        while (current != null) {

            if (current.id.equalsIgnoreCase(id)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    // 顯示全部工作
    public void displayTasks() {

        if (head == null) {
            System.out.println("No Tasks");
            return;
        }

        TaskNode current = head;

        while (current != null) {

            System.out.println(
                    current.id + " | "
                            + current.description + " | "
                            + (current.completed
                            ? "Completed"
                            : "Pending"));

            current = current.next;
        }
    }

    // 工作數量
    public int getTaskCount() {

        int count = 0;
        TaskNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    // 未完成數量
    public int getPendingCount() {

        int count = 0;
        TaskNode current = head;

        while (current != null) {

            if (!current.completed) {
                count++;
            }

            current = current.next;
        }

        return count;
    }
}