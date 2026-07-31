import java.util.Scanner;

public class EmployeeSearchSystem {

    // Binary Search
    public static int binarySearch(
            Employee[] employees,
            int targetId) {

        int low = 0;
        int high = employees.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            System.out.println(
                    "low=" + low +
                    ", mid=" + mid +
                    ", high=" + high);

            int currentId =
                    employees[mid].getEmployeeId();

            if (currentId == targetId) {
                return mid;
            }

            if (targetId < currentId) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // 必須依員工編號排序
        Employee[] employees = {

                new Employee(
                        1001,
                        "Amy",
                        "HR"),

                new Employee(
                        1005,
                        "John",
                        "IT"),

                new Employee(
                        1010,
                        "Mary",
                        "Finance"),

                new Employee(
                        1015,
                        "David",
                        "Sales"),

                new Employee(
                        1020,
                        "Tom",
                        "Marketing"),

                new Employee(
                        1025,
                        "Lisa",
                        "IT"),

                new Employee(
                        1030,
                        "Kevin",
                        "HR"),

                new Employee(
                        1035,
                        "Emma",
                        "Finance")
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入員工編號：");
        int targetId = sc.nextInt();

        int index =
                binarySearch(employees, targetId);

        if (index != -1) {

            System.out.println("\n找到員工資料：");
            System.out.println(
                    employees[index]);

        } else {

            System.out.println(
                    "\n找不到員工編號："
                            + targetId);
        }

        sc.close();
    }
}