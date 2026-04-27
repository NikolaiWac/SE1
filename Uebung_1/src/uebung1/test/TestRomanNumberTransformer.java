package uebung1.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uebung1.businesslogic.RomanNumberTransformer;

class TestRomanNumberTransformer {

    private RomanNumberTransformer transformer;

    @BeforeEach
    void setUp() {
        // Wird vor jedem Testfall ausgeführt
        transformer = new RomanNumberTransformer();
    }

    @Test
    void testValidRomanNumbers_gAEK1() {
        // Test der gültigen Äquivalenzklasse (inklusive Grenzwerte)
        assertEquals("I", transformer.transformNumber(1), "Grenzwert 1 (Untergrenze)");
        assertEquals("X", transformer.transformNumber(10), "Repräsentant 10");
        assertEquals("MCMLXXXVII", transformer.transformNumber(1987), "Repräsentant 1987");
        assertEquals("MMM", transformer.transformNumber(3000), "Grenzwert 3000 (Obergrenze)");
    }

    @Test
    void testInvalidRomanNumbersTooLarge_uAEK2() {
        // Test der ungültigen Äquivalenzklasse > 3000
        String expectedMessage = "Zahl darf nicht kleiner als 1 und größer als 3.000 sein.";

        assertEquals(expectedMessage, transformer.transformNumber(3001), "Grenzwert 3001");
        assertEquals(expectedMessage, transformer.transformNumber(5000), "Repräsentant 5000");
    }

    @Test
    void testInvalidRomanNumbersTooSmall_uAEK1() {
        // Test der ungültigen Äquivalenzklasse <= 0
        String expectedMessage = "Zahl darf nicht kleiner als 1 und größer als 3.000 sein.";

        assertEquals(expectedMessage, transformer.transformNumber(0), "Grenzwert 0");
        assertEquals(expectedMessage, transformer.transformNumber(-1), "Repräsentant -1");
        assertEquals(expectedMessage, transformer.transformNumber(Integer.MIN_VALUE), "Grenzwert MIN_INT");
    }
}