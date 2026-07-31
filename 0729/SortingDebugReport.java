import java.util.Arrays;

public class SortingDebugReport {

    public static void main(String[] args) {

        System.out.println("===== Bug 1：迴圈範圍錯誤 =====");
        bug1();

        System.out.println("\n===== Bug 2：key 未保存 =====");
        bug2();

        System.out.println("\n===== Bug 3：比較方向錯誤 =====");
        bug3();
    }

    // Bug 1
    public static void bug1() {

        int[] arr = {30, 10, 20};

        System.out.println("原始資料：" +
                Arrays.toString(arr));

        System.out.println("錯誤原因：for 迴圈少執行最後一輪");
        System.out.println("修正方法：i < arr.length");

        int[] fixed = {30, 10, 20};

        for (int i = 1; i < fixed.length; i++) {

            int key = fixed[i];
            int j = i - 1;

            while (j >= 0 && fixed[j] > key) {
                fixed[j + 1] = fixed[j];
                j--;
            }

            fixed[j + 1] = key;
        }

        System.out.println("修正後："
                + Arrays.toString(fixed));
    }

    // Bug 2
    public static void bug2() {

        int[] arr = {40, 30, 20, 10};

        System.out.println("原始資料：" +
                Arrays.toString(arr));

        System.out.println("錯誤原因：沒有先保存 key");
        System.out.println("會造成資料被覆蓋");

        System.out.println("修正方法：");
        System.out.println(
                "int key = arr[i];");

        int[] fixed = {40, 30, 20, 10};

        for (int i = 1; i < fixed.length; i++) {

            int key = fixed[i];
            int j = i - 1;

            while (j >= 0 && fixed[j] > key) {

                fixed[j + 1] = fixed[j];
                j--;
            }

            fixed[j + 1] = key;
        }

        System.out.println("修正後："
                + Arrays.toString(fixed));
    }

    // Bug 3
    public static void bug3() {

        int[] arr = {15, 8, 20, 5};

        System.out.println("原始資料：" +
                Arrays.toString(arr));

        System.out.println("錯誤原因：比較方向寫反");

        System.out.println(
                "錯誤：arr[j] < key");

        System.out.println(
                "正確：arr[j] > key");

        int[] fixed = {15, 8, 20, 5};

        for (int i = 1; i < fixed.length; i++) {

            int key = fixed[i];
            int j = i - 1;

            while (j >= 0 && fixed[j] > key) {

                fixed[j + 1] = fixed[j];
                j--;
            }

            fixed[j + 1] = key;
        }

        System.out.println("修正後："
                + Arrays.toString(fixed));
    }
}