public class SubtotalCalculator {

    public static void main(String[] args) {

        int subtotal1 = calculateSubtotal(30, 2);
        int subtotal2 = calculateSubtotal(50, 3);

        System.out.println("Subtotal 1: " + subtotal1);
        System.out.println("Subtotal 2: " + subtotal2);
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }
}