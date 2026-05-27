
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestCardBox {
    private CardBox cardBox = null;
    @BeforeEach
    void setUp() {
        this.cardBox = new CardBox();
    }
    @Test
    void TestCardBox() {
        EnduserCard endUserCard1 = new EnduserCard("John", "Doe", 1, true);
        EnduserCard enduserCard2 = new EnduserCard("Jane", "Doe", 2, false);
        DeveloperCard developerCard1 = new DeveloperCard("Jim", "Jackson", 3, false);
        DeveloperCard developerCard2 = new DeveloperCard("Anna", "Müller", 4, true);
        try {
            cardBox.addPersonCard(PersonCard endUserCard1);
// Anzahl Elemente um 1 erhöht
            assertEquals(cardBox.size(), 1);
// Der Versuch, ungültige IDs zu löschen, führt zu einer Fehlermeldung
            assertEquals(cardBox.deletePersonCard(-1), "Die ID -1 ist nicht vorhanden");

// Die folgenden Aufrufe erzeugen keine Exception (wenn doch, wird fail() ausgelöst)
            cardBox.addPersonCard(PersonCard enduserCard2);
            cardBox.addPersonCard(PersonCard developerCard1);
            cardBox.addPersonCard(PersonCard developerCard2);
// Alle PersonCards wurden erfolgreich hinzugefügt und neue Anzahl von Objekten ist 4
            assertEquals(cardBox.size(), 4);
// Löschen existenter IDs funktioniert
            assertEquals(cardBox.deletePersonCard(3), "ID 3 erfolgreich gelöscht");
// Es sind jetzt nur noch 3 Objekte in der Liste
                    assertEquals(cardBox.size(), 3);
// Löschen einer schon gelöschten ID funktioniert nicht
            assertEquals(cardBox.deletePersonCard(3), "Die ID 3 ist nicht vorhanden");
// Löschen einer ID, die nie hinzugefügt wurde, funktioniert nicht
                    assertEquals(cardBox.deletePersonCard(15), "Die ID 15 gibt es nicht");
// Es sind immer noch 3 Objekte, weil nichts gelöscht wurde
                            assertEquals(cardBox.size(), 3);
// Ausgabe erzeugen (wird nicht von JUnit validiert)
            cardBox.showContent();
        } catch (CardBoxException e) {
// Wenn addPersonCard() von validen Objekten eine Exception auslöst, ist der Test fehlgeschlagen
            fail("Exception mit unerwartetem Ergebnis: " + e.getMessage());
        }
// Test, ob addPersonCard() einer schon vorhandenen PersonCard eine Exception auslöst (Test bestanden, wenn ja)
        CardBoxException thrown = assertThrows(CardBoxException.class, () -
                > cardBox.addPersonCard(PersonCard endUserCard1), "Exception wurde nicht geworfen");
// Test, ob addPersonCard() eines NULL-Pointers eine Exception auslöst (Test bestanden, wenn ja)
        CardBoxException thrown2 = assertThrows(CardBoxException.class, ()
                -> cardBox.addPersonCard(null), "Exception wurde nicht geworfen");
    }
}}