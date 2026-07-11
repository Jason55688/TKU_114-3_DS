import java.util.Scanner;

public class question10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalItems = 0;
        int totalAmount = 0;
        int option = -1;

        while (option != 0) {
            // 1. 顯示選單
            printMenu();
            option = sc.nextInt();

            if (option == 0) {
                System.out.println("謝謝光臨！");
                break;
            }

            // 根據選項取得價格與商品名稱
            int price = getPrice(option);
            String itemName = getItemName(option);

            // 如果回傳價格為 -1，代表輸入了無效選項
            if (price == -1) {
                System.out.println("無效的選項，請重新輸入！");
                continue;
            }

            System.out.println("您選擇了：" + itemName + " (單價: " + price + " 元)");

            // 2. 讀取合法數量
            int quantity = readValidQuantity(sc);

            // 3. 計算小計
            int subtotal = calculateSubtotal(price, quantity);
            System.out.println("此品項小計：" + subtotal + " 元");

            // 累加總數量與總金額
            totalItems += quantity;
            totalAmount += subtotal;
        }

        // 4. 印出收據
        printReceipt(totalItems, totalAmount);

        sc.close();
    }

    /**
     * 顯示選單
     */
    public static void printMenu() {
        System.out.println("\n=== 點餐系統選單 ===");
        System.out.println("1. 美式咖啡 (50元)");
        System.out.println("2. 拿鐵咖啡 (70元)");
        System.out.println("3. 起司蛋糕 (60元)");
        System.out.println("0. 結帳並離開");
        System.out.print("請輸入選項：");
    }

    /**
     * 根據選項回傳價格
     */
    public static int getPrice(int option) {
        switch (option) {
            case 1: return 50;
            case 2: return 70;
            case 3: return 60;
            default: return -1; // 無效選項
        }
    }

    /**
     * 根據選項回傳商品名稱
     */
    public static String getItemName(int option) {
        switch (option) {
            case 1: return "美式咖啡";
            case 2: return "拿鐵咖啡";
            case 3: return "起司蛋糕";
            default: return "未知商品";
        }
    }

    /**
     * 讀取合法數量（必須大於 0）
     */
    public static int readValidQuantity(Scanner sc) {
        System.out.print("請輸入購買數量：");
        int quantity = sc.nextInt();
        
        while (quantity <= 0) {
            System.out.print("數量必須大於 0，請重新輸入：");
            quantity = sc.nextInt();
        }
        return quantity;
    }

    /**
     * 計算小計
     */
    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    /**
     * 印出收據
     */
    public static void printReceipt(int totalItems, int totalAmount) {
        System.out.println("\n========================");
        System.out.println("       交易明細收據      ");
        System.out.println("========================");
        System.out.println("本次購買總件數：" + totalItems + " 件");
        System.out.println("應付總金額：" + totalAmount + " 元");
        System.out.println("========================");
        System.out.println("謝謝您的惠顧，歡迎下次光臨！");
    }
}