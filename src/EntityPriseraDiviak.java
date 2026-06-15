/**
 * Trieda EntityPriseraDiviak reprezentuje nepriatela - diviaka.
 * Zivocich v lese, ma normalny element.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraDiviak extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie diviaka.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraDiviak(String meno, int hp, int sila) { super(meno, hp, sila, Element.Normalny); }

    @Override
    public String getCestaKObrazku() { return "/pic/Diviak.png"; }
}
