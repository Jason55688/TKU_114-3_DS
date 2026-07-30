package final_exam;
import java.util.ArrayList;

class Q12_Product {
    private String id;
    private String name;
    private int price;
    private int stock;

    public Q12_Product(
            String id,
            String name,
            int price,
            int stock
    ) {
        this.id = (id == null) ? "" : id.trim();
        this.name = (name == null) ? "" : name.trim();
        this.price = Math.max(0, price);
        this.stock = Math.max(0, stock);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return id + " " + name +
                " price=" + price +
                " stock=" + stock;
    }
}

public class Q12_InventoryCatalog {

    private ArrayList<Q12_Product> products = new ArrayList<>();

    public boolean addProduct(Q12_Product product) {
        if (product == null) {
            return false;
        }

        String id = product.getId();

        if (id == null || id.trim().isEmpty()) {
            return false;
        }

        for (Q12_Product existing : products) {
            if (existing.getId().equalsIgnoreCase(id)) {
                return false;
            }
        }

        products.add(product);
        return true;
    }

    public Q12_Product[] createSortedCopyById() {

        Q12_Product[] result =
                products.toArray(new Q12_Product[0]);

        if (result.length <= 1) {
            return result;
        }

        Q12_Product[] temp =
                new Q12_Product[result.length];

        mergeSort(
                result,
                temp,
                0,
                result.length - 1
        );

        return result;
    }

    private void mergeSort(
            Q12_Product[] data,
            Q12_Product[] temp,
            int left,
            int right
    ) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(data, temp, left, mid);
        mergeSort(data, temp, mid + 1, right);

        merge(data, temp, left, mid, right);
    }

    private void merge(
            Q12_Product[] data,
            Q12_Product[] temp,
            int left,
            int mid,
            int right
    ) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {

            if (data[i].getId()
                    .compareToIgnoreCase(
                            data[j].getId()) <= 0) {

                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = data[i++];
        }

        while (j <= right) {
            temp[k++] = data[j++];
        }

        for (int index = left;
             index <= right;
             index++) {

            data[index] = temp[index];
        }
    }

    public Q12_Product binarySearchById(
            Q12_Product[] sortedProducts,
            String id
    ) {
        if (sortedProducts == null || id == null) {
            return null;
        }

        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int compare =
                    sortedProducts[mid]
                            .getId()
                            .compareToIgnoreCase(id);

            if (compare == 0) {
                return sortedProducts[mid];
            }

            if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public ArrayList<Q12_Product> findByNameKeyword(
            String keyword
    ) {
        ArrayList<Q12_Product> result =
                new ArrayList<>();

        if (keyword == null ||
                keyword.trim().isEmpty()) {
            return result;
        }

        String target =
                keyword.toLowerCase();

        for (Q12_Product product : products) {

            if (product.getName()
                    .toLowerCase()
                    .contains(target)) {

                result.add(product);
            }
        }

        return result;
    }

    public ArrayList<Q12_Product> findLowStock(
            int maximumStock
    ) {
        ArrayList<Q12_Product> result =
                new ArrayList<>();

        for (Q12_Product product : products) {

            if (product.getStock()
                    <= maximumStock) {

                result.add(product);
            }
        }

        return result;
    }

    public int totalInventoryValue() {

        int total = 0;

        for (Q12_Product product : products) {
            total +=
                    product.getPrice()
                            * product.getStock();
        }

        return total;
    }
}

class Q12_InventoryDemo {

    public static void main(String[] args) {

        Q12_InventoryCatalog catalog =
                new Q12_InventoryCatalog();

        catalog.addProduct(
                new Q12_Product(
                        "P205",
                        "Wireless Mouse",
                        650,
                        4
                )
        );

        catalog.addProduct(
                new Q12_Product(
                        "P101",
                        "Keyboard",
                        1200,
                        8
                )
        );

        catalog.addProduct(
                new Q12_Product(
                        "P330",
                        "Gaming Mouse",
                        1800,
                        2
                )
        );

        catalog.addProduct(
                new Q12_Product(
                        "P150",
                        "Monitor",
                        5200,
                        5
                )
        );

        Q12_Product[] sorted =
                catalog.createSortedCopyById();

        System.out.println("依編號排序：");

        for (Q12_Product product : sorted) {
            System.out.println(product);
        }

        System.out.println(
                "查詢 P150：" +
                        catalog.binarySearchById(
                                sorted,
                                "p150"
                        )
        );

        System.out.println(
                "名稱包含 mouse：" +
                        catalog.findByNameKeyword(
                                "mouse"
                        )
        );

        System.out.println(
                "低庫存：" +
                        catalog.findLowStock(4)
        );

        System.out.println(
                "庫存總值：" +
                        catalog.totalInventoryValue()
        );
    }
}