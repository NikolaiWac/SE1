package exercises.Uebung_2;

public class EnduserCard implements PersonCard {
    private String firstName;
    private String lastName;
    private int id;
    private boolean hungry;

    public EnduserCard(int id, String firstName, String lastName, boolean hungry) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hungry = hungry;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getDisplayInfo() {
        return "ID = " + id +
                ", Vorname = " + firstName +
                ", Nachname = " + lastName +
                ", isHungry = " + hungry;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }
}
