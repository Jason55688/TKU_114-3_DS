public class ArrayTool {

    // 印出前 n 個元素
    public static void print(float[] A, int s) {
        System.out.print("[ ");
        for (int i = 0; i < s; i++) {
            System.out.print(A[i] + ", ");
        }
        System.out.print("]");
    }

    // 印出整個陣列
    public static void print(float[] A) {
        print(A, A.length);
    }

    // 印出前 s 個元素並換行
    public static void println(float[] A, int s) {
        print(A, s);
        System.out.println();
    }

    // 印出整個陣列並換行
    public static void println(float[] A) {
        print(A);
        System.out.println();
    }

    // 複製陣列前 n 個元素
    public static float[] copy(float[] A, int n) {
        float[] B = new float[n];

        for (int i = 0; i < n; i++) {
            B[i] = A[i];
        }

        return B;
    }
}