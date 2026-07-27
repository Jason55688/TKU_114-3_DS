public class AP03 {

    static boolean show = true;

    public static int copyBelow(float[] A, float x, float[] to) {
        int count = 0;

        for (int i = 0; i < A.length; i++) {

            if (show) {
                System.out.println("// @" + i + " " + A[i] + ":");
            }

            if (A[i] < x) {
                to[count] = A[i];
                count++;
            }

            if (show) {
                ArrayTool.println(to, count);
                System.out.println();
            }
        }

        return count;
    }

    public static void demo(float[] A, float bound) {

        ArrayTool.println(A);

        System.out.println("copy below " + bound + ":");

        float[] result = new float[A.length];

        int n = copyBelow(A, bound, result);

        System.out.println("result:");

        ArrayTool.println(result, n);

        System.out.println();
    }

    public static void main(String[] dummy) {

        float[] A = {5.0f, 91.0f, 30.0f, 16.0f, 17.0f, 80.0f, 15.0f};

        show = true;
        demo(A, 60);

        show = false;
        demo(A, 100);

        show = false;
        demo(A, 3);

        show = false;
        demo(A, 10);

        show = false;
        demo(A, 20);
    }
}