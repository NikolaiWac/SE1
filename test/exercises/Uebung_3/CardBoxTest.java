package exercises.Uebung_3;

import exercises.Uebung_3.CardBox;
import exercises.Uebung_3.DeveloperCard;
import exercises.Uebung_3.EnduserCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestCardBox {
    private CardBox cardBox = null;
    @BeforeEach
    void setUp() {
        CardBox box = CardBox.getUnikat();
        box.clear();
    }
    @Test
    void testCardBox() throws CardBoxException {

        CardBox cardBox = CardBox.getUnikat();
        cardBox.clear();

        EnduserCard endUserCard1 = new EnduserCard(1,"John", "Doe", true);
        EnduserCard enduserCard2 = new EnduserCard(2,"Jane", "Doe", false);
        DeveloperCard developerCard1 = new DeveloperCard(3,"Jim", "Jackson", false);
        DeveloperCard developerCard2 = new DeveloperCard(4,"Anna", "Müller", true);

        cardBox.addPersonCard(endUserCard1);
        assertEquals(1, cardBox.size());

        assertEquals("Die ID -1 ist nicht vorhanden",
                cardBox.deletePersonCard(-1));

        cardBox.addPersonCard(enduserCard2);
        cardBox.addPersonCard(developerCard1);
        cardBox.addPersonCard(developerCard2);

        assertEquals(4, cardBox.size());

        assertEquals("Die ID 3 erfolgreich gelöscht",
                cardBox.deletePersonCard(3));

        assertEquals(3, cardBox.size());

        assertEquals("Die ID 3 ist nicht vorhanden",
                cardBox.deletePersonCard(3));

        assertEquals("Die ID 15 ist nicht vorhanden",
                cardBox.deletePersonCard(15));

        assertEquals(3, cardBox.size());

        cardBox.showContent();
    }

    @Test
    void TestLoadException() {  //Testet ob eine nicht vorhandene box geladen werden kann.


        File file = new File("cardbox.ser");
        if (file.exists()) {
            file.delete();
        }

        CardBox box = CardBox.getUnikat();
        box.clear();

        assertThrows(CardboxStorageException.class, box::load);
    }

    @Test
    void TestLoadEmptyBox() throws Exception { //Testet ob eine leere box geladen werden kann.

        CardBox box = CardBox.getUnikat();
        box.clear();
        box.save();
        box.load();

        assertEquals(0, box.size());
    }


    @Test
    void TestLoadBox() throws Exception {

        CardBox box = CardBox.getUnikat();
        box.clear();

        EnduserCard endUserCard1 = new EnduserCard(1, "John", "Doe", true);
        EnduserCard enduserCard2 = new EnduserCard(2, "Jane", "Doe", false);

        box.addPersonCard(endUserCard1);
        box.addPersonCard(enduserCard2);

        box.save();
        box.load();

        List<PersonCard> list = box.getCurrentList();

        assertEquals(2, list.size());
        assertTrue(list.stream().anyMatch(p -> p.getId() == 1));
        assertTrue(list.stream().anyMatch(p -> p.getId() == 2));
    }
    @Test
    void TestOverrideBox() throws Exception {

        CardBox box = CardBox.getUnikat();
        box.clear();

        EnduserCard endUserCard1 = new EnduserCard(1, "John", "Doe", true);
        EnduserCard enduserCard2 = new EnduserCard(2, "Jane", "Doe", false);
        DeveloperCard developerCard1 = new DeveloperCard(3, "Jim", "Jackson", false);

        box.addPersonCard(endUserCard1);
        box.addPersonCard(enduserCard2);

        box.save();

        box.addPersonCard(developerCard1);

        box.load();

        assertEquals(2, box.size());
    }



}