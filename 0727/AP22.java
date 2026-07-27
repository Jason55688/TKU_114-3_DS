class MS {
    int m;
    int s;

    public MS(int m0, int s0) {
        m = m0;
        s = s0;
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

    public void addS(int dm, int ds) {
        m += dm;
        s += ds;
        adj();
    }

    public void incS() {
        addS(0, 1);
    }

    public MS mul2() {
        MS ans = new MS(m * 2, s * 2);
        ans.adj();
        return ans;
    }

    public MS add(MS t2) {
        MS ans = new MS(m + t2.m, s + t2.s);
        ans.adj();
        return ans;
    }

    @Override
    public String toString() {
        return m + "m" + s + "s";
    }
}

class HMS0 extends MS {
    int h;

    public HMS0(int h0, int m0, int s0) {
        super(m0, s0);
        h = h0;
    }

    @Override
    public String toString() {
        return h + "h" + m + "m" + s + "s";
    }
}

public class AP22 {

    public static void testArray() {

        System.out.println("--- testArray ---");

        MS p1 = new MS(5, 30);
        MS q1 = new MS(8, 10);

        HMS0 p2 = new HMS0(2, 50, 42);
        MS p2_ = new HMS0(2, 50, 42);

        HMS0 p3 = new HMS0(2, 20, 15);
        MS p3_ = new HMS0(2, 20, 15);

        System.out.println("p1:" + p1);
        System.out.println("q1:" + q1);
        System.out.println("p2:" + p2);
        System.out.println("p2_:" + p2_);
        System.out.println("p3:" + p3);
        System.out.println("p3_:" + p3_);

        MS[] a = { p1, q1, p2, p3 };

        System.out.println();

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        testArray();
    }
}