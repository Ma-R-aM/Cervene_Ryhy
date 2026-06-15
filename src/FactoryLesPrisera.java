import java.util.Random;

/**
 * Factory pre vytvaranie nepriatelov v lesnej urovni.
 * Nahodne vytvara jedneho z troch typov nepriatelov:<br>
 * - Vlk<br>
 * - Diviak<br>
 * - Pavuk<br>
 * 
 * @see FactoryPrisera
 * @see EntityPriseraVlk
 * @see EntityPriseraDiviak
 * @see EntityPriseraPavuk
 */
public class FactoryLesPrisera implements FactoryPrisera {
    /** Generator nahodnych cisiel */
    private final Random rand = new Random();

    /**
     * Vytvori nahodneho nepriatela pre lesnu uroven.
     * 
     * @return Nova instancia nepriatela
     */
    @Override
    public EntityPrisera vytvorPriseru() {
        int r = rand.nextInt(3); // 0, 1 alebo 2

        int hp = rand.nextInt(11) + 10;
        int sila = rand.nextInt(6) + 5;

        return switch (r) {
            case 0 -> new EntityPriseraVlk("Tulavy vlk", hp, sila+5);
            case 1 -> new EntityPriseraDiviak("Zurivy diviak", hp + 10, sila - 3);
            default -> new EntityPriseraPavuk("Lesny pavuk", hp - 5, sila + 3);
        };
    }
}