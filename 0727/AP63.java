public class AP63 extends AP62 {

    static void step3() {

        System.out.println("\n--- step 3 ---");

        // 1. 建立空環狀串列
        L2 = new CLList_XY();

        // 3. 先加入第一個節點
        L2.append(new XY(8, 11));

        // 4. 由尾端加入其餘節點
        for (int y = 12; y <= 14; y++) {

            XY v = new XY(8, y);

            L2.append(v);
        }

        // 5. 印出 L2
        System.out.println("L2:" + L2);
    }

    public static void main(String[] args) {

        step1();

        step2();

        step3();
    }
}
