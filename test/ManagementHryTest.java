import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManagementHryTest {
    @Test
    void testInitHracia() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        assertEquals("Hrac", mgmt.getHrac().getMeno());
    }

    @Test
    void testInitHracaObtiaznost() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 0);
        assertEquals(100, mgmt.getHrac().getZdravie());
    }


    @Test
    void testDalsiaUroven() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        boolean koniec = mgmt.dalsiaUroven();
        assertFalse(koniec);
    }

    @Test
    void testDalsiaUrovenPosledna() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        mgmt.dalsiaUroven();
        mgmt.dalsiaUroven();
        mgmt.dalsiaUroven();
        mgmt.dalsiaUroven();
        mgmt.dalsiaUroven();
        boolean koniec = mgmt.dalsiaUroven();
        assertTrue(koniec);
    }

    @Test
    void testBojHraca() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        mgmt.dalsiaUroven();
        int hpBefore = mgmt.getAktualnaUroven().getNepriatel().getZdravie();
        mgmt.bojHraca();
        assertTrue(mgmt.getAktualnaUroven().getNepriatel().getZdravie() < hpBefore);
    }

    @Test
    void testBojNepriatela() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        mgmt.dalsiaUroven();
        int hpBefore = mgmt.getHrac().getZdravie();
        mgmt.bojNepriatela();
        assertTrue(mgmt.getHrac().getZdravie() <= hpBefore);
    }

    @Test
    void testKoniecOtravy() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        mgmt.getHrac().setStav(new stavOtraveny());
        mgmt.logikaKola();
        mgmt.logikaKola();
        assertInstanceOf(stavNormalny.class, mgmt.getHrac().getStav(), "Otraveny stav po dvoch kolach skonci.");
    }

    @Test
    void testLogikaKolaNormalnyStav() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        mgmt.getHrac().setStav(new stavNormalny());
        mgmt.logikaKola();
        assertInstanceOf(stavNormalny.class, mgmt.getHrac().getStav());
    }

    @Test
    void testLogikaKolaZapalenyStav() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        mgmt.getHrac().setStav(new stavZapaleny());
        int hpBefore = mgmt.getHrac().getZdravie();
        mgmt.logikaKola();
        assertTrue(mgmt.getHrac().getZdravie() < hpBefore);
    }

    @Test
    void testLogikaZelektrizovanie() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);

        mgmt.dalsiaUroven();
        mgmt.getAktualnaUroven().getNepriatel().setElement(Element.Elektricky);
        mgmt.getHrac().setVybavenaZbran(new Zbran("Zelezo", 1, Material.Kov));
        mgmt.skontrolujZelektrizovanie();

        assertInstanceOf(stavZelektrizovany.class, mgmt.getHrac().getStav(), "Hrac by mal byt zelektrizovany.");
    }

    @Test
    void testLogikaKolaRegen() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        mgmt.getHrac().setRegen(3, 10);
        int hpBefore = mgmt.getHrac().getZdravie();
        mgmt.logikaKola();
        assertTrue(mgmt.getHrac().getZdravie() >= hpBefore);
    }

    @Test
    void testNepriatelJeOhnivy() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        mgmt.dalsiaUroven();
        mgmt.getAktualnaUroven().getNepriatel().setElement(Element.Ohnivy);
        mgmt.bojNepriatela();
        assertEquals(Element.Ohnivy, mgmt.getAktualnaUroven().getNepriatel().getElement());
    }

    @Test
    void testNepriatelJeJedovaty() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        mgmt.dalsiaUroven();
        mgmt.getAktualnaUroven().getNepriatel().setElement(Element.Jedovaty);
        mgmt.bojNepriatela();
        assertEquals(Element.Jedovaty, mgmt.getAktualnaUroven().getNepriatel().getElement());
    }


    @Test
    void testKoniecSubojaHracPrehral() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        mgmt.getHrac().setZdravie(0);
        int vysledok = mgmt.KoniecSuboja();
        assertEquals(2, vysledok);
    }

    @Test
    void testKoniecSubojaNepriatelPorazeny() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        mgmt.dalsiaUroven();
        mgmt.getAktualnaUroven().getNepriatel().setZdravie(0);
        int vysledok = mgmt.KoniecSuboja();
        assertEquals(1, vysledok);
    }

    @Test
    void testKoniecSubojaPokracuje() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        mgmt.dalsiaUroven();
        int vysledok = mgmt.KoniecSuboja();
        assertEquals(0, vysledok);
    }

    @Test
    void testGetAktualnaUroven() {
        ManagementHry mgmt = new ManagementHry();
        assertNotNull(mgmt.getAktualnaUroven());
    }

    @Test
    void testVypocitanieCasuHry() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        mgmt.vypocitanieCasuHry();
    }

    @Test
    void testGetUlozeneMillisekundy() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Hrac", 1);
        assertTrue(mgmt.getUlozeneMillisekundy() >= 0);
    }

    @Test
    void testVypniThreadPool() {
        ManagementHry mgmt = new ManagementHry();
        mgmt.vypniThreadPool();
    }

    @Test
    void testUlozANacitajHru() throws Exception {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("TestHrac", 0);
        mgmt.dalsiaUroven();
        mgmt.getHrac().setZdravie(80);
        int zdravie = mgmt.getHrac().getZdravie();
        String subor = "test_ulozenie.dat";

        mgmt.ulozHru(subor);
        mgmt.dalsiaUroven();
        mgmt.getHrac().setMaxZdravie(500);
        mgmt.getHrac().setZdravie(500);

        Thread.sleep(500);

        mgmt.vypniThreadPool();


        mgmt.nacitajHru(subor);

        assertEquals("TestHrac", mgmt.getHrac().getMeno());
        assertEquals(80, zdravie);

        new java.io.File(subor).delete();
    }


    @Test
    void testUlozHruSIducouUrovnou() throws Exception {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("HracUroven", 1);
        mgmt.dalsiaUroven();
        mgmt.dalsiaUroven();
        mgmt.getHrac().setZdravie(50);
        String subor = "test_uroven.dat";

        mgmt.ulozHru(subor);
        Thread.sleep(500);
        mgmt.vypniThreadPool();

        ManagementHry mgmt2 = new ManagementHry();
        mgmt2.nacitajHru(subor);

        assertEquals("HracUroven", mgmt2.getHrac().getMeno());
        assertEquals(50, mgmt2.getHrac().getZdravie());
        assertNotNull(mgmt2.getAktualnaUroven());

        new java.io.File(subor).delete();
    }

    @Test
    void testUlozHruViackratPoSebe() throws Exception {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("Viackrat", 0);
        String subor = "test_viac.dat";

        mgmt.ulozHru(subor);
        Thread.sleep(300);
        mgmt.getHrac().setZdravie(75);
        mgmt.ulozHru(subor);
        Thread.sleep(300);
        mgmt.vypniThreadPool();

        ManagementHry mgmt2 = new ManagementHry();
        mgmt2.nacitajHru(subor);

        assertEquals(75, mgmt2.getHrac().getZdravie());

        new java.io.File(subor).delete();
    }

    @Test
    void testUlozHruNullNepriatel() throws Exception {
        ManagementHry mgmt = new ManagementHry();
        mgmt.initHraca("NullTest", 0);
        mgmt.dalsiaUroven();
        String subor = "test_null.dat";

        mgmt.ulozHru(subor);
        Thread.sleep(500);
        mgmt.vypniThreadPool();

        ManagementHry mgmt2 = new ManagementHry();
        mgmt2.nacitajHru(subor);

        assertNotNull(mgmt2.getHrac());
        assertEquals("NullTest", mgmt2.getHrac().getMeno());

        new java.io.File(subor).delete();
    }
}