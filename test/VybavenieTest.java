import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VybavenieTest {
    @Test
    void testZbranKonstruktor() {
        Zbran zbran = new Zbran("Meč", 15, Material.Drevo);
        assertEquals("Meč", zbran.getNazov());
        assertEquals(15, zbran.getBonusovePoskodenie());
        assertEquals(Material.Drevo, zbran.getMaterial());
    }

    @Test
    void testLektvarKonstruktor() {
        Lektvar lektvar = new Lektvar("Malý lektvar", 25);
        assertEquals("Malý lektvar", lektvar.getNazov());
        assertEquals(25, lektvar.getSilaLiecenia());
    }

    @Test
    void testLektvarPouziNaEntitu() {
        Lektvar lektvar = new Lektvar("Malý lektvar", 25);
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        lektvar.pouzi(hrac);
        assertEquals(100, hrac.getZdravie());
    }

    @Test
    void testLektvarPouziNePreplniMax() {
        Lektvar lektvar = new Lektvar("Veľký lektvar", 150);
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        lektvar.pouzi(hrac);
        assertEquals(100, hrac.getZdravie());
    }

    @Test
    void testLektvarStatickaMetoda() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        Lektvar.pouzi(hrac, 30);
        assertEquals(100, hrac.getZdravie());
    }

    @Test
    void testLektvarRegenKonstruktor() {
        LektvarRegen lektvar = new LektvarRegen("Bylinky", 30, 3);
        assertEquals("Bylinky", lektvar.getNazov());
        assertEquals(3, lektvar.getTrvanie());
    }

    @Test
    void testLektvarRegenGetRegenLiecenie() {
        LektvarRegen lektvar = new LektvarRegen("Bylinky", 30, 3);
        assertEquals(10, lektvar.getRegenLiecenie());
    }

    @Test
    void testPridanieZbraneDoInventara() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        Zbran zbran = new Zbran("Meč", 15, Material.Kov);
        hrac.pridajDoInventara(zbran);
        assertNotNull(hrac.getVybavenaZbran());
    }

    @Test
    void testPridanieLektvaruDoInventara() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        Lektvar lektvar = new Lektvar("Lektvar", 20);
        hrac.pridajDoInventara(lektvar);
        assertEquals(1, hrac.getInventar().size());
    }

    @Test
    void testPouziZInventaraZbran() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        Zbran zbran = new Zbran("Meč", 15, Material.Kov);
        hrac.pridajDoInventara(zbran);
        int result = hrac.pouziZInventara(0);
        assertEquals(1, result);
    }

    @Test
    void testPouziZInventaraLektvar() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        Lektvar lektvar = new Lektvar("Lektvar", 20);
        hrac.pridajDoInventara(lektvar);
        int result = hrac.pouziZInventara(0);
        assertEquals(2, result);
    }

    @Test
    void testPouziZInventaraNeplatnyIndex() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        int result = hrac.pouziZInventara(5);
        assertEquals(0, result);
    }

    @Test
    void testOdstranZInventara() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        Lektvar lektvar = new Lektvar("Lektvar", 20);
        hrac.pridajDoInventara(lektvar);
        hrac.odstranZInventara(lektvar);
        assertEquals(0, hrac.getInventar().size());
    }

    @Test
    void testHracSilaBezZbrane() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        assertEquals(10, hrac.getSilaUtoku());
    }

    @Test
    void testHracSilaSZbranou() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        Zbran zbran = new Zbran("Meč", 15, Material.Kov);
        hrac.setVybavenaZbran(zbran);
        assertEquals(25, hrac.getSilaUtoku());
    }

    @Test
    void testPouziLektvarInt() {
        EntityHrac hrac = new EntityHrac("Tester", 50, 10);
        hrac.pouziLektvar(30);
        assertEquals(50, hrac.getZdravie());
    }
}