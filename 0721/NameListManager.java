import java.util.ArrayList;
import java.util.Scanner;

public class NameListManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        int option;

        do {

            printMenu();

            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:
                    addName(sc, names);
                    break;

                case 2:
                    searchName(sc, names);
                    break;

                case 3:
                    updateName(sc, names);
                    break;

                case 4:
                    removeName(sc, names);
                    break;

                case 5:
                    displayNames(names);
                    break;

                case 0:
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("無效選項！");
            }

            System.out.println();

        } while (option != 0);

        sc.close();
    }

    // 顯示選單
    public static void printMenu() {
        System.out.println("=== Name List Manager ===");
        System.out.println("1. 新增姓名");
        System.out.println("2. 搜尋姓名");
        System.out.println("3. 修改姓名");
        System.out.println("4. 刪除姓名");
        System.out.println("5. 顯示全部姓名");
        System.out.println("0. 離開");
    }

    // 新增姓名
    public static void addName(
            Scanner sc,
            ArrayList<String> names) {

        System.out.print("請輸入姓名：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("姓名不可為空白！");
            return;
        }

        names.add(name);
        System.out.println("新增成功！");
    }

    // 搜尋姓名
    public static void searchName(
            Scanner sc,
            ArrayList<String> names) {

        System.out.print("請輸入姓名：");
        String keyword = sc.nextLine().trim();

        boolean found = false;

        for (String name : names) {

            if (name.equalsIgnoreCase(keyword)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("找到姓名！");
        } else {
            System.out.println("找不到姓名！");
        }
    }

    // 修改姓名
    public static void updateName(
            Scanner sc,
            ArrayList<String> names) {

        System.out.print("原姓名：");
        String oldName = sc.nextLine().trim();

        for (int i = 0; i < names.size(); i++) {

            if (names.get(i).equalsIgnoreCase(oldName)) {

                System.out.print("新姓名：");
                String newName = sc.nextLine().trim();

                if (newName.isEmpty()) {
                    System.out.println("姓名不可為空白！");
                    return;
                }

                names.set(i, newName);
                System.out.println("修改成功！");
                return;
            }
        }

        System.out.println("找不到姓名！");
    }

    // 刪除姓名
    public static void removeName(
            Scanner sc,
            ArrayList<String> names) {

        System.out.print("請輸入姓名：");
        String target = sc.nextLine().trim();

        for (int i = 0; i < names.size(); i++) {

            if (names.get(i).equalsIgnoreCase(target)) {

                names.remove(i);
                System.out.println("刪除成功！");
                return;
            }
        }

        System.out.println("找不到姓名！");
    }

    // 顯示全部姓名
    public static void displayNames(
            ArrayList<String> names) {

        if (names.isEmpty()) {
            System.out.println("目前沒有資料！");
            return;
        }

        System.out.println("=== Name List ===");

        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }
    }
}