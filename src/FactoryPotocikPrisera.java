import java.util.Random;

/**
 * Factory pre vytvaranie nepriatelov pri potociku.
 * Nahodne vytvara jedneho zo styroch typov nepriatelov:<br>
 * - Rusalka<br>
 * - Vodnik<br>
 * - Uhor (elektricky, specialny nepriatel)<br>
 * - Topivec<br>
 * 
 * @see FactoryPrisera
 */
public class FactoryPotocikPrisera implements FactoryPrisera {
    /** Generator nahodnych cisiel */
    private final Random rand = new Random();

    /**
     * Vytvori nahodneho nepriatela pre potocik.
     * 
     * @return Nova instancia nepriatela
     */
    @Override
    public EntityPrisera vytvorPriseru() {
        int r = rand.nextInt(4); // 0, 1, 2 alebo 3

        int hp = rand.nextInt(16) + 50;
        int sila = rand.nextInt(6) + 10;

        return switch (r) {
            case 0 -> new EntityPriseraRusalka("Rusalka", hp, sila-5);
            case 1 -> new EntityPriseraVodnik("Vodnik", hp, sila+3);
            case 2 -> new EntityPriseraUhor("Elektricky Uhor", hp-40, 0);
            default -> new EntityPriseraTopivec("Topivec", hp+5, sila);
        };
    }
}