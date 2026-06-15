/**
 * Rozhranie Stav definuje spolocne spravanie rozlicnych stavov entity.
 * Kazdy stav ma vlastnosti:<br>
 * - ci entity moze utocit<br>
 * - ake efekty vykonava na entity<br>
 * - nazov stavu pre zobrazenie<br>
 * 
 * Implementacie: stavNormalny, stavZapaleny, stavOtraveny, stavZelektrizovany
 * 
 * @see Entity
 */
public interface Stav {
    /**
     * Kontroluje, ci moze entita v tomto stave utocit.
     * Niektore stavy (zapaleny a otraveny) znemoznuju utok.
     * 
     * @return true ak moze utocit
     */
    boolean mozeUtocit();
    
    /**
     * Vykonava ucinky stavu na entity.
     * Napr. otraveny stav ubera zdravie kazde kolo.
     * 
     * @param entita Entita, na ktoru sa aplikuju ucinky
     */
    void vykonajEfekty(Entity entita);
    
    /**
     * Vracia nazov stavu ako string.
     * 
     * @return Nazov stavu
     */
    String getnazovStavu();
}