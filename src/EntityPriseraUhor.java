/**
 * Trieda EntityPriseraUhor reprezentuje elektrickeho uhora.
 * Ma elektricky element - pri utoku s kovovou zbranou moze zelekrizovat hraca.
 * Vo factory ma nastavenu nulovu silu na zvysenie interaktivity.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraUhor extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie uhora.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku (typicky 0 z factory)
     */
    public EntityPriseraUhor(String meno, int hp, int sila) { super(meno, hp, sila, Element.Elektricky); }

    @Override
    public String getCestaKObrazku() { return "/pic/Uhor.png"; }
}
