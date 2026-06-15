/**
 * Vlastna vynimka pre neplatnu cestu k suboru.
 * Pouziva sa pri nacitavani obrazkov v GUI.
 * 
 * @see RuntimeException
 */
public class ChybaNeplatnaCesta extends RuntimeException{
    /**
     * Konstruktor s chybovou spravou.
     * 
     * @param error Popis chyby
     */
    public ChybaNeplatnaCesta(String error) { super(error); System.out.println("!!!Error pri ceste pre fotky!!!"); }
}
