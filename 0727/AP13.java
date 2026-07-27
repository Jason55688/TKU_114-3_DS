class MS {
    int m;
    int s;

    // 建構子
    public MS(int m0, int s0) {
        m = m0;
        s = s0;
    }

    // 調整秒數
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

    // 增加時間
    public void addS(int dm, int ds) {
        m += dm;
        s += ds;
        adj();
    }

    // 秒數加一
    public void incS() {
        addS(0, 1);
    }

    // 回傳兩倍時間
    public MS mul2() {
        MS ans = new MS(m * 2, s * 2);
        ans.adj();
        return ans;
    }

    // 與另一個物件相加
    public MS add(MS t2) {
        MS ans = new MS(m + t2.m, s + t2.s);
        ans.adj();
        return ans;
    }

    // 轉字串
    public String toStr() {
        return m + "m" + s + "s";
    }
}

public class AP13 {

    public static void main(String[] args) {

        // 1
        MS p1 = new MS(5, 30);
        System.out.println("p1:" + p1.toStr());

        // 2
        p1.addS(0, 50);
        System.out.println("p1:" + p1.toStr());

        // 3
        MS p2 = new MS(2, 40);
        System.out.println(
                "p1:" + p1.toStr()
                        + ", p2:" + p2.toStr());

        // 4
        p2 = p2.mul2();
        System.out.println(
                "p1:" + p1.toStr()
                        + ", p2:" + p2.toStr());

        // 5
        MS p3 = p1.add(p2);

        p1.incS();

        System.out.println(
                "p1:" + p1.toStr()
                        + ", p2:" + p2.toStr()
                        + ", p3:" + p3.toStr());
    }
}