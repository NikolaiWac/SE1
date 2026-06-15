package exercises.Uebung_4;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer; //definiert Strategie unserer Ausfuehrung
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;  //wendet Ausfuehrungsstrategie auf Klasse an
import org.junit.jupiter.api.Order; //um die Reihenfolge der Ausfuehrung festlegen zu koennen

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestUserStoryManagement {
    private static UserStoryManagement usm;
    @BeforeAll
    static void initiate() throws Exception {
        usm = UserStoryManagement.getInstance();
    }

    @AfterAll
    static void clear() {}

    @Order(1)
    @Test
    void test() {
        usm.createUserStory("First User Story ", 0);
        usm.createUserStory("Second User Story", 1);
        usm.createTask("First Task");
        usm.createTask("Second Task");
        try {
            usm.assign(0, 2);
            usm.assign(1, 3);
        }catch(Exception e) {
            System.out.println(e.getMessage());
            fail("Caught Exception: "+ e.getMessage());
        }
        System.out.println(usm.getUserStories());
        System.out.println(usm.getTasks());
    }

}

