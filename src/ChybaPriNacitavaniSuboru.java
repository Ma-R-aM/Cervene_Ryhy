/**
 * Vlastna vynimka pre chyby pri nacitavani suboru.
 * Pouziva sa pri nacitavani suboru ulozenej hry.
 * 
 * @see RuntimeException
 */
public class ChybaPriNacitavaniSuboru extends RuntimeException {
    /**
     * Konstruktor so spravou chyby.
     * 
     * @param sprava Popis chyby
     */
    public ChybaPriNacitavaniSuboru(String sprava) { super(sprava); }
}