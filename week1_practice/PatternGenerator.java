package week1_practice;

import java.util.Scanner;

public class PatternGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option;

        do {

            printMenu();

            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch (option) {

                case 1:
                    printMultiplicationTable();
                    break;

                case 2:
                    int height1 =
                            readPositiveInt(sc, "請輸入高度：");
                    printTriangle(height1);
                    break;

                case 3:
                    int height2 =
                            readPositiveInt(sc, "請輸入高度：");
                    printReverseTriangle(height2);
                    break;

                case 4:
                    int rows =
                            readPositiveInt(sc, "請輸入列數：");

                    int cols =
                            readPositiveInt(sc, "請輸入欄數：");

                    printNumberGrid(rows, cols);
                    break;

                case 0:
                    System.out.println("Bye!");
                    break;

                default:
                    System.out.println("無效選項！");
            }

            System.out.println();

        } while (option != 0);

        sc.close();
    }

    // 顯示選單
    public static void printMenu() {

        System.out.println("=== Pattern Menu ===");
        System.out.println("1. 九九乘法表");
        System.out.println("2. 正三角形星號");
        System.out.println("3. 倒三角形星號");
        System.out.println("4. 數字方格");
        System.out.println("0. 離開");
    }

    // 讀取正整數
    public static int readPositiveInt(
            Scanner sc, String message) {

        System.out.print(message);
        int value = sc.nextInt();

        while (value <= 0) {
            System.out.print("必須大於 0，請重新輸入：");
            value = sc.nextInt();
        }

        return value;
    }

    // 九九乘法表
    public static void printMultiplicationTable() {

        for (int i = 1; i <= 9; i++) {

            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d*%d=%2d\t",
                        i, j, i * j);
            }

            System.out.println();
        }
    }

    // 正三角形
    public static void printTriangle(int height) {

        for (int i = 1; i <= height; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    // 倒三角形
    public static void printReverseTriangle(int height) {

        for (int i = height; i >= 1; i--) {

            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    // 數字方格
    public static void printNumberGrid(int rows, int cols) {

        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= cols; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}