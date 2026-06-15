import java.util.Random;

/**
 * Factory pre vytvaranie nepriatelov na cistinke.
 * Nahodne vytvara jedneho z troch typov nepriatelov:<br>
 * - Potkan<br>
 * - Kralik<br>
 * - Kobylka<br>
 * 
 * @see FactoryPrisera
 */
public class FactoryCistinkaPrisera implements FactoryPrisera {
    /** Generator nahodnych cisiel */
    private final Random rand = new Random();

    /**
     * Vytvori nahodneho nepriatela pre cistinku.
     * 
     * @return Nova instancia nepriatela
     */
    @Override
    public EntityPrisera vytvorPriseru() {
        int r = rand.nextInt(3); // 0, 1 alebo 2

        int hp = rand.nextInt(11) + 5;
        int sila = rand.nextInt(6) + 10;

        return switch (r) {
            case 0 -> new EntityPriseraPotkan("Polny potkan", hp+5, sila-6);
            case 1 -> new EntityPriseraKralik("Agresivny kralik", hp, sila+3);
            default -> new EntityPriseraKobylka("Hladna kobylka", hp-3, sila-2);
        };
    }
}