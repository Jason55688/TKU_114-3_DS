import java.util.Arrays;
import java.util.Scanner;

public class InventorySearchPractice {

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    // Merge
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
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            System.out.println(
                "low=" + low +
                ", mid=" + mid +
                ", high=" + high);

            if (arr[mid] == target) {
                return mid;
            }

            if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] inventoryIds = {
                305, 102, 450, 210,
                999, 150, 730, 420,
                125, 560, 820, 300
        };

        System.out.println("排序前：");
        System.out.println(Arrays.toString(inventoryIds));

        mergeSort(
                inventoryIds,
                0,
                inventoryIds.length - 1);

        System.out.println("\n排序後：");
        System.out.println(Arrays.toString(inventoryIds));

        Scanner sc = new Scanner(System.in);

        System.out.print("\n請輸入庫存編號：");
        int target = sc.nextInt();

        int index =
                binarySearch(inventoryIds, target);

        if (index != -1) {

            System.out.println(
                    "找到庫存編號，索引位置："
                            + index);

        } else {

            System.out.println(
                    "找不到庫存編號！");
        }

        sc.close();
    }
}