import java.io.Serializable;

/**
 * Abstraktna trieda,
 * kazda uroven ma nazov, nepriatela, popis a cestu k obrazku.
 * Urovne su prepojene do zoznamu za sebou v poradi cez nasledujucaUroven.
 * Implementuje Serializable pre ukladanie stavu.
 * 
 * @see EntityPrisera
 */
public abstract class Uroven implements Serializable
{
    /** Serial version UID pre serializaciu */
    private static final long serialVersionUID = 1L;
    /** Nazov urovne */
    private String nazov;
    /** Nepriatel na tejto urovni */
    private EntityPrisera nepriatel;
    /** Pribehovy text zobrazovany pred bojom */
    private String popisUrovne;
    /** Cesta k obrazku cutsceny */
    private String pathToCutPic;
    /** Nasledujuca uroven v postupnosti */
    private Uroven nasledujucaUroven;

    /**
     * Konstruktor pre vytvorenie urovne.
     * 
     * @param nazov Nazov urovne
     * @param nepriatel Nepriatel na tejto urovni
     * @param popisUrovne Pribehovy text
     * @param pathToCutPic Cesta k obrazku
     */
    public Uroven(String nazov, EntityPrisera nepriatel, String popisUrovne, String pathToCutPic)
    {
        this.nazov = nazov;
        this.nepriatel = nepriatel;
        this.popisUrovne = popisUrovne;
        this.pathToCutPic = pathToCutPic;
    }

    /**
     * Abstraktna metoda pre vykonanie ucinku urovne pri vstupe.
     * Kazda podtrieda implementuje vlastne ucinky (napr pridanie vybavenia).
     * 
     * @param entityHrac Hrac vstupujuci na uroven
     */
    public abstract void efekt(EntityHrac entityHrac);

    public String getNazov() { return this.nazov; }
    public EntityPrisera getNepriatel() { return this.nepriatel; }
    public Uroven getNasledujucaUroven() { return nasledujucaUroven; }
    public void setNasledujucaUroven(Uroven nasledujucaUroven) { this.nasledujucaUroven = nasledujucaUroven; }
    public String getPopisUrovne() { return popisUrovne; }
    public String getPathToCutPic() { return pathToCutPic; }
}
