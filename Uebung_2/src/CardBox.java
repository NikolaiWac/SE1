import java.util.ArrayList;
import java.util.List;

public class CardBox {
    private List<PersonCard> cards = new ArrayList<>();

    public void addPersonCard(PersonCard personCard) throws CardBoxException {
        for (PersonCard card : cards) {
            if (card.getId() == personCard.getId()) {
                throw new CardBoxException("Das CardBox-Objekt mit der ID " + personCard.getId() + " ist bereits vorhanden");
            }
        }
        cards.add(personCard);
    }

    public String deletePersonCard(int id) {
        for (PersonCard card : cards) {
            if (card.getId() == id) {
                cards.remove(card);
                return "Erfolgreich gelöscht";
            }
        }
        return "Fehler: Objekt mit ID " + id + " nicht vorhanden";
    }
}
