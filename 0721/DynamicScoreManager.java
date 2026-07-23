import java.util.ArrayList;
import java.util.Scanner;

public class DynamicScoreManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> scores = new ArrayList<>();

        inputScores(sc, scores);

        if (scores.isEmpty()) {
            System.out.println("沒有輸入任何成績");
        } else {

            System.out.println("\n=== Statistics ===");
            System.out.println("Count: " + scores.size());
            System.out.println("Average: " + calculateAverage(scores));
            System.out.println("Max: " + findMax(scores));
            System.out.println("Min: " + findMin(scores));
            System.out.println("Pass Count: " + countPass(scores));
        }

        sc.close();
    }

    // 輸入成績
    public static void inputScores(
            Scanner sc,
            ArrayList<Integer> scores) {

        while (true) {

            System.out.print("請輸入成績(-1結束)：");
            int score = sc.nextInt();

            if (score == -1) {
                break;
            }

            if (isValidScore(score)) {
                scores.add(score);
            } else {
                System.out.println("成績必須介於 0~100");
            }
        }
    }

    // 驗證成績
    public static boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }

    // 平均
    public static double calculateAverage(
            ArrayList<Integer> scores) {

        int total = 0;

        for (int score : scores) {
            total += score;
        }

        return (double) total / scores.size();
    }

    // 最高分
    public static int findMax(
            ArrayList<Integer> scores) {

        int max = scores.get(0);

        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }

        return max;
    }

    // 最低分
    public static int findMin(
            ArrayList<Integer> scores) {

        int min = scores.get(0);

        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }

        return min;
    }

    // 及格人數
    public static int countPass(
            ArrayList<Integer> scores) {

        int count = 0;

        for (int score : scores) {
            if (score >= 60) {
                count++;
            }
        }

        return count;
    }
}
