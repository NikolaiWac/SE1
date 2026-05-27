import java.util.List;

public class Client {

    public static void main(String[] args) {

        // Einmalige Instanz holen
        CardBox box = CardBox.getUnikat();

        // PersonCards erzeugen
        EnduserCard endUserCard1 = new EnduserCard(1, "John", "Doe", true);
        EnduserCard endUserCard2 = new EnduserCard(2, "Jane", "Doe", false);
        DeveloperCard developerCard1 = new DeveloperCard(3, "Jim", "Jackson", false);
        DeveloperCard developerCard2 = new DeveloperCard(4,"Anna", "Müller",  true);

        // Zur CardBox hinzufügen
        box.addPersonCard(endUserCard1);  
        box.addPersonCard(endUserCard2);
        box.addPersonCard(developerCard1);
        box.addPersonCard(developerCard2);

        // Aktuelle Liste holen
        List<PersonCard> aktuelleListe =
                box.getCurrentList();

        // Ausgabe
        PersonCardView view = new PersonCardView();
        view.showContent(aktuelleListe);
    }
}
