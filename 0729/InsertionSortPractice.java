import java.util.Arrays;

public class InsertionSortPractice {

    public static void insertionSort(int[] arr) {

        int comparisons = 0;
        int moves = 0;

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {

                comparisons++;

                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    moves++;
                    j--;
                } else {
                    break;
                }
            }

            arr[j + 1] = key;

            System.out.println(
                    "key=" + key +
                    ", insertPosition=" + (j + 1) +
                    ", array=" + Arrays.toString(arr));
        }

        System.out.println("\n排序結果：");
        System.out.println(Arrays.toString(arr));

        System.out.println("比較次數：" + comparisons);
        System.out.println("移動次數：" + moves);
    }

    public static void main(String[] args) {

        int[] data = {30, 10, 20, 50, 40, 5};

        System.out.println("=== 原始資料 ===");
        System.out.println(Arrays.toString(data));
        insertionSort(data);

        int[] sorted = {5, 10, 20, 30, 40, 50};

        System.out.println("\n=== 已排序資料 ===");
        insertionSort(sorted);

        int[] reverse = {50, 40, 30, 20, 10, 5};

        System.out.println("\n=== 反向排序資料 ===");
        insertionSort(reverse);

        System.out.println("\n分析：");
        System.out.println("已排序資料移動次數最少。");
        System.out.println("反向排序資料每次插入都要移動前面所有元素，因此移動次數最多。");
    }
}