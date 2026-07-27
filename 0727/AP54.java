public class AP54 extends AP53 {

    static void step4() {

        System.out.println("\n--- step 4 ---");

        // 1. tail
        SLLNode_XY tail;

        // 2. 找到 L2 最末節點
        tail = L2.head;

        while (tail.next != null) {
            tail = tail.next;
        }

        // 3. 將 L1 資料接到 L2 尾端
        for (SLLNode_XY p = L1.head; p != null; p = p.next) {

            XY v = p.data;

            L2.insAfter(tail, v);

            tail = tail.next;
        }

        // 4. 印出 L2
        System.out.println("L2:" + L2);
    }

    public static void main(String[] args) {

        step1();

        step2();

        step3();

        step4();
    }
}