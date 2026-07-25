public class DeliveryTask {

    private String orderId;
    private String customerName;

    public DeliveryTask(String orderId, String customerName) {
        this.orderId = orderId.trim();
        this.customerName = customerName.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return orderId + " | " + customerName;
    }
}
``