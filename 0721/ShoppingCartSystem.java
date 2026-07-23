import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<CartItem> cart = new ArrayList<>();

        int option;

        do {

            printMenu();

            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:
                    addItem(sc, cart);
                    break;

                case 2:
                    updateItem(sc, cart);
                    break;

                case 3:
                    removeItem(sc, cart);
                    break;

                case 4:
                    displayCart(cart);
                    break;

                case 5:
                    System.out.printf(
                            "購物車總額：$%.2f%n",
                            calculateTotal(cart));
                    break;

                case 0:
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("無效選項！");
            }

            System.out.println();

        } while (option != 0);

        sc.close();
    }

    public static void printMenu() {

        System.out.println("=== Shopping Cart ===");
        System.out.println("1. 新增商品");
        System.out.println("2. 修改數量");
        System.out.println("3. 移除商品");
        System.out.println("4. 顯示購物車");
        System.out.println("5. 計算總額");
        System.out.println("0. 離開");
    }

    public static void addItem(
            Scanner sc,
            ArrayList<CartItem> cart) {

        System.out.print("商品代碼：");
        String id = sc.nextLine().trim();

        System.out.print("商品名稱：");
        String name = sc.nextLine().trim();

        System.out.print("單價：");
        double price = sc.nextDouble();

        System.out.print("數量：");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (quantity <= 0) {
            System.out.println("數量必須大於 0！");
            return;
        }

        CartItem item = findItem(cart, id);

        if (item != null) {

            item.addQuantity(quantity);

            System.out.println(
                    "商品已存在，已增加數量！");
            return;
        }

        cart.add(
                new CartItem(
                        id,
                        name,
                        price,
                        quantity));

        System.out.println("新增成功！");
    }

    public static void updateItem(
            Scanner sc,
            ArrayList<CartItem> cart) {

        System.out.print("商品代碼：");
        String id = sc.nextLine();

        CartItem item = findItem(cart, id);

        if (item == null) {
            System.out.println("找不到商品！");
            return;
        }

        System.out.print("新數量：");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (item.updateQuantity(quantity)) {
            System.out.println("修改成功！");
        } else {
            System.out.println("數量必須大於 0！");
        }
    }

    public static void removeItem(
            Scanner sc,
            ArrayList<CartItem> cart) {

        System.out.print("商品代碼：");
        String id = sc.nextLine();

        CartItem item = findItem(cart, id);

        if (item == null) {
            System.out.println("找不到商品！");
            return;
        }

        cart.remove(item);

        System.out.println("移除成功！");
    }

    public static void displayCart(
            ArrayList<CartItem> cart) {

        if (cart.isEmpty()) {
            System.out.println("購物車是空的！");
            return;
        }

        for (CartItem item : cart) {
            System.out.println(item);
        }
    }

    public static double calculateTotal(
            ArrayList<CartItem> cart) {

        double total = 0;

        for (CartItem item : cart) {
            total += item.getSubtotal();
        }

        return total;
    }

    public static CartItem findItem(
            ArrayList<CartItem> cart,
            String id) {

        for (CartItem item : cart) {

            if (item.getId()
                    .equalsIgnoreCase(id.trim())) {

                return item;
            }
        }

        return null;
    }
}