/**
 * Trieda EntityPriseraVlk reprezentuje nepriatela - vlka.
 * Zivocich v lese, ma normalny element.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraVlk extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie vlka.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraVlk(String meno, int hp, int sila) { super(meno, hp, sila, Element.Normalny); }

    @Override
    public String getCestaKObrazku() { return "/pic/Vlk.png"; }
}
