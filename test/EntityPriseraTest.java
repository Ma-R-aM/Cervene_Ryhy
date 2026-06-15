import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntityPriseraTest {

    @Test
    void testEntityPriseraDiviak() {
        EntityPriseraDiviak diviak = new EntityPriseraDiviak("Divino", 100, 20);
        assertEquals("/pic/Diviak.png", diviak.getCestaKObrazku());
        assertEquals(Element.Normalny, diviak.getElement());
    }

    @Test
    void testEntityPriseraHad() {
        EntityPriseraHad had = new EntityPriseraHad("Hadik", 80, 15);
        assertEquals("/pic/Had.png", had.getCestaKObrazku());
        assertEquals(Element.Jedovaty, had.getElement());
    }

    @Test
    void testEntityPriseraJezibaba() {
        EntityPriseraJezibaba jezibaba = new EntityPriseraJezibaba("Jezibabenka", 200, 40);
        assertEquals("/pic/Jezibaba.png", jezibaba.getCestaKObrazku());
        assertEquals(Element.Normalny, jezibaba.getElement());
    }

    @Test
    void testEntityPriseraKobylka() {
        EntityPriseraKobylka kobylka = new EntityPriseraKobylka("Skakalka", 50, 10);
        assertEquals("/pic/Kobylka.png", kobylka.getCestaKObrazku());
        assertEquals(Element.Normalny, kobylka.getElement());
    }

    @Test
    void testEntityPriseraKralik() {
        EntityPriseraKralik kralik = new EntityPriseraKralik("Kralicek", 60, 12);
        assertEquals("/pic/Kralik.png", kralik.getCestaKObrazku());
        assertEquals(Element.Normalny, kralik.getElement());
    }

    @Test
    void testEntityPriseraLesij() {
        EntityPriseraLesij lesij = new EntityPriseraLesij("Lesnik", 150, 30);
        assertEquals("/pic/Lesij.png", lesij.getCestaKObrazku());
        assertEquals(Element.Normalny, lesij.getElement());
    }

    @Test
    void testEntityPriseraMumia() {
        EntityPriseraMumia mumia = new EntityPriseraMumia("Kusok Starsia Entita Ale Vek Je Len Cislo Urcite Je V Najlepsich Rokoch :3", 120, 25);
        assertEquals("/pic/Mumia.png", mumia.getCestaKObrazku());
        assertEquals(Element.Ohnivy, mumia.getElement());
    }

    @Test
    void testEntityPriseraPavuk() {
        EntityPriseraPavuk pavuk = new EntityPriseraPavuk("Pavinko", 70, 14);
        assertEquals("/pic/Pavuk.png", pavuk.getCestaKObrazku());
        assertEquals(Element.Jedovaty, pavuk.getElement());
    }

    @Test
    void testEntityPriseraPotkan() {
        EntityPriseraPotkan potkan = new EntityPriseraPotkan("Krysa", 55, 11);
        assertEquals("/pic/Potkan.png", potkan.getCestaKObrazku());
        assertEquals(Element.Normalny, potkan.getElement());
    }

    @Test
    void testEntityPriseraRusalka() {
        EntityPriseraRusalka rusalka = new EntityPriseraRusalka("Vodna deva", 90, 18);
        assertEquals("/pic/Rusalka.png", rusalka.getCestaKObrazku());
        assertEquals(Element.Vodny, rusalka.getElement());
    }

    @Test
    void testEntityPriseraSkorpion() {
        EntityPriseraSkorpion skorpion = new EntityPriseraSkorpion("Skorpions", 75, 16);
        assertEquals("/pic/Skorpion.png", skorpion.getCestaKObrazku());
        assertEquals(Element.Jedovaty, skorpion.getElement());
    }

    @Test
    void testEntityPriseraTopivec() {
        EntityPriseraTopivec topivec = new EntityPriseraTopivec("Utopenec", 95, 19);
        assertEquals("/pic/Topivec.png", topivec.getCestaKObrazku());
        assertEquals(Element.Vodny, topivec.getElement());
    }

    @Test
    void testEntityPriseraUhor() {
        EntityPriseraUhor uhor = new EntityPriseraUhor("Elektroterapia", 65, 0);
        assertEquals("/pic/Uhor.png", uhor.getCestaKObrazku());
        assertEquals(Element.Elektricky, uhor.getElement());
    }

    @Test
    void testEntityPriseraVlk() {
        EntityPriseraVlk vlk = new EntityPriseraVlk("Havoooo :3", 110, 22);
        assertEquals("/pic/Vlk.png", vlk.getCestaKObrazku());
        assertEquals(Element.Normalny, vlk.getElement());
    }

    @Test
    void testEntityPriseraVodnik() {
        EntityPriseraVodnik vodnik = new EntityPriseraVodnik("Chytal ryby dlho", 130, 26);
        assertEquals("/pic/Vodnik.png", vodnik.getCestaKObrazku());
        assertEquals(Element.Vodny, vodnik.getElement());
    }

    @Test
    void testEntityPriseraDivozienka() {
        EntityPriseraDivozienka divozienka = new EntityPriseraDivozienka("Divka", 140, 28);
        assertEquals("/pic/Divozienka.png", divozienka.getCestaKObrazku());
        assertEquals(Element.Normalny, divozienka.getElement());
    }
}