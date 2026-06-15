/**
 * Trieda EntityPriseraTopivec reprezentuje nepriatela "topivec".
 * Vodna bytost, ma vodny element.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraTopivec extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie topivca.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraTopivec(String meno, int hp, int sila) { super(meno, hp, sila, Element.Vodny); }

    @Override
    public String getCestaKObrazku() { return "/pic/Topivec.png"; }
}
