import java.util.Random;

/**
 * Factory pre vytvaranie nepriatelov v carovnom lese.
 * Nahodne vytvara jedneho z troch typov magickych nepriatelov:<br>
 * - Lesij (lesny muzik)<br>
 * - Jezibaba<br>
 * - Divozienka<br>
 * 
 * @see FactoryPrisera
 */
public class FactoryCarovnyLesPrisera implements FactoryPrisera {
    /** Generator nahodnych cisiel */
    private final Random rand = new Random();

    /**
     * Vytvori nahodneho nepriatela pre carovny les.
     * 
     * @return Nova instancia nepriatela
     */
    @Override
    public EntityPrisera vytvorPriseru() {
        int r = rand.nextInt(3); // 0, 1 alebo 2

        int hp = rand.nextInt(31) + 25;
        int sila = rand.nextInt(11) + 15;

        return switch (r) {
            case 0 -> new EntityPriseraLesij("Lesny muzik", hp, sila);
            case 1 -> new EntityPriseraJezibaba("Jezibaba", hp + 10, sila);
            default -> new EntityPriseraDivozienka("Divozienka", hp - 5, sila + 5);
        };
    }
}