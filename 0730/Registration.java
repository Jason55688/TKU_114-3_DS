public class Registration {

    private String registrationId;
    private String name;
    private boolean confirmed;

    public Registration(String registrationId,
                        String name,
                        boolean confirmed) {

        this.registrationId = registrationId;
        this.name = name;
        this.confirmed = confirmed;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public String getName() {
        return name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    @Override
    public String toString() {

        return registrationId + " | "
                + name + " | "
                + (confirmed ? "Confirmed" : "Waiting");
    }
}