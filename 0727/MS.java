class MS implements MTime {

    protected int m;
    protected int s;

    public MS(int m0, int s0) {
        m = m0;
        s = s0;
        adjust();
    }

    protected void adjust() {
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
    public void reset() {
        m = 0;
        s = 0;
    }

    @Override
    public void addS(int ds) {
        s += ds;
        adjust();
    }

    @Override
    public MS mul2() {
        return new MS(m * 2, s * 2);
    }

    public MS add(MS t2) {
        return new MS(
                m + t2.m,
                s + t2.s);
    }

    @Override
    public MS add(MTime t2) {

        if (!(t2 instanceof MS)) {
            throw new Error(
                "Not expected type:" + t2.getClass());
        }

        return add((MS) t2);
    }

    @Override
    public String toString() {
        return m + "m" + s + "s";
    }
}
