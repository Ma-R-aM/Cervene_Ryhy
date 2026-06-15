import java.util.Random;

/**
 * Factory pre vytvaranie nepriatelov na pusti.
 * Nahodne vytvara jedneho z troch typov nepriatelov:<br>
 * - Skorpion<br>
 * - Mumia (dokaze zapalit hraca)<br>
 * - Had<br>
 * 
 * @see FactoryPrisera
 */
public class FactoryPustPrisera implements FactoryPrisera {
    /** Generator nahodnych cisiel */
    private final Random rand = new Random();

    /**
     * Vytvori nahodneho nepriatela pre pust.
     * 
     * @return Nova instancia nepriatela
     */
    @Override
    public EntityPrisera vytvorPriseru() {
        int r = rand.nextInt(3); // 0, 1 alebo 2

        int hp = rand.nextInt(21) + 20;
        int sila = rand.nextInt(6) + 10;

        return switch (r) {
            case 0 -> new EntityPriseraSkorpion("Skorpion", hp-15, sila*2);
            case 1 -> new EntityPriseraMumia("Mumia", hp+20, sila);
            default -> new EntityPriseraHad("Had", hp, sila+5);
        };
    }
}