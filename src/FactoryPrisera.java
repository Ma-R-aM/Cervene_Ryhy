/**
 * Je sucastou vzoru Factory na vytvaranie nepriatelov.
 * Kazda uroven ma vlastnu factory, ktora vytvara specifickych nepriatelov.
 * 
 * Implementacie: FactoryLesPrisera, FactoryCistinkaPrisera...
 * 
 * @see EntityPrisera
 */
public interface FactoryPrisera {
    /**
     * Vytvori a vrati novu instanciu nepriatela.
     * 
     * @return Nova instancia EntityPrisera
     */
    EntityPrisera vytvorPriseru();
}
