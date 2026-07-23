public class CartItem {

    private String id;
    private String name;
    private double price;
    private int quantity;

    public CartItem(String id, String name,
                    double price, int quantity) {

        this.id = id.trim();
        this.name = name.trim();
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int qty) {
        quantity += qty;
    }

    public boolean updateQuantity(int qty) {

        if (qty <= 0) {
            return false;
        }

        quantity = qty;
        return true;
    }

    public double getSubtotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return id + " | " +
                name + " | $" +
                price + " | Qty: " +
                quantity + " | Subtotal: $" +
                getSubtotal();
    }
}