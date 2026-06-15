/**
 * Trieda EntityPriseraSkorpion reprezentuje skorpiona ako nepriatela.
 * Jedovaty element - pri utoku moze otravit hraca.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraSkorpion extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie skorpiona.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraSkorpion(String meno, int hp, int sila) { super(meno, hp, sila, Element.Jedovaty); }

    @Override
    public String getCestaKObrazku() { return "/pic/Skorpion.png"; }
}
