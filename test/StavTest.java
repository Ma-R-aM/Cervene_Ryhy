import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StavTest {
    @Test
    void testStavNormalnyMozeUtocit() {
        stavNormalny stav = new stavNormalny();
        assertTrue(stav.mozeUtocit());
    }

    @Test
    void testStavNormalnyVykonajEfekty() {
        stavNormalny stav = new stavNormalny();
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        stav.vykonajEfekty(hrac);
        assertEquals(100, hrac.getZdravie());
    }

    @Test
    void testStavNormalnyGetNazov() {
        stavNormalny stav = new stavNormalny();
        assertEquals("normalny", stav.getnazovStavu());
    }

    @Test
    void testStavZapalenyNemozeUtocit() {
        stavZapaleny stav = new stavZapaleny();
        assertFalse(stav.mozeUtocit());
    }

    @Test
    void testStavZapalenyVykonajEfekty() {
        stavZapaleny stav = new stavZapaleny();
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        stav.vykonajEfekty(hrac);
        assertTrue(hrac.getZdravie() < 100);
    }

    @Test
    void testStavZapalenyGetPopalenie() {
        stavZapaleny stav = new stavZapaleny();
        assertEquals(30, stav.getPopalenie());
    }

    @Test
    void testStavZapalenyGetNazov() {
        stavZapaleny stav = new stavZapaleny();
        assertEquals("hori", stav.getnazovStavu());
    }

    @Test
    void testStavOtravenyNemozeUtocit() {
        stavOtraveny stav = new stavOtraveny();
        assertFalse(stav.mozeUtocit());
    }

    @Test
    void testStavOtravenyVykonajEfekty() {
        stavOtraveny stav = new stavOtraveny();
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        stav.vykonajEfekty(hrac);
        assertTrue(hrac.getZdravie() < 100);
    }

    @Test
    void testStavOtravenyGetTrvanie() {
        stavOtraveny stav = new stavOtraveny();
        assertEquals(2, stav.getTrvanieOtravenia());
    }

    @Test
    void testStavOtravenyGetPoskodenie() {
        stavOtraveny stav = new stavOtraveny();
        assertEquals(5, stav.getPoskodenie());
    }

    @Test
    void testStavOtravenyGetNazov() {
        stavOtraveny stav = new stavOtraveny();
        assertEquals("otraveny", stav.getnazovStavu());
    }

    @Test
    void testStavZelektrizovanyNemozeUtocit() {
        stavZelektrizovany stav = new stavZelektrizovany();
        assertFalse(stav.mozeUtocit());
    }

    @Test
    void testStavZelektrizovanyVykonajEfekty() {
        stavZelektrizovany stav = new stavZelektrizovany();
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        stav.vykonajEfekty(hrac);
        assertEquals(100, hrac.getZdravie());
    }

    @Test
    void testStavZelektrizovanyGetNazov() {
        stavZelektrizovany stav = new stavZelektrizovany();
        assertEquals("je zelektrizovany, umiera", stav.getnazovStavu());
    }
}