import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UrovenTest {
    @Test
    void testUrovenKonstruktor() {
        EntityPrisera nepriatel = new EntityPrisera("Vlk", 50, 10, Element.Normalny);
        UrovenLes uroven = new UrovenLes("Les", nepriatel, "Popis", "/pic/test.png");
        assertEquals("Les", uroven.getNazov());
    }

    @Test
    void testUrovenGetNepriatel() {
        EntityPrisera nepriatel = new EntityPrisera("Vlk", 50, 10, Element.Normalny);
        UrovenLes uroven = new UrovenLes("Les", nepriatel, "Popis", "/pic/test.png");
        assertNotNull(uroven.getNepriatel());
    }

    @Test
    void testUrovenGetPopis() {
        EntityPrisera nepriatel = new EntityPrisera("Vlk", 50, 10, Element.Normalny);
        UrovenLes uroven = new UrovenLes("Les", nepriatel, "Popis urovne", "/pic/test.png");
        assertEquals("Popis urovne", uroven.getPopisUrovne());
    }

    @Test
    void testUrovenGetPathToCutPic() {
        EntityPrisera nepriatel = new EntityPrisera("Vlk", 50, 10, Element.Normalny);
        UrovenLes uroven = new UrovenLes("Les", nepriatel, "Popis", "/pic/test.png");
        assertEquals("/pic/test.png", uroven.getPathToCutPic());
    }

    @Test
    void testUrovenNasledujuca() {
        EntityPrisera nepriatel1 = new EntityPrisera("Vlk", 50, 10, Element.Normalny);
        EntityPrisera nepriatel2 = new EntityPrisera("Diviak", 60, 15, Element.Normalny);
        UrovenLes uroven1 = new UrovenLes("Les1", nepriatel1, "Popis1", "/pic/1.png");
        UrovenLes uroven2 = new UrovenLes("Les2", nepriatel2, "Popis2", "/pic/2.png");
        uroven1.setNasledujucaUroven(uroven2);
        assertEquals(uroven2, uroven1.getNasledujucaUroven());
    }

    @Test
    void testUrovenLesEfekt() {
        EntityHrac hrac = new EntityHrac("Tester", 100, 10);
        EntityPrisera nepriatel = new EntityPrisera("Vlk", 50, 10, Element.Normalny);
        UrovenLes uroven = new UrovenLes("Les", nepriatel, "Popis", "/pic/test.png");
        uroven.efekt(hrac);
        assertEquals(2, hrac.getInventar().size(), "Mal by mat zbran a lektvar, cize velkost inventara by mala byt 2");
    }

    @Test
    void testFactoryLesPrisera() {
        FactoryLesPrisera factory = new FactoryLesPrisera();
        EntityPrisera prisera = factory.vytvorPriseru();
        assertNotNull(prisera);
    }

    @Test
    void testFactoryCistinkaPrisera() {
        FactoryCistinkaPrisera factory = new FactoryCistinkaPrisera();
        EntityPrisera prisera = factory.vytvorPriseru();
        assertNotNull(prisera);
    }

    @Test
    void testFactoryPotocikPrisera() {
        FactoryPotocikPrisera factory = new FactoryPotocikPrisera();
        EntityPrisera prisera = factory.vytvorPriseru();
        assertNotNull(prisera);
    }

    @Test
    void testFactoryCarovnyLesPrisera() {
        FactoryCarovnyLesPrisera factory = new FactoryCarovnyLesPrisera();
        EntityPrisera prisera = factory.vytvorPriseru();
        assertNotNull(prisera);
    }

    @Test
    void testFactoryPustPrisera() {
        FactoryPustPrisera factory = new FactoryPustPrisera();
        EntityPrisera prisera = factory.vytvorPriseru();
        assertNotNull(prisera);
    }
}