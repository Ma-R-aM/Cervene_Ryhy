/**
 * Rozhranie Observer - vzor Observer pre sledovanie zmeny zdravia.
 * Pouziva sa na notifikaciu GUI o zmene zdravia entity.
 * Funkcne rozhranie (functional interface) pre pouzitie s lambdami.
 * 
 * @see Entity
 * @see EntityHrac
 */
@FunctionalInterface
public interface Observer {
    /**
     * Metoda volana pri zmene zdravia sledovanej entity.
     * 
     * @param aktualneHP Aktualna hodnota zdravia
     */
    void aktualizuj(int aktualneHP);
}
