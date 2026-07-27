public class AP41 {

    static void test_MTime() {

        System.out.println("\n--- test_MTime ---");

        MTime p1_ = new HMS(2, 5, 30);

        System.out.println("p1_:" + p1_);

        p1_.addS(3650);

        System.out.println("p1_:" + p1_);

        MTime p2_ = new HMS(5, 2, 40);

        System.out.println(
                "p1_:" + p1_
                + ", p2_:" + p2_);

        p2_ = p2_.mul2();

        System.out.println(
                "p1_:" + p1_
                + ", p2_:" + p2_);

        MTime p3_ = p1_.add(p2_);

        p1_.incS();

        System.out.println(
                "p1_:" + p1_
                + ", p2_:" + p2_
                + ", p3_:" + p3_);

        MTime p4 =
                p1_.add(p2_);

        MTime p5 =
                p1_.add((HMS) p2_);

        MTime p6 =
                ((HMS) p1_).add(p2_);

        MTime p7 =
                ((HMS) p1_).add((HMS) p2_);

        System.out.println(
                "p4:" + p4
                + ", p5_:" + p5
                + ", p6_:" + p6
                + ", p7_:" + p7);
    }

    public static void main(String[] args) {
        test_MTime();
    }
}