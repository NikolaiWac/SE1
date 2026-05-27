

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardBox {


    private static CardBox unikat;       //wir müssen eine Einzel-Instanz aus der Box machen
    private List<PersonCard> cards;
    private static final String FILE_NAME = "cardbox.ser";      //Dateiname
    private CardBox() {         //private, damit die Klasse nicht von außen aufgerufen werden und so mehrfach vorhanden sein kann
        cards = new ArrayList<>();
    }


    public static CardBox getUnikat() {         //Statischer Zugriff auf die Box, damit immer dieselbe Instanz aufgerufen wird
        if (unikat == null) {
            unikat = new CardBox();
        }
        return unikat;
    }

    private boolean contains(PersonCard card) {
        int id = card.getId();
        for (PersonCard record : cards) {
            if (record.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void addPersonCard(PersonCard card) throws CardBoxException {
        if (card == null) {
            throw new CardBoxException(0);
        }
        if (contains(card)) {
            CardBoxException e = new CardBoxException(card.getId());
            throw e;
        }
        cards.add(card);
    }

    public void save() throws CardboxStorageException {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            out.writeObject(cards);  //an dieser Stelle wird die komplette Liste gespeichert

        } catch (IOException e) {       //IOException = technischer Fehler
            throw new CardboxStorageException(
                    "Fehler beim Speichern der CardBox - Zielspeicher voll", e);    // ich weiß jetzt nicht, ob die Message an der Stelle richtig ist bzw. was für eine Message der sehen will
        }
    }

    public void load() throws CardboxStorageException {

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream(FILE_NAME))) {

            // Vorhandene Karten löschen
            cards.clear();

            // Karten laden
            cards = (List<PersonCard>) in.readObject();

        } catch (IOException | ClassNotFoundException e) {      //IOException = technischer Fehler
            throw new CardboxStorageException(
                    "Fehler beim Laden der Karten - keine Karten vorhanden", e); // ich weiß jetzt nicht, ob die Message an der Stelle richtig ist bzw. was für eine Message der sehen will
        }
    }

    public List<PersonCard> getCurrentList() {
        return cards;
    }

    private PersonCard getPersonCard(int id) {
        for (PersonCard record : cards) {
            if (id == record.getId() ){
                return record;
            }
        }
        return null;
    }

    public String deletePersonCard(int id) {
        PersonCard card = getPersonCard(id);
        if (card == null) {
            return "Die ID " + id + " ist nicht vorhanden";
        } else {
            cards.remove(card);
            return "ID " + id + " erfolgreich gelöscht";
        }
    }



    public int size(){
        return cards.size();
    }
}
