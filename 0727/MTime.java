interface MTime {

    void reset();

    MTime mul2();

    void addS(int ds);

    MTime add(MTime t2);

    default void incS() {
        this.addS(1);
    }
}
