/**
 * Trieda EntityPriseraRusalka reprezentuje rusalku ako nepriatela.
 * Bytost pri vode, ma vodny element.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraRusalka extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie rusalky.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraRusalka(String meno, int hp, int sila) { super(meno, hp, sila, Element.Vodny); }

    @Override
    public String getCestaKObrazku() { return "/pic/Rusalka.png"; }
}
