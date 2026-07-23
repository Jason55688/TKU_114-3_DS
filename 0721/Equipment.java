public class Equipment {

    private String id;
    private String name;
    private boolean available;

    public Equipment(String id, String name) {
        this.id = id.trim();
        this.name = name.trim();
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean borrow() {

        if (!available) {
            return false;
        }

        available = false;
        return true;
    }

    public boolean returnEquipment() {

        if (available) {
            return false;
        }

        available = true;
        return true;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | "
                + (available ? "可借用" : "已借出");
    }
}