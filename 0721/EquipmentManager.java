import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Equipment> equipments = new ArrayList<>();

        equipments.add(new Equipment("E001", "Laptop"));
        equipments.add(new Equipment("E002", "Projector"));
        equipments.add(new Equipment("E003", "Camera"));

        int option;

        do {

            printMenu();

            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:
                    listEquipments(equipments);
                    break;

                case 2:
                    searchEquipment(sc, equipments);
                    break;

                case 3:
                    borrowEquipment(sc, equipments);
                    break;

                case 4:
                    returnEquipment(sc, equipments);
                    break;

                case 0:
                    System.out.println("系統結束");
                    break;

                default:
                    System.out.println("無效選項");
            }

            System.out.println();

        } while (option != 0);

        sc.close();
    }

    public static void printMenu() {

        System.out.println("=== Equipment Manager ===");
        System.out.println("1. 顯示全部設備");
        System.out.println("2. 搜尋設備");
        System.out.println("3. 借出設備");
        System.out.println("4. 歸還設備");
        System.out.println("0. 離開");
    }

    public static void listEquipments(
            ArrayList<Equipment> equipments) {

        for (Equipment e : equipments) {
            System.out.println(e);
        }
    }

    public static void searchEquipment(
            Scanner sc,
            ArrayList<Equipment> equipments) {

        System.out.print("輸入設備編號或名稱：");
        String keyword = sc.nextLine().trim().toLowerCase();

        boolean found = false;

        for (Equipment e : equipments) {

            if (e.getId().toLowerCase().contains(keyword)
                    || e.getName().toLowerCase().contains(keyword)) {

                System.out.println(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println("找不到設備");
        }
    }

    public static void borrowEquipment(
            Scanner sc,
            ArrayList<Equipment> equipments) {

        System.out.print("輸入設備編號：");
        String id = sc.nextLine().trim();

        Equipment equipment =
                findEquipment(equipments, id);

        if (equipment == null) {
            System.out.println("找不到設備");
            return;
        }

        if (equipment.borrow()) {
            System.out.println("借出成功");
        } else {
            System.out.println("設備已借出");
        }
    }

    public static void returnEquipment(
            Scanner sc,
            ArrayList<Equipment> equipments) {

        System.out.print("輸入設備編號：");
        String id = sc.nextLine().trim();

        Equipment equipment =
                findEquipment(equipments, id);

        if (equipment == null) {
            System.out.println("找不到設備");
            return;
        }

        if (equipment.returnEquipment()) {
            System.out.println("歸還成功");
        } else {
            System.out.println("設備原本就在庫");
        }
    }

    public static Equipment findEquipment(
            ArrayList<Equipment> equipments,
            String id) {

        for (Equipment e : equipments) {

            if (e.getId().equalsIgnoreCase(id)) {
                return e;
            }
        }

        return null;
    }
}