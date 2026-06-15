/**
 * Trieda EntityPriseraKobylka reprezentuje nepriatela - kobylku.
 * Hmyz na cistinke, ma normalny element.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraKobylka extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie kobylky.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraKobylka(String meno, int hp, int sila) { super(meno, hp, sila, Element.Normalny); }

    @Override
    public String getCestaKObrazku() { return "/pic/Kobylka.png"; }
}
