package exercises.Uebung_3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardBox {


    private static CardBox unikat = null;       //wir müssen eine Singleton-Instanz aus der Box machen
    private List<PersonCard> cards;
    private final static String FILE_NAME = "cardbox.dat";      //Dateiname
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
        /*if (card == null) {
            throw new CardBoxException(0);
        }*/
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

            for (PersonCard card: cards) {
                out.writeObject(card);
            }
            out.close();  //an dieser Stelle wird die komplette Liste gespeichert

        } catch (IOException e) {       //IOException = technischer Fehler
            throw new CardboxStorageException(
                    "Fehler beim Speichern der CardBox - Zielspeicher voll");    // ich weiß jetzt nicht, ob die Message an der Stelle richtig ist 
        }
    }

    public void load() throws CardboxStorageException {

        try {
            FileInputStream in =  new FileInputStream(FILE_NAME); //ObjectInputStream liefert leider nicht unser gewünschtes Ergebnis bei available, daher Workaround
            ObjectInputStream inputStream = new ObjectInputStream(in);
            List<PersonCard> cardsnew = new ArrayList<>();

            while (in.available() > 0) {
                PersonCard p = (PersonCard) inputStream.readObject();
                cardsnew.add(p);
            }

                // Karten laden
            this.cards = cardsnew;


        } catch (Exception e) {
            throw new CardboxStorageException("Fehler beim Laden der Karten - keine Karten vorhanden"); // ich weiß jetzt nicht, ob die Message an der Stelle richtig ist
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

    public void clear() {
        cards.clear();
    }


    public int size(){
        return cards.size();
    }
}
