public class TransactionSortingSystem {

    // Insertion Sort
    public static void insertionSort(
            Transaction[] transactions) {

        for (int i = 1; i < transactions.length; i++) {

            Transaction key = transactions[i];
            int j = i - 1;

            while (j >= 0
                    && shouldMove(transactions[j], key)) {

                transactions[j + 1] = transactions[j];
                j--;
            }

            transactions[j + 1] = key;
        }
    }

    // 是否需要往後移動
    public static boolean shouldMove(
            Transaction left,
            Transaction right) {

        // 金額降冪
        if (left.getAmount() < right.getAmount()) {
            return true;
        }

        // 金額相同，比時間序號
        if (left.getAmount() == right.getAmount()) {

            return left.getTimeOrder()
                    > right.getTimeOrder();
        }

        return false;
    }

    public static void displayTransactions(
            Transaction[] transactions) {

        System.out.println(
                "交易編號\t帳號\t金額\t時間序號");

        for (Transaction t : transactions) {

            System.out.println(
                    t.getTransactionId() + "\t"
                    + t.getAccount() + "\t"
                    + t.getAmount() + "\t"
                    + t.getTimeOrder());
        }
    }

    public static void main(String[] args) {

        Transaction[] transactions = {

            new Transaction(
                    "T001",
                    "A100",
                    5000,
                    3),

            new Transaction(
                    "T002",
                    "A200",
                    8000,
                    2),

            new Transaction(
                    "T003",
                    "A300",
                    5000,
                    1),

            new Transaction(
                    "T004",
                    "A400",
                    10000,
                    5),

            new Transaction(
                    "T005",
                    "A500",
                    6500,
                    4),

            new Transaction(
                    "T006",
                    "A600",
                    8000,
                    1),

            new Transaction(
                    "T007",
                    "A700",
                    5000,
                    2),

            new Transaction(
                    "T008",
                    "A800",
                    3000,
                    6)
        };

        System.out.println("=== 排序前 ===");
        displayTransactions(transactions);

        insertionSort(transactions);

        System.out.println("\n=== 排序後 ===");
        displayTransactions(transactions);
    }
}
