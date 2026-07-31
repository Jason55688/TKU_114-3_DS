import java.util.Scanner;

public class AllOccurrenceSearch {

    public static void main(String[] args) {

        int[] numbers = {
                5, 2, 8, 5, 3,
                5, 9, 1, 5, 7
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入搜尋數字：");
        int target = sc.nextInt();

        int count = 0;
        int comparisons = 0;

        System.out.print("出現位置：");

        for (int i = 0; i < numbers.length; i++) {

            comparisons++;

            if (numbers[i] == target) {
                System.out.print(i + " ");
                count++;
            }
        }

        System.out.println();

        if (count == 0) {
            System.out.println("找不到資料！");
        } else {
            System.out.println("出現次數：" + count);
        }

        System.out.println("比較次數：" + comparisons);

        sc.close();
    }
}