/**
 * Trieda EntityPriseraJezibaba reprezentuje jezibabu ako nepriatela.
 * Magicka bytost v carovnom lese, ma normalny element.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraJezibaba extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie jezibaby.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraJezibaba(String meno, int hp, int sila) { super(meno, hp, sila, Element.Normalny); }

    @Override
    public String getCestaKObrazku() { return "/pic/Jezibaba.png"; }
}
