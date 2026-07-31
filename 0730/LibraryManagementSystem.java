import java.util.ArrayList;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        ArrayList<Book> books =
                new ArrayList<>();

        books.add(
                new Book("B005",
                        "Java Programming",
                        "Programming",
                        120));

        books.add(
                new Book("B001",
                        "Database Systems",
                        "Database",
                        80));

        books.add(
                new Book("B010",
                        "Data Structure",
                        "Programming",
                        150));

        books.add(
                new Book("B003",
                        "Network Security",
                        "Network",
                        95));

        books.add(
                new Book("B008",
                        "Operating System",
                        "System",
                        110));

        books.add(
                new Book("B002",
                        "Web Design",
                        "Programming",
                        60));

        books.add(
                new Book("B007",
                        "Cloud Computing",
                        "Network",
                        90));

        books.add(
                new Book("B004",
                        "AI Introduction",
                        "AI",
                        140));

        System.out.println("=== 原始書籍資料 ===");

        for (Book book : books) {
            System.out.println(book);
        }

        // Binary Search前先依編號排序
        BookAlgorithms.mergeSort(
                books,
                0,
                books.size() - 1);

        System.out.println(
                "\n=== 依編號排序後 ===");

        for (Book book : books) {
            System.out.println(book);
        }

        // Binary Search
        System.out.println(
                "\n=== 搜尋 B004 ===");

        int index =
                BookAlgorithms.binarySearch(
                        books,
                        "B004");

        if (index != -1) {

            System.out.println(
                    books.get(index));

        } else {

            System.out.println(
                    "找不到書籍");
        }

        // 找不到測試
        System.out.println(
                "\n=== 搜尋 B999 ===");

        int index2 =
                BookAlgorithms.binarySearch(
                        books,
                        "B999");

        if (index2 == -1) {
            System.out.println("找不到書籍");
        }

        // Sequential Search
        System.out.println(
                "\n=== Programming 類別 ===");

        BookAlgorithms.searchByCategory(
                books,
                "Programming");

        // 借閱次數排序
        BookAlgorithms.sortByBorrowCount(
                books);

        System.out.println(
                "\n=== 借閱次數排行榜 ===");

        for (Book book : books) {
            System.out.println(book);
        }

        // 空資料測試
        ArrayList<Book> emptyBooks =
                new ArrayList<>();

        System.out.println(
                "\n=== 空資料測試 ===");

        if (emptyBooks.isEmpty()) {
            System.out.println("目前沒有書籍資料");
        }
    }
}