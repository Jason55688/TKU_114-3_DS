public class AP53 extends AP52 {

    static void step3() {

        System.out.println("\n--- step 3 ---");

        // 1. 建立空串列
        L2 = new SLList_XY();

        // 2. 建立 tail
        SLLNode_XY tail;

        // 3. 先加入第一個節點
        L2.prepend(new XY(8, 11));

        tail = L2.head;

        // 4. 由尾端加入其餘節點
        for (int y = 12; y <= 14; y++) {

            XY v = new XY(8, y);

            L2.insAfter(tail, v);

            tail = tail.next;
        }

        // 5. 印出結果
        System.out.println("L2:" + L2);
    }

    public static void main(String[] args) {

        step1();

        step2();

        step3();
    }
}