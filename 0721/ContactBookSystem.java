import java.util.ArrayList;
import java.util.Scanner;

public class ContactBookSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Contact> contacts = new ArrayList<>();

        contacts.add(
                new Contact(
                        "C001",
                        "Amy",
                        "0912345678",
                        "amy@gmail.com"));

        contacts.add(
                new Contact(
                        "C002",
                        "John",
                        "0922333444",
                        "john@gmail.com"));

        int option;

        do {

            printMenu();

            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:
                    addContact(sc, contacts);
                    break;

                case 2:
                    searchContact(sc, contacts);
                    break;

                case 3:
                    updatePhone(sc, contacts);
                    break;

                case 4:
                    removeContact(sc, contacts);
                    break;

                case 5:
                    displayContacts(contacts);
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

        System.out.println("=== Contact Book ===");
        System.out.println("1. 新增聯絡人");
        System.out.println("2. 搜尋聯絡人");
        System.out.println("3. 修改電話");
        System.out.println("4. 刪除聯絡人");
        System.out.println("5. 顯示全部聯絡人");
        System.out.println("0. 離開");
    }

    // 新增聯絡人
    public static void addContact(
            Scanner sc,
            ArrayList<Contact> contacts) {

        System.out.print("代碼：");
        String id = sc.nextLine().trim();

        for (Contact c : contacts) {
            if (c.getId().equalsIgnoreCase(id)) {
                System.out.println("代碼不可重複！");
                return;
            }
        }

        System.out.print("姓名：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("姓名不可空白！");
            return;
        }

        System.out.print("電話：");
        String phone = sc.nextLine();

        System.out.print("Email：");
        String email = sc.nextLine();

        contacts.add(
                new Contact(
                        id,
                        name,
                        phone,
                        email));

        System.out.println("新增成功！");
    }

    // 搜尋聯絡人
    public static void searchContact(
            Scanner sc,
            ArrayList<Contact> contacts) {

        System.out.print("請輸入姓名：");
        String keyword =
                sc.nextLine().trim().toLowerCase();

        boolean found = false;

        for (Contact c : contacts) {

            if (c.getName()
                    .toLowerCase()
                    .contains(keyword)) {

                System.out.println(c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("找不到聯絡人！");
        }
    }

    // 修改電話
    public static void updatePhone(
            Scanner sc,
            ArrayList<Contact> contacts) {

        System.out.print("請輸入姓名：");
        String name = sc.nextLine();

        Contact contact =
                findContact(contacts, name);

        if (contact == null) {
            System.out.println("找不到聯絡人！");
            return;
        }

        System.out.print("新電話：");
        String phone = sc.nextLine();

        contact.setPhone(phone);

        System.out.println("修改成功！");
    }

    // 刪除聯絡人
    public static void removeContact(
            Scanner sc,
            ArrayList<Contact> contacts) {

        System.out.print("請輸入姓名：");
        String name = sc.nextLine();

        Contact contact =
                findContact(contacts, name);

        if (contact == null) {
            System.out.println("找不到聯絡人！");
            return;
        }

        contacts.remove(contact);

        System.out.println("刪除成功！");
    }

    // 顯示全部聯絡人
    public static void displayContacts(
            ArrayList<Contact> contacts) {

        if (contacts.isEmpty()) {
            System.out.println("沒有資料！");
            return;
        }

        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    // 尋找聯絡人
    public static Contact findContact(
            ArrayList<Contact> contacts,
            String name) {

        for (Contact c : contacts) {

            if (c.getName()
                    .equalsIgnoreCase(name.trim())) {

                return c;
            }
        }

        return null;
    }
}