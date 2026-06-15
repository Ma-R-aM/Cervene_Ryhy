/**
 * Trieda UrovenPust reprezentuje uroven "pust" v hre.
 * Posledna uroven s najtazsim nepriatelom. Hrac dostane regeneracny lektvar,
 * silnu zbran, ale aj poskodenie od tepla.
 * 
 * @see Uroven
 */
public class UrovenPust extends Uroven
{
    /**
     * Konstruktor pre vytvorenie urovne pust.
     * 
     * @param nazov Nazov urovne
     * @param nepriatel Nepriatel na urovni
     * @param popisUrovne Pribehovy text
     * @param pathToCutPic Cesta k obrazku
     */
    public UrovenPust(String nazov, EntityPrisera nepriatel, String popisUrovne, String pathToCutPic)
    {
        super(nazov, nepriatel, popisUrovne, pathToCutPic);
    }

    /**
     * Vykonava ucinok pri vstupe na uroven.
     * Pridava regeneracny lektvar, silnu zbran a poskodenie od slnka.
     * 
     * @param entityHrac Hrac vstupujuci na uroven
     */
    @Override
    public void efekt(EntityHrac entityHrac)
    {
        entityHrac.pridajDoInventara(new LektvarRegen("Carovne bylinky", 30, 5));
        entityHrac.pridajDoInventara(new Zbran("Kopija", 10, Material.Kov));
        int poskodenie = 10;
        //System.out.println("Slnko ta pripravilo o " + poskodenie + " HP!");
        entityHrac.prijmiPoskodenie(poskodenie);

    }


}
