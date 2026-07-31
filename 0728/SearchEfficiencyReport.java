public class SearchEfficiencyReport {

    static int sequentialCount;
    static int binaryCount;

    // Sequential Search
    public static int sequentialSearch(int[] arr, int target) {

        sequentialCount = 0;

        for (int i = 0; i < arr.length; i++) {

            sequentialCount++;

            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {

        binaryCount = 0;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            binaryCount++;

            int mid = (low + high) / 2;

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

    // 產生排序資料
    public static int[] createData(int size) {

        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = i + 1;
        }

        return data;
    }

    // 測試並列印結果
    public static void test(int[] data, int target) {

        System.out.println("\nTarget = " + target);

        sequentialSearch(data, target);
        binarySearch(data, target);

        System.out.println(
                "Sequential comparisons: "
                        + sequentialCount);

        System.out.println(
                "Binary comparisons: "
                        + binaryCount);
    }

    public static void main(String[] args) {

        int[] size16 = createData(16);
        int[] size128 = createData(128);
        int[] size1024 = createData(1024);

        System.out.println("========== Size 16 ==========");
        test(size16, 1);      // 第一筆
        test(size16, 16);     // 最後一筆
        test(size16, 100);    // 不存在

        System.out.println("\n========== Size 128 ==========");
        test(size128, 1);
        test(size128, 128);
        test(size128, 200);

        System.out.println("\n========== Size 1024 ==========");
        test(size1024, 1);
        test(size1024, 1024);
        test(size1024, 2000);

        System.out.println("\n=== Analysis ===");
        System.out.println(
                "Sequential Search 比較次數會隨資料量線性增加。");

        System.out.println(
                "Binary Search 每次將搜尋範圍減半，因此比較次數成長非常慢。");

        System.out.println(
                "資料越大，Binary Search 效率優勢越明顯。");
    }
}