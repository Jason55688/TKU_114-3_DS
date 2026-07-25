import java.util.Stack;

public class TextEditorUndoSystem {

    public static void main(String[] args) {

        Stack<String> history = new Stack<>();
        String text = "";

        System.out.println("Initial: \"" + text + "\"");

        // 輸入文字
        history.push(text);
        text = addText(text, "Java");
        System.out.println("Add Java -> " + text);

        history.push(text);
        text = addText(text, " Programming");
        System.out.println("Add Programming -> " + text);

        history.push(text);
        text = addText(text, " Language");
        System.out.println("Add Language -> " + text);

        // 刪除最後一個字元
        history.push(text);
        text = deleteLastChar(text);
        System.out.println("Delete -> " + text);

        // Undo 1
        text = undo(history, text);
        System.out.println("Undo 1 -> " + text);

        // Undo 2
        text = undo(history, text);
        System.out.println("Undo 2 -> " + text);

        // Undo 3
        text = undo(history, text);
        System.out.println("Undo 3 -> " + text);

        // Undo 4
        text = undo(history, text);
        System.out.println("Undo 4 -> " + text);

        // 沒有歷史紀錄再 Undo
        text = undo(history, text);
        System.out.println("Undo 5 -> " + text);
    }

    // 新增文字
    public static String addText(
            String currentText,
            String newText) {

        return currentText + newText;
    }

    // 刪除最後一個字元
    public static String deleteLastChar(
            String text) {

        if (text.isEmpty()) {
            return text;
        }

        return text.substring(0, text.length() - 1);
    }

    // Undo
    public static String undo(
            Stack<String> history,
            String currentText) {

        if (history.isEmpty()) {
            System.out.println("沒有可還原的歷史紀錄！");
            return currentText;
        }

        return history.pop();
    }
}