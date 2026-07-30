import java.util.Stack;

public class BracketValidationSystem {

    public static void main(String[] args) {

        test("(a+b)");
        test("{[()]}");
        test("(]");
        test("())");
        test("(((");
        test("a+b*c");
        test("{a+[b*(c+d)]}");
        test("{[(])}");
    }

    public static void test(String expression) {

        System.out.println(
                expression + " -> "
                        + (isValid(expression)
                        ? "Valid"
                        : "Invalid"));
    }

    // 括號驗證
    public static boolean isValid(String expression) {

        Stack<Character> stack =
                new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // 左括號
            if (isOpeningBracket(ch)) {
                stack.push(ch);
            }

            // 右括號
            else if (isClosingBracket(ch)) {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // 是否為左括號
    public static boolean isOpeningBracket(char ch) {

        return ch == '('
                || ch == '['
                || ch == '{';
    }

    // 是否為右括號
    public static boolean isClosingBracket(char ch) {

        return ch == ')'
                || ch == ']'
                || ch == '}';
    }

    // 是否配對成功
    public static boolean isMatchingPair(
            char left,
            char right) {

        return (left == '(' && right == ')')
                || (left == '[' && right == ']')
                || (left == '{' && right == '}');
    }
}