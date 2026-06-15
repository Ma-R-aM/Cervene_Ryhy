import java.io.Serializable;

/**
 * Trieda stavNormalny reprezentuje normalny stav entity bez specialnych ucinkov.
 * Je to predvoleny stav, kedy entita moze normalne utocit a nema ziadne negative ucinky.
 * 
 * @see Stav
 */
public class stavNormalny implements Stav, Serializable {
    /**
     * Normalny stav umoznuje utocenie.
     * 
     * @return true
     */
    @Override
    public boolean mozeUtocit() {
        return true;
    }

    @Override
    public void vykonajEfekty(Entity entita) { }
    @Override
    public String getnazovStavu() { return "normalny"; }
}
