import java.util.LinkedList;
import java.util.Queue;

public class CounterServiceSystem {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        // 操作1：取號
        takeNumber(queue, "A001 王小明");

        // 操作2：取號
        takeNumber(queue, "A002 李小華");

        // 操作3：取號
        takeNumber(queue, "A003 陳大文");

        // 操作4：查看下一位
        showNextCustomer(queue);

        // 操作5：查看等待人數
        showWaitingCount(queue);

        // 操作6：叫號
        callNext(queue);

        // 操作7：叫號
        callNext(queue);

        // 操作8：查看下一位
        showNextCustomer(queue);

        // 操作9：叫號
        callNext(queue);

        // 操作10：空 Queue 再叫號
        callNext(queue);
    }

    // 取號
    public static void takeNumber(
            Queue<String> queue,
            String customer) {

        queue.offer(customer);

        System.out.println(
                "取號成功：" + customer);
    }

    // 叫號
    public static void callNext(
            Queue<String> queue) {

        if (queue.isEmpty()) {
            System.out.println("目前無等待客戶");
            return;
        }

        String customer = queue.poll();

        System.out.println(
                "叫號：" + customer);
    }

    // 查看下一位
    public static void showNextCustomer(
            Queue<String> queue) {

        if (queue.isEmpty()) {
            System.out.println("目前無等待客戶");
            return;
        }

        System.out.println(
                "下一位：" + queue.peek());
    }

    // 查看等待人數
    public static void showWaitingCount(
            Queue<String> queue) {

        System.out.println(
                "等待人數：" + queue.size());
    }
}