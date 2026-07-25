import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ClinicQueueSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<Patient> queue = new LinkedList<>();

        int servicedCount = 0;

        int option;

        do {

            printMenu();

            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:
                    registerPatient(sc, queue);
                    break;

                case 2:
                    if (callNext(queue)) {
                        servicedCount++;
                    }
                    break;

                case 3:
                    showNextPatient(queue);
                    break;

                case 4:
                    showWaitingList(queue);
                    break;

                case 5:
                    showStatistics(queue, servicedCount);
                    break;

                case 0:
                    System.out.println("系統結束");
                    break;

                default:
                    System.out.println("無效選項");
            }

            System.out.println();

        } while (option != 0);

        sc.close();
    }

    // 顯示選單
    public static void printMenu() {

        System.out.println("=== Clinic Queue System ===");
        System.out.println("1. 掛號");
        System.out.println("2. 叫號");
        System.out.println("3. 查看下一位");
        System.out.println("4. 顯示等待清單");
        System.out.println("5. 顯示統計");
        System.out.println("0. 離開");
    }

    // 掛號
    public static void registerPatient(
            Scanner sc,
            Queue<Patient> queue) {

        System.out.print("診號：");
        String number = sc.nextLine().trim();

        if (existsNumber(queue, number)) {
            System.out.println("診號不可重複！");
            return;
        }

        System.out.print("姓名：");
        String name = sc.nextLine().trim();

        System.out.print("科別：");
        String department = sc.nextLine().trim();

        queue.offer(
                new Patient(
                        number,
                        name,
                        department));

        System.out.println("掛號成功！");
    }

    // 叫號
    public static boolean callNext(
            Queue<Patient> queue) {

        if (queue.isEmpty()) {
            System.out.println("目前沒有病患等待");
            return false;
        }

        Patient patient = queue.poll();

        System.out.println("叫號：");
        System.out.println(patient);

        return true;
    }

    // 查看下一位
    public static void showNextPatient(
            Queue<Patient> queue) {

        if (queue.isEmpty()) {
            System.out.println("目前沒有病患等待");
            return;
        }

        System.out.println("下一位病患：");
        System.out.println(queue.peek());
    }

    // 顯示等待清單
    public static void showWaitingList(
            Queue<Patient> queue) {

        if (queue.isEmpty()) {
            System.out.println("等待清單為空");
            return;
        }

        System.out.println("=== Waiting List ===");

        for (Patient p : queue) {
            System.out.println(p);
        }
    }

    // 統計
    public static void showStatistics(
            Queue<Patient> queue,
            int servicedCount) {

        System.out.println("等待人數：" + queue.size());
        System.out.println("總服務人數：" + servicedCount);
    }

    // 診號是否存在
    public static boolean existsNumber(
            Queue<Patient> queue,
            String number) {

        for (Patient p : queue) {

            if (p.getNumber()
                    .equalsIgnoreCase(number)) {

                return true;
            }
        }

        return false;
    }
}