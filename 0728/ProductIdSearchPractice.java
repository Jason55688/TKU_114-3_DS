import java.util.Scanner;

public class ProductIdSearchPractice {

    // 循序搜尋
    public static int linearSearch(int[] ids, int target) {

        int comparisons = 0;

        for (int i = 0; i < ids.length; i++) {

            comparisons++;

            if (ids[i] == target) {
                System.out.println("比較次數：" + comparisons);
                return i;
            }
        }

        System.out.println("比較次數：" + comparisons);
        return -1;
    }

    public static void main(String[] args) {

        // 至少 8 筆未排序資料
        int[] productIds = {
                105, 201, 88, 450,
                312, 999, 123, 567
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入要搜尋的商品編號：");
        int target = sc.nextInt();

        int index = linearSearch(productIds, target);

        if (index != -1) {
            System.out.println(
                    "找到商品，索引位置：" + index);
        } else {
            System.out.println(
                    "找不到商品編號！");
        }

        sc.close();
    }
}