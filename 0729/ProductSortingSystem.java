public class ProductSortingSystem {

    // 複製陣列
    public static StoreProduct[] copyProducts(
            StoreProduct[] original) {

        StoreProduct[] copy =
                new StoreProduct[original.length];

        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }

        return copy;
    }

    // 價格升冪排序
    public static void sortPriceAscending(
            StoreProduct[] products) {

        for (int i = 1; i < products.length; i++) {

            StoreProduct key = products[i];
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

    // 價格降冪排序
    public static void sortPriceDescending(
            StoreProduct[] products) {

        for (int i = 1; i < products.length; i++) {

            StoreProduct key = products[i];
            int j = i - 1;

            while (j >= 0
                    && products[j].getPrice()
                    < key.getPrice()) {

                products[j + 1] = products[j];
                j--;
            }

            products[j + 1] = key;
        }
    }

    // 顯示商品
    public static void displayProducts(
            StoreProduct[] products,
            String title) {

        System.out.println("\n=== " + title + " ===");

        System.out.println(
                "編號\t名稱\t價格\t庫存");

        for (StoreProduct p : products) {

            System.out.println(
                    p.getId() + "\t"
                    + p.getName() + "\t"
                    + p.getPrice() + "\t"
                    + p.getStock());
        }
    }

    public static void main(String[] args) {

        StoreProduct[] original = {

                new StoreProduct("P001",
                        "Keyboard", 890, 12),

                new StoreProduct("P002",
                        "Mouse", 490, 20),

                new StoreProduct("P003",
                        "Monitor", 5200, 5),

                new StoreProduct("P004",
                        "USB Cable", 250, 30),

                new StoreProduct("P005",
                        "Headset", 1290, 8),

                new StoreProduct("P006",
                        "Speaker", 990, 10),

                new StoreProduct("P007",
                        "SSD", 2500, 6),

                new StoreProduct("P008",
                        "Webcam", 890, 15),

                new StoreProduct("P009",
                        "Microphone", 1590, 7),

                new StoreProduct("P010",
                        "Power Bank", 690, 18)
        };

        displayProducts(
                original,
                "原始資料");

        StoreProduct[] asc =
                copyProducts(original);

        sortPriceAscending(asc);

        displayProducts(
                asc,
                "價格升冪排序");

        StoreProduct[] desc =
                copyProducts(original);

        sortPriceDescending(desc);

        displayProducts(
                desc,
                "價格降冪排序");
    }
}