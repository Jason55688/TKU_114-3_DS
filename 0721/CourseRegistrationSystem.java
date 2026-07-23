import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Course> courses = new ArrayList<>();

        courses.add(new Course("CS101", "Java", 3, 1));
        courses.add(new Course("CS102", "Database", 2, 0));
        courses.add(new Course("CS103", "Web Design", 4, 2));

        int option;

        do {

            printMenu();

            System.out.print("請輸入選項：");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:
                    addCourse(sc, courses);
                    break;

                case 2:
                    registerCourse(sc, courses);
                    break;

                case 3:
                    withdrawCourse(sc, courses);
                    break;

                case 4:
                    removeCourse(sc, courses);
                    break;

                case 5:
                    searchCourse(sc, courses);
                    break;

                case 6:
                    displayCourses(courses);
                    break;

                case 7:
                    showStatistics(courses);
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

    // 選單
    public static void printMenu() {

        System.out.println("=== Course Registration System ===");
        System.out.println("1. 新增課程");
        System.out.println("2. 選課");
        System.out.println("3. 退選");
        System.out.println("4. 刪除課程");
        System.out.println("5. 搜尋課程");
        System.out.println("6. 顯示全部課程");
        System.out.println("7. 顯示統計");
        System.out.println("0. 離開");
    }

    // 新增課程
    public static void addCourse(
            Scanner sc,
            ArrayList<Course> courses) {

        System.out.print("課程代碼：");
        String id = sc.nextLine().trim();

        for (Course c : courses) {
            if (c.getId().equalsIgnoreCase(id)) {
                System.out.println("課程代碼不可重複！");
                return;
            }
        }

        System.out.print("課程名稱：");
        String name = sc.nextLine().trim();

        System.out.print("容量：");
        int capacity = sc.nextInt();
        sc.nextLine();

        courses.add(
                new Course(id, name, capacity, 0));

        System.out.println("新增成功！");
    }

    // 選課
    public static void registerCourse(
            Scanner sc,
            ArrayList<Course> courses) {

        System.out.print("課程代碼：");
        String id = sc.nextLine();

        Course course = findCourse(courses, id);

        if (course == null) {
            System.out.println("找不到課程！");
            return;
        }

        if (course.register()) {
            System.out.println("選課成功！");
        } else {
            System.out.println("課程已額滿！");
        }
    }

    // 退選
    public static void withdrawCourse(
            Scanner sc,
            ArrayList<Course> courses) {

        System.out.print("課程代碼：");
        String id = sc.nextLine();

        Course course = findCourse(courses, id);

        if (course == null) {
            System.out.println("找不到課程！");
            return;
        }

        if (course.withdraw()) {
            System.out.println("退選成功！");
        } else {
            System.out.println("目前無人選課！");
        }
    }

    // 刪除課程
    public static void removeCourse(
            Scanner sc,
            ArrayList<Course> courses) {

        System.out.print("課程代碼：");
        String id = sc.nextLine();

        Course course = findCourse(courses, id);

        if (course == null) {
            System.out.println("找不到課程！");
            return;
        }

        courses.remove(course);

        System.out.println("刪除成功！");
    }

    // 搜尋課程
    public static void searchCourse(
            Scanner sc,
            ArrayList<Course> courses) {

        System.out.print("請輸入關鍵字：");
        String keyword =
                sc.nextLine().trim().toLowerCase();

        boolean found = false;

        for (Course c : courses) {

            if (c.getId().toLowerCase().contains(keyword)
                    || c.getName().toLowerCase().contains(keyword)) {

                System.out.println(c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("找不到課程！");
        }
    }

    // 顯示全部
    public static void displayCourses(
            ArrayList<Course> courses) {

        if (courses.isEmpty()) {
            System.out.println("沒有課程資料！");
            return;
        }

        for (Course c : courses) {
            System.out.println(c);
        }
    }

    // 統計資訊
    public static void showStatistics(
            ArrayList<Course> courses) {

        int totalCourses = courses.size();
        int totalStudents = 0;
        int fullCourses = 0;

        for (Course c : courses) {

            totalStudents += c.getEnrolled();

            if (c.isFull()) {
                fullCourses++;
            }
        }

        System.out.println("總課程數：" + totalCourses);
        System.out.println("總選課人數：" + totalStudents);
        System.out.println("額滿課程數：" + fullCourses);
    }

    // 尋找課程
    public static Course findCourse(
            ArrayList<Course> courses,
            String id) {

        for (Course c : courses) {

            if (c.getId().equalsIgnoreCase(id.trim())) {
                return c;
            }
        }

        return null;
    }
}
