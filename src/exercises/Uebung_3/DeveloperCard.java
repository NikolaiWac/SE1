package exercises.Uebung_3;

public class DeveloperCard extends AbstractPersonCard {
    private static final long serialVersionID = 1L;
    private boolean enoughCoffee;

    public DeveloperCard(int id, String firstName, String lastName, boolean enoughCoffee) {
        super (id, firstName, lastName);
        this.enoughCoffee = enoughCoffee;
    }

    public boolean hasEnoughCoffee() {
        return enoughCoffee;
    }

    public void setEnoughCoffee(boolean enoughCoffee) {
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
        return this.serialID;
    }

    @Override
    public String getDisplayInfo() {
        return super.toString + ", genug koffeinisiert = " + enoughCoffee;
    }


}
