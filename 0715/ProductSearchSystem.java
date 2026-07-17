import java.util.Scanner;

public class ProductSearchSystem {

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

        displayProducts(names, prices, stocks);

        System.out.print("\n請輸入完整商品名稱：");
        String fullName = sc.nextLine();

        searchExact(names, prices, stocks, fullName);

        System.out.print("\n請輸入部分名稱：");
        String keyword = sc.nextLine();

        searchPartial(names, prices, stocks, keyword);

        System.out.println("\n最長商品名稱："
                + findLongestName(names));

        System.out.print("\n請輸入商品名稱：");
        String productName = sc.nextLine();

        System.out.print("請輸入查找字元：");
        char target = sc.nextLine().charAt(0);

        int index = findFirstChar(productName, target);

        if (index == -1) {
            System.out.println("找不到字元");
        } else {
            System.out.println("第一次出現位置：" + index);
        }

        sc.close();
    }

    // 顯示全部商品
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

    // 完整名稱搜尋
    public static void searchExact(
            String[] names,
            int[] prices,
            int[] stocks,
            String target) {

        for (int i = 0; i < names.length; i++) {

            if (names[i].equalsIgnoreCase(target)) {

                System.out.println("找到商品：");
                System.out.println("名稱：" + names[i]);
                System.out.println("價格：" + prices[i]);
                System.out.println("庫存：" + stocks[i]);
                return;
            }
        }

        System.out.println("找不到商品");
    }

    // 部分名稱搜尋
    public static void searchPartial(
            String[] names,
            int[] prices,
            int[] stocks,
            String keyword) {

        boolean found = false;

        keyword = keyword.toLowerCase();

        for (int i = 0; i < names.length; i++) {

            if (names[i].toLowerCase().contains(keyword)) {

                System.out.println(
                        names[i] + "  " +
                        prices[i] + "  " +
                        stocks[i]);

                found = true;
            }
        }

        if (!found) {
            System.out.println("找不到符合資料");
        }
    }

    // 找最長商品名稱
    public static String findLongestName(
            String[] names) {

        String longest = names[0];

        for (String name : names) {

            if (name.length() > longest.length()) {
                longest = name;
            }
        }

        return longest;
    }

    // 找字元第一次出現位置
    public static int findFirstChar(
            String text,
            char target) {

        return text
                .toLowerCase()
                .indexOf(
                        Character.toLowerCase(target));
    }
}