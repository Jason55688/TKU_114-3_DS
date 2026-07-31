public class RecursiveNameSearchPractice {

    // 遞迴搜尋
    public static int search(String[] names,
                             String target,
                             int index) {

        // Base Case：已搜尋到最後仍找不到
        if (index >= names.length) {
            return -1;
        }

        // 找到目標
        if (names[index].equals(target)) {
            return index;
        }

        // 遞迴搜尋下一個位置
        return search(names, target, index + 1);
    }

    public static void main(String[] args) {

        String[] names = {
                "Amy",
                "John",
                "Mary",
                "David",
                "Tom",
                "Lisa",
                "Kevin",
                "Emma"
        };

        // 第一筆
        System.out.println(
                "Amy -> "
                + search(names, "Amy", 0));

        // 中間資料
        System.out.println(
                "David -> "
                + search(names, "David", 0));

        // 最後一筆
        System.out.println(
                "Emma -> "
                + search(names, "Emma", 0));

        // 不存在
        System.out.println(
                "Peter -> "
                + search(names, "Peter", 0));
    }
}