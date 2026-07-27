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

// 預備版 HMS
class HMS0 extends MS {
    int h;

    public HMS0(int h0, int m0, int s0) {
        super(m0, s0);
        h = h0;
    }
}

public class AP21 {

    public static void test_MS() {

        System.out.println("--- test_MS ---");

        MS p1 = new MS(5, 30);
        System.out.println("p1:" + p1);

        p1.addS(0, 50);
        System.out.println("p1:" + p1);

        MS p2 = new MS(2, 40);
        System.out.println("p1:" + p1 + ", p2:" + p2);

        p2 = p2.mul2();
        System.out.println("p1:" + p1 + ", p2:" + p2);

        MS p3 = p1.add(p2);

        p1.incS();

        System.out.println(
                "p1:" + p1
                + ", p2:" + p2
                + ", p3:" + p3);
    }

    public static void test_HMS0() {

        System.out.println();
        System.out.println("--- test_HMS0 ---");

        HMS0 p1 = new HMS0(2, 5, 30);
        System.out.println("p1:" + p1);

        p1.addS(0, 50);
        System.out.println("p1:" + p1);

        HMS0 p2 = new HMS0(2, 2, 40);
        System.out.println("p1:" + p1 + ", p2:" + p2);

        p2 = new HMS0(0, p2.mul2().m, p2.mul2().s);
        System.out.println("p1:" + p1 + ", p2:" + p2);

        MS p3 = p1.add(p2);

        p1.incS();

        System.out.println(
                "p1:" + p1
                + ", p2:" + p2
                + ", p3:" + p3);
    }

    public static void main(String[] args) {

        test_MS();
        test_HMS0();
    }
}