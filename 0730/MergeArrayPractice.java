import java.util.Arrays;

public class MergeArrayPractice {

    public static int[] merge(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length + arr2.length];

        int i = 0; // arr1
        int j = 0; // arr2
        int k = 0; // result

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }

            k++;
        }

        // 處理 arr1 剩餘元素
        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        // 處理 arr2 剩餘元素
        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr1 = {-5, 1, 3, 7, 7, 15};
        int[] arr2 = {-2, 0, 4, 7, 10};

        System.out.println("Array 1:");
        System.out.println(Arrays.toString(arr1));

        System.out.println("Array 2:");
        System.out.println(Arrays.toString(arr2));

        int[] merged = merge(arr1, arr2);

        System.out.println("Merged Array:");
        System.out.println(Arrays.toString(merged));

        // 空陣列測試
        int[] empty = {};

        System.out.println("\nEmpty Array Test:");
        System.out.println(Arrays.toString(
                merge(arr1, empty)));
    }
}
