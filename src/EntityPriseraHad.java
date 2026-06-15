/**
 * Trieda EntityPriseraHad reprezentuje hada ako nepriatela.
 * Jedovaty element - pri utoku moze otravit hraca.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraHad extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie hada.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraHad(String meno, int hp, int sila) { super(meno, hp, sila, Element.Jedovaty); }

    @Override
    public String getCestaKObrazku() { return "/pic/Had.png"; }
}
