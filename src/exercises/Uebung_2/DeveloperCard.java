package exercises.Uebung_2;

public class DeveloperCard implements PersonCard {
    private String firstName;
    private String lastName;
    private int id;
    private boolean enoughCoffee;

    public DeveloperCard(int id, String firstName, String lastName, boolean enoughCoffee) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enoughCoffee = enoughCoffee;
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
                ", hasEnoughCoffee = " + enoughCoffee;
    }

    public boolean hasEnoughCoffee() {
        return enoughCoffee;
    }

    public void setEnoughCoffee(boolean enoughCoffee) {
        this.enoughCoffee = enoughCoffee;
    }
}
