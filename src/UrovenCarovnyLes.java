/**
 * Magicka uroven s lektvarom a bonusovym zdravim.
 * 
 * @see Uroven
 */
public class UrovenCarovnyLes extends Uroven
{
    /**
     * Konstruktor pre vytvorenie urovne carovny les.
     * 
     * @param nazov Nazov urovne
     * @param nepriatel Nepriatel na urovni
     * @param popisUrovne Pribehovy text
     * @param pathToCutPic Cesta k obrazku
     */
    public UrovenCarovnyLes(String nazov, EntityPrisera nepriatel, String popisUrovne, String pathToCutPic)
    {
        super(nazov, nepriatel, popisUrovne, pathToCutPic);
    }

    /**
     * Vykonava ucinok pri vstupe na uroven.
     * Pridava hracovi lektvar a bonusove zdravie.
     * 
     * @param entityHrac Hrac vstupujuci na uroven
     */
    @Override
    public void efekt(EntityHrac entityHrac)
    {
        entityHrac.pouziLektvar(10);
        entityHrac.pridajDoInventara(new Lektvar("Kostihoj", 40));
    }


}
