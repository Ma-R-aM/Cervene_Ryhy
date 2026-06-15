import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntityTest {
    @Test
    void testEntityKonstruktor() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 15);
        assertEquals("Tester", hrac.getMeno());
        assertEquals(100, hrac.getZdravie());
        assertEquals(15, hrac.getSilaUtoku());
    }

    @Test
    void testPrijmiPoskodenie() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        hrac.prijmiPoskodenie(30);
        assertEquals(70, hrac.getZdravie());
    }

    @Test
    void testNadmernePoskodenieNespadnePodNula() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        hrac.prijmiPoskodenie(150);
        assertTrue(hrac.getZdravie() == 0);
    }

    @Test
    void testGetMaxZdravie() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        assertEquals(100, hrac.getMaxZdravie());
    }

    @Test
    void testSetMaxZdravie() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        hrac.setZdravie(50);
        hrac.setMaxZdravie(200);
        assertEquals(200, hrac.getMaxZdravie());
    }

    @Test
    void testSetZdravie() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        hrac.setZdravie(80);
        assertEquals(80, hrac.getZdravie());
    }

    @Test
    void testSetZdraviePodMin() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        hrac.setZdravie(-50);
        assertEquals(0, hrac.getZdravie());
    }

    @Test
    void testUtoc() {
        EntityHrac utocnik = new EntityHrac("Utocnik", 100, 25);
        EntityHrac ciel = new EntityHrac("Ciel", 100, 10);
        utocnik.utoc(ciel);
        assertTrue(ciel.getZdravie() < 100);
    }

    @Test
    void testGetStav() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        assertNotNull(hrac.getStav());
    }

    @Test
    void testSetStav() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        hrac.setStav(new stavZapaleny());
        assertTrue(hrac.getStav() instanceof stavZapaleny);
    }

    @Test
    void testObserverPridavanie() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        Observer observer = new Observer() {
            @Override
            public void aktualizuj(int aktualneHP) {}
        };
        hrac.pridajObserver(observer);
    }

    @Test
    void testEntityPriseraKonstruktor() {
        EntityPrisera prisera = new EntityPrisera("Vlcik", 80, 20, Element.Normalny);
        assertEquals("Vlcik", prisera.getMeno());
        assertEquals(80, prisera.getZdravie());
        assertEquals(Element.Normalny, prisera.getElement());
    }

    @Test
    void testEntityPriseraDefaultKonstruktor() {
        EntityPrisera prisera = new EntityPrisera("Default");
        assertEquals("Default", prisera.getMeno());
        assertEquals(500, prisera.getZdravie());
        assertEquals(Element.Ohnivy, prisera.getElement());
    }

    @Test
    void testPriseraGetSilaUtoku() {
        EntityPrisera prisera = new EntityPrisera("Test", 100, 25, Element.Normalny);
        assertEquals(25, prisera.getSilaUtoku());
    }

    @Test
    void testPriseraSetSilaUtoku() {
        EntityPrisera prisera = new EntityPrisera("Test", 100, 25, Element.Normalny);
        prisera.setSilaUtoku(50);
        assertEquals(50, prisera.getSilaUtoku());
    }

    @Test
    void testPriseraGetCestaKObrazku() {
        EntityPrisera prisera = new EntityPrisera("Test");
        assertEquals("/pic/Error.png", prisera.getCestaKObrazku());
    }
}