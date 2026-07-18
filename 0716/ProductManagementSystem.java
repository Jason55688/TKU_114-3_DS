import java.util.Scanner;

public class ProductManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[10];

        products[0] = new Product("Keyboard", 890, 12);
        products[1] = new Product("Mouse", 490, 20);
        products[2] = new Product("Monitor", 5200, 5);
        products[3] = new Product("USB Cable", 250, 30);
        products[4] = new Product("Headset", 1290, 8);

        int count = 5;

        int sellCount = 0;
        int restockCount = 0;

        int option;

        do {

            printMenu();

            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:
                    displayProducts(products, count);
                    break;

                case 2:
                    System.out.print("請輸入搜尋名稱：");
                    String keyword = sc.nextLine();

                    searchProduct(products, count, keyword);
                    break;

                case 3:
                    count = addProduct(sc, products, count);
                    break;

                case 4:
                    if (sellProduct(sc, products, count)) {
                        sellCount++;
                    }
                    break;

                case 5:
                    if (restockProduct(sc, products, count)) {
                        restockCount++;
                    }
                    break;

                case 6:
                    updatePrice(sc, products, count);
                    break;

                case 7:
                    showLowStock(products, count);
                    break;

                case 8:
                    System.out.println(
                            "庫存總價值："
                            + calculateInventoryValue(products, count));
                    break;

                case 0:
                    printSummary(
                            products,
                            count,
                            sellCount,
                            restockCount);
                    break;

                default:
                    System.out.println("無效選項");
            }

            System.out.println();

        } while (option != 0);

        sc.close();
    }

    public static void printMenu() {

        System.out.println("=== Product Management ===");
        System.out.println("1. 顯示全部商品");
        System.out.println("2. 搜尋商品");
        System.out.println("3. 新增商品");
        System.out.println("4. 出售商品");
        System.out.println("5. 補充庫存");
        System.out.println("6. 修改價格");
        System.out.println("7. 顯示低庫存");
        System.out.println("8. 顯示庫存總價值");
        System.out.println("0. 離開");
    }

    public static void displayProducts(
            Product[] products, int count) {

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }
    }

    public static void searchProduct(
            Product[] products,
            int count,
            String keyword) {

        keyword = keyword.trim().toLowerCase();

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (products[i].getName()
                    .toLowerCase()
                    .contains(keyword)) {

                System.out.println(products[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("找不到商品");
        }
    }

    public static int addProduct(
            Scanner sc,
            Product[] products,
            int count) {

        if (count >= products.length) {
            System.out.println("商品已滿");
            return count;
        }

        System.out.print("名稱：");
        String name = sc.nextLine().trim();

        for (int i = 0; i < count; i++) {

            if (products[i].getName()
                    .equalsIgnoreCase(name)) {

                System.out.println("商品名稱重複");
                return count;
            }
        }

        System.out.print("價格：");
        int price = sc.nextInt();

        System.out.print("庫存：");
        int stock = sc.nextInt();
        sc.nextLine();

        products[count] =
                new Product(name, price, stock);

        System.out.println("新增成功");

        return count + 1;
    }

    public static boolean sellProduct(
            Scanner sc,
            Product[] products,
            int count) {

        System.out.print("商品名稱：");
        String name = sc.nextLine();

        Product p = findProduct(products, count, name);

        if (p == null) {
            System.out.println("找不到商品");
            return false;
        }

        System.out.print("出售數量：");
        int qty = sc.nextInt();
        sc.nextLine();

        if (p.sell(qty)) {
            System.out.println("出售成功");
            return true;
        }

        System.out.println("庫存不足");
        return false;
    }

    public static boolean restockProduct(
            Scanner sc,
            Product[] products,
            int count) {

        System.out.print("商品名稱：");
        String name = sc.nextLine();

        Product p = findProduct(products, count, name);

        if (p == null) {
            System.out.println("找不到商品");
            return false;
        }

        System.out.print("補貨數量：");
        int qty = sc.nextInt();
        sc.nextLine();

        if (p.restock(qty)) {
            System.out.println("補貨成功");
            return true;
        }

        return false;
    }

    public static void updatePrice(
            Scanner sc,
            Product[] products,
            int count) {

        System.out.print("商品名稱：");
        String name = sc.nextLine();

        Product p = findProduct(products, count, name);

        if (p == null) {
            System.out.println("找不到商品");
            return;
        }

        System.out.print("新價格：");
        int price = sc.nextInt();
        sc.nextLine();

        if (p.setPrice(price)) {
            System.out.println("修改成功");
        } else {
            System.out.println("價格不合法");
        }
    }

    public static void showLowStock(
            Product[] products,
            int count) {

        for (int i = 0; i < count; i++) {

            if (products[i].isLowStock()) {
                System.out.println(products[i]);
            }
        }
    }

    public static long calculateInventoryValue(
            Product[] products,
            int count) {

        long total = 0;

        for (int i = 0; i < count; i++) {
            total += products[i].getInventoryValue();
        }

        return total;
    }

    public static Product findProduct(
            Product[] products,
            int count,
            String name) {

        for (int i = 0; i < count; i++) {

            if (products[i].getName()
                    .equalsIgnoreCase(name.trim())) {

                return products[i];
            }
        }

        return null;
    }

    public static void printSummary(
            Product[] products,
            int count,
            int sellCount,
            int restockCount) {

        System.out.println("=== Summary ===");
        System.out.println("商品數量：" + count);
        System.out.println("出售次數：" + sellCount);
        System.out.println("補貨次數：" + restockCount);
        System.out.println("庫存總價值："
                + calculateInventoryValue(products, count));
    }
}