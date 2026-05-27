import java.io.Serializable;

public abstract class AbstractPersonCard implements exercises.Uebung_3.PersonCard, Serializable {

    private static final long serialVersionID = 1L; // um Versionskompatibilität während Serialisierung beizubehalten
    private String firstName;
    private String lastName;
    private int id;

    public AbstractPersonCard(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }
    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "ID = " + id + ", Vorname = " + firstName + ", Nachname = " + lastName;
    }


}
