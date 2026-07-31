public class ProductSortPractice {

    public static void insertionSort(Product[] products) {

        for (int i = 1; i < products.length; i++) {

            Product key = products[i];
            int j = i - 1;

            while (j >= 0
                    && products[j].getPrice()
                    > key.getPrice()) {

                products[j + 1] = products[j];
                j--;
            }

            products[j + 1] = key;
        }
    }

    public static void displayProducts(
            Product[] products) {

        System.out.println(
                "編號\t名稱\t價格\t庫存");

        for (Product p : products) {
            System.out.println(
                    p.getId() + "\t"
                    + p.getName() + "\t"
                    + p.getPrice() + "\t"
                    + p.getStock());
        }
    }

    public static void main(String[] args) {

        Product[] products = {

            new Product("P001",
                    "Keyboard", 890, 12),

            new Product("P002",
                    "Mouse", 490, 20),

            new Product("P003",
                    "Monitor", 5200, 5),

            new Product("P004",
                    "USB Cable", 250, 30),

            new Product("P005",
                    "Headset", 1290, 8),

            new Product("P006",
                    "Speaker", 490, 15),

            new Product("P007",
                    "Webcam", 890, 10),

            new Product("P008",
                    "SSD", 2500, 6)
        };

        System.out.println(
                "=== 排序前 ===");

        displayProducts(products);

        insertionSort(products);

        System.out.println(
                "\n=== 依價格升冪排序後 ===");

        displayProducts(products);
    }
}