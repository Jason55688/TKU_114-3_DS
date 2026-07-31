import java.util.Scanner;

public class SeatNumberSearchPractice {

    public static int binarySearch(int[] seats, int target) {

        int low = 0;
        int high = seats.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            System.out.println(
                "low=" + low +
                ", mid=" + mid +
                ", high=" + high
            );

            if (seats[mid] == target) {
                return mid;
            }

            if (target < seats[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // 12筆已排序座位編號
        int[] seats = {
            101, 102, 103, 104,
            105, 106, 107, 108,
            109, 110, 111, 112
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入座位編號：");
        int target = sc.nextInt();

        int index = binarySearch(seats, target);

        if (index != -1) {
            System.out.println(
                "找到座位，索引位置：" + index);
        } else {
            System.out.println(
                "找不到座位編號！");
        }

        sc.close();
    }
}