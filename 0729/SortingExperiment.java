import java.util.Arrays;

public class SortingExperiment {

    // Selection Sort
    public static void selectionSort(int[] arr) {

        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                comparisons++;

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {

                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;

                swaps++;
            }
        }

        System.out.println("Selection Sort");
        System.out.println("Result: " + Arrays.toString(arr));
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
    }

    // Insertion Sort
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
        }

        System.out.println("Insertion Sort");
        System.out.println("Result: " + Arrays.toString(arr));
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Moves: " + moves);
    }

    // 複製陣列
    public static int[] copyArray(int[] original) {

        int[] copy = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }

        return copy;
    }

    // 執行實驗
    public static void runExperiment(
            String title,
            int[] data) {

        System.out.println("\n========================");
        System.out.println(title);
        System.out.println("========================");

        int[] selectionData = copyArray(data);
        int[] insertionData = copyArray(data);

        System.out.println("Original: "
                + Arrays.toString(data));

        System.out.println();
        selectionSort(selectionData);

        System.out.println();
        insertionSort(insertionData);
    }

    public static void main(String[] args) {

        int[] sorted = {
                10, 20, 30, 40, 50, 60
        };

        int[] reverse = {
                60, 50, 40, 30, 20, 10
        };

        int[] random = {
                30, 10, 50, 20, 60, 40
        };

        runExperiment(
                "已排序資料",
                sorted);

        runExperiment(
                "反向排序資料",
                reverse);

        runExperiment(
                "隨機排序資料",
                random);

        System.out.println("\n=== 結論 ===");
        System.out.println(
                "Selection Sort 的比較次數幾乎固定。");

        System.out.println(
                "Insertion Sort 在已排序資料時移動次數最少。");

        System.out.println(
                "反向排序資料會讓 Insertion Sort 產生最多移動次數。");

        System.out.println(
                "隨機資料的效能通常介於兩者之間。");
    }
}