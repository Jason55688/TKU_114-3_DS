public class Contact {

    private String id;
    private String name;
    private String phone;
    private String email;

    public Contact(String id, String name,
                   String phone, String email) {

        this.id = id.trim();

        if (name == null || name.trim().isEmpty()) {
            this.name = "Unknown";
        } else {
            this.name = name.trim();
        }

        this.phone = phone.trim();
        this.email = email.trim();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone.trim();
    }

    @Override
    public String toString() {
        return id + " | "
                + name + " | "
                + phone + " | "
                + email;
    }
}
