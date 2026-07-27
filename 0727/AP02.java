public class AP02 {

    // 印出 c 共 n 次
    public static void pm(char c, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(c);
        }
    }

    // 計算 x 的 n 次方
    public static int pw(int x, int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= x;
        }

        return result;
    }

    public static void main(String[] args) {

        // 1. 用參數 'A' 和 5 呼叫 pm
        pm('A', 5);

        // 2. 換行
        System.out.println();

        // 3. 用參數 10 和 3 呼叫 pw 並印出結果
        System.out.print(pw(10, 3));

        // 4. 換行
        System.out.println();

        // 5. 迴圈 i = 1 ~ 5
        for (int i = 1; i <= 5; i++) {
            System.out.print(pw(2, i) + " ");
        }
    }
}