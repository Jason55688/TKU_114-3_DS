public class AlgorithmComparisonReport {

    static long selectionComparisons;
    static long insertionComparisons;
    static long mergeComparisons;

    // 建立已排序資料
    public static int[] createSortedData(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }

    // 建立反向資料
    public static int[] createReverseData(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }

        return arr;
    }

    // 建立固定亂序資料
    public static int[] createRandomData(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (i * 37 + 13) % size;
        }

        return arr;
    }

    // 複製陣列
    public static int[] copyArray(int[] original) {

        int[] copy = new int[original.length];

        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }

        return copy;
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {

        selectionComparisons = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                selectionComparisons++;

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {

        insertionComparisons = 0;

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {

                insertionComparisons++;

                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }

            arr[j + 1] = key;
        }
    }

    // Merge Sort
    public static void mergeSort(
            int[] arr,
            int left,
            int right) {

        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

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

            mergeComparisons++;

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

    public static void runTest(
            String title,
            int[] source) {

        System.out.println("\n=== " + title + " ===");

        int[] s1 = copyArray(source);
        int[] s2 = copyArray(source);
        int[] s3 = copyArray(source);

        selectionSort(s1);

        insertionSort(s2);

        mergeComparisons = 0;
        mergeSort(s3, 0, s3.length - 1);

        System.out.println(
                "Selection Sort Comparisons : "
                        + selectionComparisons);

        System.out.println(
                "Insertion Sort Comparisons : "
                        + insertionComparisons);

        System.out.println(
                "Merge Sort Comparisons     : "
                        + mergeComparisons);
    }

    public static void testSize(int size) {

        System.out.println(
                "\n===============================");
        System.out.println("Data Size : " + size);
        System.out.println(
                "===============================");

        runTest(
                "Sorted Data",
                createSortedData(size));

        runTest(
                "Reverse Data",
                createReverseData(size));

        runTest(
                "Random Data",
                createRandomData(size));
    }

    public static void main(String[] args) {

        testSize(16);
        testSize(128);
        testSize(1024);

        System.out.println(
                "\n========== Analysis ==========");

        System.out.println(
                "1. Selection Sort 比較次數幾乎固定，與資料排列關係不大。");

        System.out.println(
                "2. Insertion Sort 在已排序資料時比較次數最少。");

        System.out.println(
                "3. Insertion Sort 在反向排序資料時比較次數最多。");

        System.out.println(
                "4. Merge Sort 在三種資料型態下比較次數相對穩定。");

        System.out.println(
                "5. 資料量越大，Merge Sort 的優勢越明顯。");
    }
}