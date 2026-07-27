public class AP52 extends AP51 {

    static void step2() {

        System.out.println("\n--- step 2 ---");

        for (SLLNode_XY p = L1.head; p != null; p = p.next) {
            p.data.swap();
        }

        System.out.println("L1:" + L1);
    }

    public static void main(String[] args) {

        step1();

        step2();
    }
}