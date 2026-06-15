import java.io.Serializable;

/**
 * Trieda stavZapaleny reprezentuje stav horenia entity.
 * Entita v tomto stave nemoze utocit
 * 
 * @see Stav
 */
public class stavZapaleny implements Stav, Serializable {
    /** Poskodenie od horenia */
    int popalenie = 30;
    
    /**
     * Zapaleny stav znemoznuje utocenie.
     * 
     * @return false
     */
    @Override
    public boolean mozeUtocit() {
        return false;
    }

    /**
     * Vykonava ucinok horenia.
     * 
     * @param entita Entita, na ktoru sa aplikuje ucinok
     */
    @Override
    public void vykonajEfekty(Entity entita) {

        entita.prijmiPoskodenie(popalenie);
        //System.out.println("Bol si zapaleny, horis, ubudlo ti " + popalenie + " HP");
    }

    @Override
    public String getnazovStavu() { return "hori"; }
    public int getPopalenie() { return popalenie; }
}
