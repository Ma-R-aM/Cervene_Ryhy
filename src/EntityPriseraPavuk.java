/**
 * Trieda EntityPriseraPavuk reprezentuje nepriatela - pavuka.
 * Jedovaty element, pri utoku moze otravit hraca.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraPavuk extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie pavuka.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraPavuk(String meno, int hp, int sila) { super(meno, hp, sila, Element.Jedovaty ); }

    @Override
    public String getCestaKObrazku() { return "/pic/Pavuk.png"; }

}
