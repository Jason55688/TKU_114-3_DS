import java.util.Scanner;

public class ProductDataManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] records = {
                "Keyboard,890,12",
                "Mouse,490,20",
                "Monitor,5200,5",
                "USB Cable,250,30",
                "Headset,1290,8"
        };

        String[] names = new String[records.length];
        int[] prices = new int[records.length];
        int[] stocks = new int[records.length];

        parseRecords(records, names, prices, stocks);

        displayProducts(names, prices, stocks);

        System.out.print("\n請輸入搜尋關鍵字：");
        String keyword = sc.nextLine();

        searchProducts(names, prices, stocks, keyword);

        showLowStock(names, stocks);

        System.out.println("\n庫存總價值：" +
                calculateInventoryValue(prices, stocks));

        System.out.print("\n請輸入新資料(Name,Price,Stock)：");
        String newRecord = sc.nextLine();

        validateRecord(newRecord);

        sc.close();
    }

    // 解析資料
    public static void parseRecords(
            String[] records,
            String[] names,
            int[] prices,
            int[] stocks) {

        for (int i = 0; i < records.length; i++) {

            String[] data = records[i].split(",");

            names[i] = data[0];
            prices[i] = Integer.parseInt(data[1]);
            stocks[i] = Integer.parseInt(data[2]);
        }
    }

    // 顯示商品
    public static void displayProducts(
            String[] names,
            int[] prices,
            int[] stocks) {

        System.out.println("商品名稱\t價格\t庫存");

        for (int i = 0; i < names.length; i++) {

            System.out.println(
                    names[i] + "\t" +
                    prices[i] + "\t" +
                    stocks[i]);
        }
    }

    // 商品搜尋
    public static void searchProducts(
            String[] names,
            int[] prices,
            int[] stocks,
            String keyword) {

        System.out.println("\n=== Search Result ===");

        boolean found = false;

        keyword = keyword.toLowerCase();

        for (int i = 0; i < names.length; i++) {

            if (names[i].toLowerCase().contains(keyword)) {

                System.out.println(
                        names[i] + "\t" +
                        prices[i] + "\t" +
                        stocks[i]);

                found = true;
            }
        }

        if (!found) {
            System.out.println("找不到資料");
        }
    }

    // 顯示低庫存
    public static void showLowStock(
            String[] names,
            int[] stocks) {

        System.out.println("\n=== Low Stock ===");

        for (int i = 0; i < stocks.length; i++) {

            if (stocks[i] < 10) {
                System.out.println(
                        names[i] + " : " + stocks[i]);
            }
        }
    }

    // 計算總價值
    public static int calculateInventoryValue(
            int[] prices,
            int[] stocks) {

        int total = 0;

        for (int i = 0; i < prices.length; i++) {
            total += prices[i] * stocks[i];
        }

        return total;
    }

    // 驗證資料格式
    public static void validateRecord(String record) {

        try {

            String[] data = record.split(",");

            if (data.length != 3) {
                System.out.println("格式錯誤：欄位數量不正確");
                return;
            }

            String name = data[0];
            int price = Integer.parseInt(data[1]);
            int stock = Integer.parseInt(data[2]);

            System.out.println("資料正確");
            System.out.println(
                    name + " " + price + " " + stock);

        } catch (NumberFormatException e) {

            System.out.println(
                    "格式錯誤：價格或庫存不是數字");

        } catch (Exception e) {

            System.out.println(
                    "格式錯誤：" + e.getMessage());
        }
    }
}