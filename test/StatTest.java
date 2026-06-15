import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatTest {
    @Test
    void testStatKonstruktor() {
        Stat<Integer> stat = new Stat<>(100, 0, 200);
        assertEquals(100, stat.getHodnota());
    }

    @Test
    void testGetMinHodnota() {
        Stat<Integer> stat = new Stat<>(100, 0, 200);
        assertEquals(0, stat.getMinHodnota());
    }

    @Test
    void testGetMaxHodnota() {
        Stat<Integer> stat = new Stat<>(100, 0, 200);
        assertEquals(200, stat.getMaxHodnota());
    }

    @Test
    void testSetHodnotaVnutriRozsahu() {
        Stat<Integer> stat = new Stat<>(100, 0, 200);
        stat.setHodnota(150);
        assertEquals(150, stat.getHodnota());
    }

    @Test
    void testSetHodnotaPodMin() {
        Stat<Integer> stat = new Stat<>(100, 0, 200);
        stat.setHodnota(-50);
        assertEquals(0, stat.getHodnota());
    }

    @Test
    void testSetHodnotaNadMax() {
        Stat<Integer> stat = new Stat<>(100, 0, 200);
        stat.setHodnota(300);
        assertEquals(200, stat.getHodnota());
    }

    @Test
    void testPridaj() {
        Stat<Integer> stat = new Stat<>(100, 0, 200);
        stat.pridaj(30);
        assertEquals(130, stat.getHodnota());
    }

    @Test
    void testPridajNadMax() {
        Stat<Integer> stat = new Stat<>(100, 0, 200);
        stat.pridaj(150);
        assertEquals(200, stat.getHodnota());
    }

    @Test
    void testOdcitaj() {
        Stat<Integer> stat = new Stat<>(100, 0, 200);
        stat.odcitaj(30);
        assertEquals(70, stat.getHodnota());
    }

    @Test
    void testOdcitajPodMin() {
        Stat<Integer> stat = new Stat<>(100, 0, 200);
        stat.odcitaj(150);
        assertEquals(0, stat.getHodnota());
    }

    @Test
    void testJeNaMin() {
        Stat<Integer> stat = new Stat<>(0, 0, 200);
        assertTrue(stat.jeNaMin());
    }

    @Test
    void testJeNaMax() {
        Stat<Integer> stat = new Stat<>(200, 0, 200);
        assertTrue(stat.jeNaMax());
    }

}