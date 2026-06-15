import java.io.Serializable;
import java.time.Duration;

/**
 * Trieda HernyStav reprezentuje ulozeny stav hry.
 * Pouziva sa pri ukladani a nacitavani hry - obsahuje:<br>
 * - hraca<br>
 * - aktualnu uroven<br>
 * - cas trvania hry<br>
 * 
 * @see EntityHrac
 * @see Uroven
 */
public class HernyStav implements Serializable {
    /** Serial version UID pre serializaciu */
    private static final long serialVersionUID = 1L;

    /** Ulozeny hrac */
    private EntityHrac entityHrac;
    /** Aktualna uroven */
    private Uroven aktualnaUroven;
    /** Ulozeny cas v milisekundach */
    private long ulozeneMillisekundy;

    /**
     * Konstruktor pre vytvorenie herneho stavu.
     * 
     * @param entityHrac Hrac
     * @param aktualnaUroven Aktualna uroven
     */
    public HernyStav(EntityHrac entityHrac, Uroven aktualnaUroven) {
        this.entityHrac = entityHrac;
        this.aktualnaUroven = aktualnaUroven;
    }

    public EntityHrac getEntityHrac() { return entityHrac; }
    public Uroven getAktualnaUroven() { return aktualnaUroven; }
    public void setTrvanie(Duration trvanie) { this.ulozeneMillisekundy = trvanie.toMillis(); }
    public long getUlozeneMillisekundy() { return ulozeneMillisekundy; }
}