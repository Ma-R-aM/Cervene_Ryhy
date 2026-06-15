/**
 * Trieda EntityPriseraDivozienka reprezentuje divozienku ako nepriatela.
 * Magicka bytost v carovnom lese, ma normalny element.
 * 
 * @see EntityPrisera
 */
public class EntityPriseraDivozienka extends EntityPrisera {
    /**
     * Konstruktor pre vytvorenie divozienky.
     * 
     * @param meno Meno nepriatela
     * @param hp Zdravie
     * @param sila Sila utoku
     */
    public EntityPriseraDivozienka(String meno, int hp, int sila) { super(meno, hp, sila, Element.Normalny); }

    @Override
    public String getCestaKObrazku() { return "/pic/Divozienka.png"; }
}
