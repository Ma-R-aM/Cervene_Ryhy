import java.io.Serializable;

/**
 * Abstraktna trieda Vybavenie reprezentuje vsetky predmety v hre.
 * Je to zakladna trieda pre zbran a lektvary.
 * Kazde vybavenie ma nazov a metodu pouzi() pre aplikaciu ucinku na cielovu entitu.
 * 
 * @see Zbran
 * @see Lektvar
 */
public abstract class Vybavenie implements Serializable
{
    /** Serial version UID pre serializaciu */
    private static final long serialVersionUID = 1L;
    /** Nazov vybavenia */
    private String nazov;

    /**
     * Konstruktor pre vytvorenie vybavenia.
     * 
     * @param nazov Nazov vybavenia
     */
    public Vybavenie(String nazov)
    {
        this.nazov = nazov;
    }

    public String getNazov() { return nazov; }
}