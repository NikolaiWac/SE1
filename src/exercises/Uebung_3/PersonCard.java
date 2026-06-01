package exercises.Uebung_3;


public interface PersonCard {
    public String getFirstName();
    public String getLastName();
    // Die ID dient als Primärschlüssel zur Unterscheidung alle PersonCardObjekte.
    // Die ID darf nicht innerhalb der CardBox-Klasse gesetzt werden.
    public int getId();
    public String getDisplayInfo();
}