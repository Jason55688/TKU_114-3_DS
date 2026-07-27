public class AP64 extends AP63 {

    static void step4() {

        System.out.println("\n--- step 4 ---");

        // 1. p 指向 L1 的首節點
        Node_XY p = L1.tail.next;

        // 2. 將 L1 所有資料加入 L2 尾端
        do {

            L2.append(p.data);

            p = p.next;

        } while (p != L1.tail.next);

        // 3. 印出結果
        System.out.println("L2:" + L2);
    }

    public static void main(String[] args) {

        step1();

        step2();

        step3();

        step4();
    }
}