/**
 * Trieda EntityPriseraVodnik reprezentuje vodnika ako nepriatela.
 * Bytost pri vode, ma vodny element.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraVodnik extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie vodnika.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraVodnik(String meno, int hp, int sila) { super(meno, hp, sila, Element.Vodny); }

    @Override
    public String getCestaKObrazku() { return "/pic/Vodnik.png"; }
}
