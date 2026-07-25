import java.util.Stack;

public class BrowserUndoSystem {

    public static void main(String[] args) {

        Stack<String> history = new Stack<>();

        // 操作1
        openPage(history, "google.com");

        // 操作2
        openPage(history, "youtube.com");

        // 操作3
        openPage(history, "github.com");

        // 操作4
        showCurrentPage(history);

        // 操作5
        goBack(history);

        // 操作6
        showCurrentPage(history);

        // 操作7
        goBack(history);

        // 操作8
        showCurrentPage(history);

        // 操作9
        goBack(history);

        // 操作10
        goBack(history);
    }

    // 開啟新頁面
    public static void openPage(
            Stack<String> history,
            String url) {

        history.push(url);

        System.out.println(
                "Open: " + url);
    }

    // 返回上一頁
    public static void goBack(
            Stack<String> history) {

        if (history.isEmpty()) {
            System.out.println(
                    "沒有頁面可返回");
            return;
        }

        history.pop();

        if (history.isEmpty()) {
            System.out.println(
                    "目前沒有頁面");
        } else {
            System.out.println(
                    "Back to: "
                            + history.peek());
        }
    }

    // 查看目前頁面
    public static void showCurrentPage(
            Stack<String> history) {

        if (history.isEmpty()) {

            System.out.println(
                    "目前沒有頁面");

            return;
        }

        System.out.println(
                "Current Page: "
                        + history.peek());
    }
}