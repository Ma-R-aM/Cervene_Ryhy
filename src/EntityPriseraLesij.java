/**
 * Trieda EntityPriseraLesij reprezentuje lesneho muzika ako nepriatela.
 * Magicka bytost v carovnom lese, ma normalny element.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraLesij extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie lesneho muzika.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraLesij(String meno, int hp, int sila) { super(meno, hp, sila, Element.Normalny); }

    @Override
    public String getCestaKObrazku() { return "/pic/Lesij.png"; }
}
