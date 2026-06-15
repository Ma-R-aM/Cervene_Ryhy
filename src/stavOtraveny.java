import java.io.Serializable;

/**
 * Trieda stavOtraveny reprezentuje stav otravy entity.
 * Entita v tomto stave:<br>
 * - Nemoze utocit<br>
 * - Kazde kolo prijima poskodenie od jedu<br>
 * - Trvanie otravy je obmedzene (automaticky sa ukonci po vyprsani)<br>
 * 
 * @see Stav
 */
public class stavOtraveny implements Stav, Serializable {
    /** Pocet kol, pocas ktorych otrava trva */
    private int trvanieOtravenia = 2;
    /** Poskodenie jedu na kolo */
    private int poskodenie = 5;
    
    /**
     * Otraveny stav znemoznuje utocenie.
     * 
     * @return false
     */
    @Override
    public boolean mozeUtocit() {
        return false;
    }

    /**
     * Vykonava ucinok otravy -pridava poskodenie a znizuje trvanie.
     * 
     * @param entita Entita, na ktoru sa aplikuje ucinok
     */
    @Override
    public void vykonajEfekty(Entity entita) {
        entita.prijmiPoskodenie(poskodenie);
        //System.out.print("JED");
        trvanieOtravenia--;
    }

@Override
    public String getnazovStavu() { return "otraveny"; }
    public int getTrvanieOtravenia() { return trvanieOtravenia; }
    public int getPoskodenie() { return poskodenie; }
}