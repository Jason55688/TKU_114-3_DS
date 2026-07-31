import java.util.Scanner;

public class RangeSearchSystem {

    // 找第一個出現位置
    public static int findFirst(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                result = mid;
                high = mid - 1; // 繼續往左找
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    // 找最後一個出現位置
    public static int findLast(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                result = mid;
                low = mid + 1; // 繼續往右找
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] numbers = {
            2, 2, 2,
            5, 5,
            8, 8, 8, 8,
            10,
            15, 15,
            20, 20, 20
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入搜尋數字：");
        int target = sc.nextInt();

        int first = findFirst(numbers, target);
        int last = findLast(numbers, target);

        if (first == -1) {

            System.out.println("範圍：[-1, -1]");
            System.out.println("出現次數：0");

        } else {

            int count = last - first + 1;

            System.out.println("第一個位置：" + first);
            System.out.println("最後一個位置：" + last);
            System.out.println("範圍：[" + first + ", " + last + "]");
            System.out.println("出現次數：" + count);
        }

        sc.close();
    }
}