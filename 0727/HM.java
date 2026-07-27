class HM implements MTime {

    int h;
    int m;

    public HM(int h0, int m0) {
        h = h0;
        m = m0;
        adjust();
    }

    private void adjust() {

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
    public void reset() {
        h = 0;
        m = 0;
    }

    @Override
    public void addS(int ds) {

        // 以分鐘為單位處理
        m += ds / 60;

        adjust();
    }

    @Override
    public HM mul2() {

        return new HM(
                h * 2,
                m * 2
        );
    }

    @Override
    public HM add(MTime t2) {

        if (!(t2 instanceof HM)) {
            throw new Error(
                    "Not expected type:" + t2.getClass());
        }

        HM p = (HM) t2;

        return new HM(
                h + p.h,
                m + p.m
        );
    }

    @Override
    public String toString() {
        return h + "h" + m + "m";
    }
}