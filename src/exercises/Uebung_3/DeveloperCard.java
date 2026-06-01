package exercises.Uebung_3;

import java.io.Serial;

public class DeveloperCard extends AbstractPersonCard {
    @Serial
    private static final long serialVersionUID = 1L;
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
    public int getId() {
        return super.getId();
    }

    @Override
    public String getDisplayInfo() {
        return super.toString() + ", genug koffeinisiert = " + enoughCoffee;
    }


}
