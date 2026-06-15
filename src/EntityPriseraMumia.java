/**
 * Trieda EntityPriseraMumia reprezentuje mumiu ako nepriatela.
 * Ohnivy element - pri utoku moze zapalit hraca.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraMumia extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie mumie.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraMumia(String meno, int hp, int sila) { super(meno, hp, sila, Element.Ohnivy); }

    @Override
    public String getCestaKObrazku() { return "/pic/Mumia.png"; }
}
