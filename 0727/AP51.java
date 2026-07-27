public class AP51 {

    static SLList_XY L1, L2;

    static void step1() {

        System.out.println("\n--- step 1 ---");

        XY[] data = {
                new XY(1, 9),
                new XY(2, 9),
                new XY(3, 9)
        };

        L1 = new SLList_XY(data);

        System.out.println("L1:" + L1);
    }

    public static void main(String[] args) {
        step1();
    }
}