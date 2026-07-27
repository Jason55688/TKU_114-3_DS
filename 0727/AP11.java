class sMS {
    int m;
    int s;

    // 建構子
    public sMS(int m0, int s0) {
        this.m = m0;
        this.s = s0;
    }

    // 將 p 增加 dm 分 ds 增加
    public static void addS(sMS p, int dm, int ds) {
        p.m += dm;
        p.s += ds;
    }

    // 秒數加 1
    public static void incS(sMS p) {
        addS(p, 0, 1);
    }

    // 回傳字串格式
    public static String toStr(sMS p) {
        return p.m + "m" + p.s + "s";
    }
}

public class AP11 {

    public static void main(String[] args) {

        // 建立物件
        sMS p1 = new sMS(5, 30);

        // 印出初始值
        System.out.print(sMS.toStr(p1));

        // 秒數加 1
        sMS.incS(p1);

        // 再印出
        System.out.print(sMS.toStr(p1));
    }
}