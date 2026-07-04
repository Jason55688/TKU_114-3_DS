import java.util.Scanner;

public class ScoreReport {
    public static void main(String[] args) {
        // 建立 Scanner 物件接收使用者輸入
        Scanner input = new Scanner(System.in);

        // 宣告姓名與三科成績變數
        String name;
        int javaScore, englishScore, mathScore;
        double average;

        System.out.print("請輸入姓名：");
        name = input.nextLine();

        System.out.print("請輸入 Java 成績：");
        javaScore = input.nextInt();

        System.out.print("請輸入 English 成績：");
        englishScore = input.nextInt();

        System.out.print("請輸入 Math 成績：");
        mathScore = input.nextInt();

        // 計算三科平均
        average = (javaScore + englishScore + mathScore) / 3.0;

        System.out.println();
        System.out.println("=== 成績報表 ===");
        System.out.println("姓名：" + name);
        System.out.println("Java：" + javaScore);
        System.out.println("English：" + englishScore);
        System.out.println("Math：" + mathScore);
        System.out.println("平均：" + average);

        input.close();
    }
}