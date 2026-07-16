import java.util.Scanner;

public class ProductArraySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] names = {
                "Keyboard",
                "Mouse",
                "Monitor",
                "USB Cable",
                "Headset"
        };

        int[] prices = {
                890,
                490,
                5200,
                250,
                1290
        };

        int[] stocks = {
                12,
                20,
                5,
                30,
                8
        };

        int purchaseCount = 0;
        int restockCount = 0;

        int option;

        do {

            printMenu();

            System.out.print("請輸入選項：");
            option = sc.nextInt();

            switch (option) {

                case 1:
                    displayProducts(names, prices, stocks);
                    break;

                case 2:
                    System.out.print("請輸入商品編號：");
                    int searchId = sc.nextInt();

                    searchProduct(names, prices, stocks, searchId);
                    break;

                case 3:
                    purchaseProduct(sc, names, stocks);
                    purchaseCount++;
                    break;

                case 4:
                    restockProduct(sc, names, stocks);
                    restockCount++;
                    break;

                case 5:
                    showLowStock(names, stocks);
                    break;

                case 6:
                    System.out.println(
                            "總庫存價值：" +
                            calculateInventoryValue(prices, stocks));
                    break;

                case 0:
                    printSummary(
                            purchaseCount,
                            restockCount,
                            calculateInventoryValue(prices, stocks));
                    break;

                default:
                    System.out.println("無效選項！");
            }

            System.out.println();

        } while (option != 0);

        sc.close();
    }

    public static void printMenu() {

        System.out.println("=== Product Menu ===");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 商品查詢");
        System.out.println("3. 購買商品");
        System.out.println("4. 補充庫存");
        System.out.println("5. 顯示低庫存");
        System.out.println("6. 顯示總庫存價值");
        System.out.println("0. 離開");
    }

    public static void displayProducts(
            String[] names,
            int[] prices,
            int[] stocks) {

        System.out.println("編號\t商品\t\t價格\t庫存");

        for (int i = 0; i < names.length; i++) {

            System.out.println(
                    (i + 1) + "\t" +
                    names[i] + "\t" +
                    prices[i] + "\t" +
                    stocks[i]);
        }
    }

    public static void searchProduct(
            String[] names,
            int[] prices,
            int[] stocks,
            int id) {

        if (id < 1 || id > names.length) {
            System.out.println("查無商品！");
            return;
        }

        int index = id - 1;

        System.out.println("商品：" + names[index]);
        System.out.println("價格：" + prices[index]);
        System.out.println("庫存：" + stocks[index]);
    }

    public static void purchaseProduct(
            Scanner sc,
            String[] names,
            int[] stocks) {

        System.out.print("商品編號：");
        int id = sc.nextInt();

        if (id < 1 || id > names.length) {
            System.out.println("查無商品！");
            return;
        }

        int index = id - 1;

        System.out.print("購買數量：");
        int qty = sc.nextInt();

        if (qty <= 0 || qty > stocks[index]) {
            System.out.println("數量不合法！");
            return;
        }

        stocks[index] -= qty;

        System.out.println(
                names[index] + " 購買成功！");
    }

    public static void restockProduct(
            Scanner sc,
            String[] names,
            int[] stocks) {

        System.out.print("商品編號：");
        int id = sc.nextInt();

        if (id < 1 || id > names.length) {
            System.out.println("查無商品！");
            return;
        }

        int index = id - 1;

        System.out.print("補貨數量：");
        int qty = sc.nextInt();

        if (qty <= 0) {
            System.out.println("數量不合法！");
            return;
        }

        stocks[index] += qty;

        System.out.println(
                names[index] + " 補貨成功！");
    }

    public static void showLowStock(
            String[] names,
            int[] stocks) {

        System.out.println("=== Low Stock ===");

        for (int i = 0; i < stocks.length; i++) {

            if (stocks[i] < 10) {

                System.out.println(
                        names[i] + " : " + stocks[i]);
            }
        }
    }

    public static int calculateInventoryValue(
            int[] prices,
            int[] stocks) {

        int total = 0;

        for (int i = 0; i < prices.length; i++) {
            total += prices[i] * stocks[i];
        }

        return total;
    }

    public static void printSummary(
            int purchaseCount,
            int restockCount,
            int inventoryValue) {

        System.out.println("=== Summary ===");
        System.out.println("購買次數：" + purchaseCount);
        System.out.println("補貨次數：" + restockCount);
        System.out.println("庫存總價值：" + inventoryValue);
    }
}