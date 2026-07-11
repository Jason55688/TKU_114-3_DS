import java.util.Scanner;

public class OrderSystemRefactor_demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalQuantity = 0;
        int totalAmount = 0;

        while (true) {

            printMenu();

            System.out.print("請輸入選項：");
            int option = sc.nextInt();

            if (option == 0) {
                printCheckout(totalQuantity, totalAmount);
                break;
            }

            int price = getPrice(option);

            if (price == 0) {
                System.out.println("無效選項！");
                continue;
            }

            int quantity = inputQuantity(sc);

            int subtotal = calculateSubtotal(price, quantity);

            totalQuantity += quantity;
            totalAmount += subtotal;

     