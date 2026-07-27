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

    // 取代 toStr()
    @Override
    public String toString() {
        return m + "m" + s + "s";
    }
}

public class AP14 {

    public static void main(String[] args) {

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
            "p1:" + p1 +
            ", p2:" + p2 +
            ", p3:" + p3
        );
    }
}