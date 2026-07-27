class MS {
    int m;
    int s;

    public MS(int m0, int s0) {
        m = m0;
        s = s0;
        adj();
    }

    public void adj() {
        while (s >= 60) {
            m++;
            s -= 60;
        }

        while (s < 0) {
            m--;
            s += 60;
        }
    }

    @Override
    public String toString() {
        return m + "m" + s + "s";
    }
}

class HMS extends MS {
    int h;

    public HMS(int h0, int m0, int s0) {
        super(m0, s0);
        h = h0;
    }

    @Override
    public String toString() {
        return h + "h" + m + "m" + s + "s";
    }
}

public class AP32 {

    public static void testArray() {

        System.out.println("--- testArray ---");

        MS p1_ = new MS(5, 30);
        MS q1_ = new MS(5, 190);

        HMS p2 = new HMS(5, 50, 42);
        MS p2_ = new HMS(5, 50, 42);

        HMS p3 = new HMS(2, 20, 15);
        MS p3_ = new HMS(2, 20, 15);

        System.out.println("p1_:" + p1_);
        System.out.println("q1_:" + q1_);

        System.out.println("p2:" + p2);
        System.out.println("p2_:" + p2_);

        System.out.println("p3:" + p3);
        System.out.println("p3_:" + p3_);

        System.out.println();

        MS[] a = { p1_, q1_, p2_, p3_ };

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        testArray();
    }
}