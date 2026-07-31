import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EventRegistrationSystem {

    public static void main(String[] args) {

        final int CAPACITY = 5;

        ArrayList<Registration> registrations =
                new ArrayList<>();

        Queue<Registration> waitingQueue =
                new LinkedList<>();

        Stack<Registration> cancelHistory =
                new Stack<>();

        addRegistration(
                registrations,
                waitingQueue,
                CAPACITY,
                "R001",
                "Amy");

        addRegistration(
                registrations,
                waitingQueue,
                CAPACITY,
                "R002",
                "John");

        addRegistration(
                registrations,
                waitingQueue,
                CAPACITY,
                "R003",
                "Mary");

        addRegistration(
                registrations,
                waitingQueue,
                CAPACITY,
                "R004",
                "David");

        addRegistration(
                registrations,
                waitingQueue,
                CAPACITY,
                "R005",
                "Lisa");

        // 額滿進入候補
        addRegistration(
                registrations,
                waitingQueue,
                CAPACITY,
                "R006",
                "Tom");

        addRegistration(
                registrations,
                waitingQueue,
                CAPACITY,
                "R007",
                "Kevin");

        System.out.println("=== 全部報名資料 ===");

        for (Registration r : registrations) {
            System.out.println(r);
        }

        // Merge Sort
        RegistrationAlgorithms.mergeSort(
                registrations,
                0,
                registrations.size() - 1);

        System.out.println("\n=== Binary Search R003 ===");

        int index =
                RegistrationAlgorithms.binarySearch(
                        registrations,
                        "R003");

        if (index != -1) {
            System.out.println(
                    registrations.get(index));
        }

        System.out.println("\n=== Search Amy ===");

        RegistrationAlgorithms.searchByName(
                registrations,
                "Amy");

        // 取消報名
        Registration cancelled =
                registrations.remove(2);

        cancelHistory.push(cancelled);

        System.out.println(
                "\n取消成功："
                + cancelled);

        // 復原取消
        if (!cancelHistory.isEmpty()) {

            Registration undo =
                    cancelHistory.pop();

            registrations.add(undo);

            System.out.println(
                    "已復原："
                    + undo);
        }

        // 候補名單
        System.out.println(
                "\n=== Waiting Queue ===");

        if (waitingQueue.isEmpty()) {

            System.out.println("無候補資料");

        } else {

            for (Registration r : waitingQueue) {
                System.out.println(r);
            }
        }

        // 空候補 Queue 測試
        Queue<Registration> emptyQueue =
                new LinkedList<>();

        System.out.println(
                "\n=== Empty Queue Test ===");

        if (emptyQueue.isEmpty()) {
            System.out.println("候補 Queue 為空");
        }

        // 找不到測試
        System.out.println(
                "\n=== Search R999 ===");

        int result =
                RegistrationAlgorithms.binarySearch(
                        registrations,
                        "R999");

        if (result == -1) {
            System.out.println("找不到報名資料");
        }

        // 重複編號測試
        System.out.println(
                "\n=== Duplicate Test ===");

        System.out.println(
                RegistrationAlgorithms
                        .isDuplicateId(
                                registrations,
                                "R001"));
    }

    public static void addRegistration(
            ArrayList<Registration> registrations,
            Queue<Registration> waitingQueue,
            int capacity,
            String id,
            String name) {

        if (RegistrationAlgorithms
                .isDuplicateId(
                        registrations,
                        id)) {

            System.out.println(
                    "重複編號：" + id);

            return;
        }

        boolean confirmed =
                registrations.size() < capacity;

        Registration registration =
                new Registration(
                        id,
                        name,
                        confirmed);

        registrations.add(registration);

        if (!confirmed) {
            waitingQueue.offer(registration);
        }
    }
}