public class PricePrinter {

    public static void main(String[] args) {
        printItem("Black tea", 20);
        printItem("Green tea", 25);
        printItem("Coffee", 50);
    }

    public static void printItem(String itemName, int price) {
        System.out.println(itemName + " : $" + price);
    }
}