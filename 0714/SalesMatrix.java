import java.util.Scanner;

public class SalesMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] sales = new int[3][4];

        inputSales(sc, sales);

        System.out.println("\n=== Sales Table ===");
        displaySales(sales);

        System.out.println("\n=== Product Totals ===");

        int maxProduct = 0;
        int maxTotal = calculateProductTotal(sales, 0);

        for (int i = 0; i < sales.length; i++) {

            int total = calculateProductTotal(sales, i);

            System.out.println("Product " + (i + 1)
                    + " Total: " + total);

            if (total > maxTotal) {
                maxTotal = total;
                maxProduct = i;
            }
        }

        System.out.println("\n=== Daily Totals ===");

        for (int day = 0; day < sales[0].length; day++) {

            int total = calculateDayTotal(sales, day);

            System.out.println("Day " + (day + 1)
                    + " Total: " + total);
        }

        System.out.println("\nBest Product: Product "
                + (maxProduct + 1));
        System.out.println("Sales Total: " + maxTotal);

        sc.close();
    }

    // 輸入銷售量
    public static void inputSales(Scanner sc, int[][] sales) {

        for (int i = 0; i < sales.length; i++) {

            for (int j = 0; j < sales[i].length; j++) {

                int value;

                do {
                    System.out.print(
                            "商品" + (i + 1)
                                    + " 第" + (j + 1)
                                    + "天銷售量：");

                    value = sc.nextInt();

                } while (value < 0);

                sales[i][j] = value;
            }
        }
    }

    // 顯示表格
    public static void displaySales(int[][] sales) {

        for (int i = 0; i < sales.length; i++) {

            for (int j = 0; j < sales[i].length; j++) {
                System.out.print(sales[i][j] + "\t");
            }

            System.out.println();
        }
    }

    // 商品總量
    public static int calculateProductTotal(
            int[][] sales, int product) {

        int total = 0;

        for (int day = 0; day < sales[product].length; day++) {
            total += sales[product][day];
        }

        return total;
    }

    // 每日總量
    public static int calculateDayTotal(
            int[][] sales, int day) {

        int total = 0;

        for (int product = 0;
             product < sales.length;
             product++) {

            total += sales[product][day];
        }

        return total;
    }
}