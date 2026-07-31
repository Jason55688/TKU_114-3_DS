import java.util.Arrays;

public class MergeSortPractice {

    public static void mergeSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        System.out.println(
                "Split: " +
                Arrays.toString(
                        Arrays.copyOfRange(
                                arr,
                                left,
                                right + 1)));

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public static void merge(
            int[] arr,
            int left,
            int mid,
            int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }

        System.out.println(
                "Merge: " +
                Arrays.toString(
                        Arrays.copyOfRange(
                                arr,
                                left,
                                right + 1)));
    }

    public static void test(int[] data, String title) {

        System.out.println("\n=== " + title + " ===");

        System.out.println("Before:");
        System.out.println(Arrays.toString(data));

        mergeSort(data, 0, data.length - 1);

        System.out.println("After:");
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {

        int[] numbers = {
                41, 12, 35, 8,
                27, 19, 50, 3
        };

        test(numbers, "Original Data");

        test(new int[]{}, "Empty Array");

        test(new int[]{100}, "Single Element");

        test(
                new int[]{5,10,15,20,25},
                "Already Sorted");

        test(
                new int[]{50,40,30,20,10},
                "Reverse Sorted");
    }
}