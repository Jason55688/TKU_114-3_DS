import java.util.Scanner;

public class ArrayStatistics {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = readCount(sc);

        int[] scores = new int[count];

        inputScores(sc, scores);

        System.out.println("\n=== All Scores ===");

        for (int score : scores) {
            System.out.print(score + " ");
        }

        System.out.println();

        int total = calculateTotal(scores);
        double average = (double) total / scores.length;
        int max = findMax(scores);
        int min = findMin(scores);
        int passCount = countPass(scores);
        int failCount = scores.length - passCount;

        System.out.println("\n=== Statistics ===");
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Pass Count: " + passCount);
        System.out.println("Fail Count: " + failCount);

        System.out.print("\n請輸入要搜尋的成績：");
        int target = sc.nextInt();

        int index = findIndex(scores, target);

        if (index == -1) {
            System.out.println("找不到該成績！");
        } else {
            System.out.println("第一次出現位置索引：" + index);
        }

        sc.close();
    }

    // 讀取筆數
    public static int readCount(Scanner sc) {

        int count;

        do {
            System.out.print("請輸入成績筆數(1~50)：");
            count = sc.nextInt();
        } while (count < 1 || count > 50);

        return count;
    }

    // 輸入成績
    public static void inputScores(Scanner sc, int[] scores) {

        for (int i = 0; i < scores.length; i++) {

            int score;

            do {
                System.out.print("請輸入第 " + (i + 1) + " 筆成績(0~100)：");
                score = sc.nextInt();
            } while (score < 0 || score > 100);

            scores[i] = score;
        }
    }

    // 計算總分
    public static int calculateTotal(int[] scores) {

        int total = 0;

        for (int score : scores) {
            total += score;
        }

        return total;
    }

    // 找最大值
    public static int findMax(int[] scores) {

        int max = scores[0];

        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }

        return max;
    }

    // 找最小值
    public static int findMin(int[] scores) {

        int min = scores[0];

        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }

        return min;
    }

    // 統計及格人數
    public static int countPass(int[] scores) {

        int count = 0;

        for (int score : scores) {
            if (score >= 60) {
                count++;
            }
        }

        return count;
    }

    // 搜尋索引
    public static int findIndex(int[] scores, int target) {

        for (int i = 0; i < scores.length; i++) {

            if (scores[i] == target) {
                return i;
            }
        }

        return -1;
    }
}