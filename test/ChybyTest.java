import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChybyTest {

    @Test
    void testKonstruktorNeplatnaCesta() {
        ChybaNeplatnaCesta chyba = new ChybaNeplatnaCesta("Neplatna cesta k suboru");
        assertEquals("Neplatna cesta k suboru" , chyba.getMessage());
    }

    @Test
    void testNacitavanieSuboruSprava() {
        ChybaPriNacitavaniSuboru chyba = new ChybaPriNacitavaniSuboru("Subor sa nepodarilo nacitat");
        assertEquals("Subor sa nepodarilo nacitat", chyba.getMessage());
    }

}