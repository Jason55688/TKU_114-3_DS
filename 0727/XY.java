class XY {
    int x;
    int y;

    XY(int x0, int y0) {
        this.x = x0;
        this.y = y0;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    void swap() {
        int t = this.x;
        this.x = this.y;
        this.y = t;
    }
}