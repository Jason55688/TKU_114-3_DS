public class AP62 extends AP61 {

    static void step2() {

        System.out.println("\n--- step 2 ---");

        if (L1.tail != null) {

            Node_XY p = L1.tail.next; // 首節點

            do {

                p.data.swap();

                p = p.next;

            } while (p != L1.tail.next);
        }

        System.out.println("L1:" + L1);
    }

    public static void main(String[] args) {

        step1();

        step2();
    }
}