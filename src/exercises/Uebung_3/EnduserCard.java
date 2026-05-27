

public class EnduserCard extends AbstractPersonCard {
    private boolean hungry;

    public EnduserCard(int id, String firstName, String lastName, boolean hungry) {
        super (id, firstName,lastName);
        this.hungry = hungry;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    @Override
    public String getDisplayInfo() {
        return super.toString() + ", hat Hunger = " + hungry;
    }
}
