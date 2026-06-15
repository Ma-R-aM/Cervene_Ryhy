/**
 * Trieda EntityPrisera predstavuje nepriatela v hre.
 * Dedi z triedy Entity a reprezentuje rozne typy nepriatelov s rozlicnymi elementami.
 * Kazdy nepriatel ma priradeny element (ohnivy, vodny, normalny, elektricky, jedovaty).
 * 
 * @see Entity
 * @see Element
 */
public class EntityPrisera extends Entity
{
    /** Serial version UID pre serializaciu */
    private static final long serialVersionUID = 1L;
    /** Element nepriatela (urcuje specialne schopnosti a efekty) */
    private Element element;

    /**
     * Konstruktor pre vytvorenie nepriatela s parametrami.
     * 
     * @param meno Meno nepriatela
     * @param zdravie Pociatocne zdravie nepriatela
     * @param sila Sila utoku nepriatela
     * @param element Element nepriatela
     */
    public EntityPrisera(String meno, int zdravie, int sila, Element element)
    {
        super(meno, zdravie, sila);
        this.element = element;
    }

    /**
     * Konstruktor s predvolenymi hodnotami.
     * Vytvori nepriatela so zakladnymi statistikami a ohnivym elementom.
     * 
     * @param meno Meno nepriatela
     */
    public EntityPrisera(String meno)
    {
        super(meno, 500, 50);
        element = Element.Ohnivy;
    }

    /**
     * Vrati silu utoku nepriatela.
     * 
     * @return Sila utoku
     */
    @Override
    public int getSilaUtoku() { return this.sila; }
    public void setSilaUtoku(int sila) { this.sila = sila; }
    public Element getElement() { return element; }
    public String getCestaKObrazku() { return "/pic/Error.png"; }
    @Override
    public void aktualizuj(int aktualneHP) { }
    public void setElement(Element element) { this.element = element; }
}