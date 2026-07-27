public class AP01 {

    // 印出字串 s
    public static void print(String s) {
        System.out.print(s);
    }

    // 建立由 n 個 s 組成的字串
    public static String build(int n, String s) {
        String ans = "";

        for (int i = 1; i <= n; i++) {
            ans += s;
        }

        return ans;
    }

    public static void main(String[] args) {

        // 1.
        print(build(5, "ab"));

        // 2.
        print("\n");

        // 3.
        for (int i = 4; i <= 7; i++) {
            print(build(i, "c"));
            print("\n");
        }
    }
}