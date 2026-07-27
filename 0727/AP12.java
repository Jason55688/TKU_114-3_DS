class sMS {
    int m;
    int s;

    // 建構子
    public sMS(int m0, int s0) {
        m = m0;
        s = s0;
    }

    // 調整秒數到 0~59
    public static void adj(sMS p) {
        while (p.s >= 60) {
            p.m++;
            p.s -= 60;
        }

        while (p.s < 0) {
            p.m--;
            p.s += 60;
        }
    }

    // 增加時間
    public static void addS(sMS p, int dm, int ds) {
        p.m += dm;
        p.s += ds;
        adj(p);
    }

    // 秒數加一
    public static void incS(sMS p) {
        addS(p, 0, 1);
    }

    // 兩倍
    public static sMS mul2(sMS t1) {
        sMS ans = new sMS(t1.m * 2, t1.s * 2);
        adj(ans);
        return ans;
    }

    // 相加
    public static sMS add(sMS t1, sMS t2) {
        sMS ans = new sMS(t1.m + t2.m, t1.s + t2.s);
        adj(ans);
        return ans;
    }

    // 轉字串
    public static String toStr(sMS p) {
        return p.m + "m" + p.s + "s";
    }
}

public class AP12 {

    public static void main(String[] args) {

        // 1
        sMS p1 = new sMS(5, 30);
        System.out.println("p1:" + sMS.toStr(p1));

        // 2
        sMS.addS(p1, 0, 50);
        System.out.println("p1:" + sMS.toStr(p1));

        // 3
        sMS p2 = new sMS(2, 40);
        System.out.println(
                "p1:" + sMS.toStr(p1)
                + ", p2:" + sMS.toStr(p2));

        // 4
        p2 = sMS.mul2(p2);
        System.out.println(
                "p1:" + sMS.toStr(p1)
                + ", p2:" + sMS.toStr(p2));

        // 5
        sMS p3 = sMS.add(p1, p2);

        sMS.incS(p1);

        System.out.println(
                "p1:" + sMS.toStr(p1)
                + ", p2:" + sMS.toStr(p2)
                + ", p3:" + sMS.toStr(p3));
    }
}