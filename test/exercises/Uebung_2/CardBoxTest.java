package exercises.Uebung_2;

import exercises.Uebung_1.uebung1.businesslogic.RomanNumberTransformer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardBoxTest {

    private CardBox box;

    private DeveloperCard dev1;
    private EnduserCard user1;

    @BeforeEach
    void setUp() {
        box = new CardBox();

        dev1 = new DeveloperCard(1, "John", "Doe", true);
        user1 = new EnduserCard(2, "Anna", "Müller", false);
    }

    @Test
    void testAddPersonCard_increasesSize() throws CardBoxException {
        box.addPersonCard(dev1);

        assertEquals(1, box.size());
    }

    @Test
    void testAddMultipleCards_sizeCorrect() throws CardBoxException {
        box.addPersonCard(dev1);
        box.addPersonCard(user1);

        assertEquals(2, box.size());
    }

    @Test
    void testAddPersonCard_duplicateId_throwsException() throws CardBoxException {
        box.addPersonCard(dev1);

        DeveloperCard duplicate = new DeveloperCard(1, "Mike", "Smith", false);

        assertThrows(CardBoxException.class, () -> {
            box.addPersonCard(duplicate);
        });
    }

    @Test
    void testDeletePersonCard_success() throws CardBoxException {
        box.addPersonCard(user1);

        String result = box.deletePersonCard(2);

        assertEquals("Erfolgreich gelöscht", result);
        assertEquals(0, box.size());
    }

    @Test
    void testDeletePersonCard_notFound() {
        String result = box.deletePersonCard(99);

        assertEquals("Fehler: Objekt mit ID 99 nicht vorhanden", result);
    }

    @Test
    void testSize_emptyBox() {
        assertEquals(0, box.size());
    }
}