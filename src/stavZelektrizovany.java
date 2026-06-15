import java.io.Serializable;

/**
 * Nastava ak je nepriatel elektricky a hrac nanho utoci kovovou zbranou.
 * Nepriatel udeli hracovi poskodenie rovne hracovemu zdraviu.
 * 
 * @see Stav
 */
public class stavZelektrizovany implements Stav, Serializable {
    /**
     * Zelektrizovany stav znemoznuje utocenie.
     * 
     * @return false
     */
    @Override
    public boolean mozeUtocit() {
        return false;
    }

    @Override
    public void vykonajEfekty(Entity entita) { }
    @Override
    public String getnazovStavu() { return "je zelektrizovany, umiera"; }
}
