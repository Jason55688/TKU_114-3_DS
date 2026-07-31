import java.util.ArrayList;

public class BookAlgorithms {

    // Merge Sort
    public static void mergeSort(
            ArrayList<Book> books,
            int left,
            int right) {

        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(books, left, mid);
        mergeSort(books, mid + 1, right);

        merge(books, left, mid, right);
    }

    // 編號升冪 + 借閱次數降冪
    private static void merge(
            ArrayList<Book> books,
            int left,
            int mid,
            int right) {

        ArrayList<Book> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {

            Book b1 = books.get(i);
            Book b2 = books.get(j);

            if (b1.getBookId()
                    .compareTo(b2.getBookId()) < 0) {

                temp.add(b1);
                i++;

            } else {

                temp.add(b2);
                j++;
            }
        }

        while (i <= mid) {
            temp.add(books.get(i++));
        }

        while (j <= right) {
            temp.add(books.get(j++));
        }

        for (int k = 0; k < temp.size(); k++) {
            books.set(left + k, temp.get(k));
        }
    }

    // Binary Search
    public static int binarySearch(
            ArrayList<Book> books,
            String targetId) {

        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int compare =
                    books.get(mid)
                            .getBookId()
                            .compareTo(targetId);

            if (compare == 0) {
                return mid;
            }

            if (compare > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    // Sequential Search
    public static void searchByCategory(
            ArrayList<Book> books,
            String category) {

        boolean found = false;

        for (Book book : books) {

            if (book.getCategory()
                    .equalsIgnoreCase(category)) {

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("找不到分類資料");
        }
    }

    // 借閱次數排序(降冪)
    public static void sortByBorrowCount(
            ArrayList<Book> books) {

        for (int i = 1; i < books.size(); i++) {

            Book key = books.get(i);
            int j = i - 1;

            while (j >= 0
                    && books.get(j).getBorrowCount()
                    < key.getBorrowCount()) {

                books.set(j + 1, books.get(j));
                j--;
            }

            books.set(j + 1, key);
        }
    }
}