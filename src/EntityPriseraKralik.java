/**
 * Trieda EntityPriseraKralik reprezentuje nepriatela - kralika.
 * Zivocich na cistinke, ma normalny element.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraKralik extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie kralika.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraKralik(String meno, int hp, int sila) { super(meno, hp, sila, Element.Normalny); }

    @Override
    public String getCestaKObrazku() { return "/pic/Kralik.png"; }
}
