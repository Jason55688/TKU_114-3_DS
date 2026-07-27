class HMS extends MS {

    int h;

    public HMS(int h0, int m0, int s0) {
        super(m0, s0);
        h = h0;
        adjustHM();
    }

    // 處理 h,m
    public void adjustHM() {

        while (m >= 60) {
            h++;
            m -= 60;
        }

        while (m < 0) {
            h--;
            m += 60;
        }
    }

    @Override
    public String toString() {
        return h + "h" + m + "m" + s + "s";
    }

    @Override
    public void reset() {
        h = 0;
        m = 0;
        s = 0;
    }

    @Override
    public void addS(int ds) {

        s += ds;

        while (s >= 60) {
            m++;
            s -= 60;
        }

        while (s < 0) {
            m--;
            s += 60;
        }

        adjustHM();
    }

    @Override
    public HMS mul2() {

        HMS ans = new HMS(
                h * 2,
                m * 2,
                s * 2);

        return ans;
    }

    @Override
    public HMS add(MS t2) {

        System.out.println("// execute HMS::add(MS).");

        HMS ans;

        if (t2 instanceof HMS) {

            HMS p = (HMS) t2;

            ans = new HMS(
                    h + p.h,
                    m + p.m,
                    s + p.s);

        } else {

            ans = new HMS(
                    h,
                    m + t2.m,
                    s + t2.s);
        }

        return ans;
    }

    // overload
    public HMS add(HMS t2) {

        System.out.println("// execute HMS::add(HMS).");

        return new HMS(
                h + t2.h,
                m + t2.m,
                s + t2.s);
    }
}