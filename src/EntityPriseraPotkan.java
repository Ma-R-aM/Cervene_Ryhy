/**
 * Trieda EntityPriseraPotkan reprezentuje nepriatela - potkana.
 * Zivocich na cistinke, ma normalny element.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraPotkan extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie potkana.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraPotkan(String meno, int hp, int sila) { super(meno, hp, sila, Element.Normalny); }

    @Override
    public String getCestaKObrazku() { return "/pic/Potkan.png"; }
}
