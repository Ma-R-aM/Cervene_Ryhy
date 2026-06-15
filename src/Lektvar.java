
/**
 * Trieda Lektvar dedi z Vybavenie a reprezentuje liecivy lektvar v hre.
 * Lektvar pridava zdravie cielovej entite, maximalne do jej maximalneho zdravia - maxZdravie.
 * 
 * @see Vybavenie
 * @see EntityHrac
 */
public class Lektvar extends Vybavenie {
    /** Serial version UID pre serializaciu */
    private static final long serialVersionUID = 1L;
    /** Sila liecenia (pocet HP na pridanie) */
    final int silaLiecenia;

    /**
     * Konstruktor pre vytvorenie lektvaru.
     * 
     * @param nazov Nazov lektvaru
     * @param silaLiecenia Sila liecenia v HP
     */
    public Lektvar(String nazov, int silaLiecenia) {
        super(nazov);
        this.silaLiecenia = silaLiecenia;
    }

    /**
     * Aplikuje liecenie na cielovu entitu.
     * Prida silaLiecenia k zdraviu, ale nie viac ako maxZdravie.
     * 
     * @param ciel Cilova entita na liecenie
     */
    public void pouzi(Entity ciel) {
        int noveZdravie = ciel.getZdravie() + silaLiecenia;
        if(noveZdravie > ciel.getMaxZdravie())
            noveZdravie = ciel.getMaxZdravie();
        ciel.setZdravie(noveZdravie);
    }

    /**
     * Pridanie zdravia entite o pevny pocet.
     * 
     * @param ciel Cilova entita na liecenie
     * @param silaLiecenia Pocet HP na pridanie
     */
    public static void pouzi(Entity ciel, int silaLiecenia) {
        int noveZdravie = ciel.getZdravie() + silaLiecenia;
        if(noveZdravie > ciel.getMaxZdravie())
            noveZdravie = ciel.getMaxZdravie();
        ciel.setZdravie(noveZdravie);
    }

    public int getSilaLiecenia() { return silaLiecenia; }
}