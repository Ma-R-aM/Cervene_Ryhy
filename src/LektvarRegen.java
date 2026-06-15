/**
 * Trieda LektvarRegen dedi z Lektvar a reprezentuje regeneracny lektvar.
 * Na rozdiel od bezneho lektvaru, Regeneracny lektvar poskytuje zdravie aj postupne
 * kazde kolo pocas trvania ucinku - tretina ucinku lektvaru.
 * 
 * @see Lektvar
 */
public class LektvarRegen extends Lektvar{
    /** Serial version UID pre serializaciu */
    private static final long serialVersionUID = 1L;
    /** Pocet kol, pocas ktorych trva regeneracia */
    private int trvanie;
    /** Sila liecenia na jedno kolo */
    private int regenLiecenie;
    
    /**
     * Konstruktor pre vytvorenie regeneracneho lektvaru.
     * Sila liecenia delena tromi je sila liecenia regeneraciou.
     * 
     * @param nazov Nazov lektvaru
     * @param silaLiecenia Celkova sila liecenia
     * @param trvanie Pocet kol trvania regeneracie
     */
    public LektvarRegen(String nazov, int silaLiecenia, int trvanie) //regeneracny lektvar, dedi z lektvaru, pouzivaju sa gettery pre zistenie jeho sily a trvania
    {
        super(nazov, silaLiecenia);
        this.trvanie = trvanie;
        this.regenLiecenie = silaLiecenia/3;
    }

    public int getRegenLiecenie() { return regenLiecenie; }
    public int getTrvanie() { return trvanie; }
}
