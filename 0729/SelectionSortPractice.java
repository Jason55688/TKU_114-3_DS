import java.util.Arrays;

public class SelectionSortPractice {

    public static void selectionSort(int[] arr) {

        int comparisons = 0;
        int swaps = 0;

        for (int start = 0; start < arr.length - 1; start++) {

            int minIndex = start;

            for (int i = start + 1; i < arr.length; i++) {

                comparisons++;

                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }

            System.out.println(
                    "start=" + start +
                    ", minIndex=" + minIndex +
                    ", current=" + Arrays.toString(arr));

            if (minIndex != start) {

                int temp = arr[start];
                arr[start] = arr[minIndex];
                arr[minIndex] = temp;

                swaps++;
            }
        }

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(arr));

        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
    }

    public static void main(String[] args) {

        int[] numbers = {42, 18, 35, 7, 29, 14};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(numbers));

        System.out.println("\n=== Selection Sort Process ===");

        selectionSort(numbers);

        // 單一元素測試
        int[] single = {100};

        System.out.println("\n=== Single Element Test ===");
        selectionSort(single);

        // 空陣列測試
        int[] empty = {};

        System.out.println("\n=== Empty Array Test ===");
        selectionSort(empty);
    }
}