/**
 * Uroven v ktorej hrac dostane lektvar.
 * 
 * @see Uroven
 */
public class UrovenCistinka extends Uroven
{
    /**
     * Konstruktor pre vytvorenie urovne cistinka.
     * 
     * @param nazov Nazov urovne
     * @param nepriatel Nepriatel na urovni
     * @param popisUrovne Pribehovy text
     * @param pathToCutPic Cesta k obrazku
     */
    public UrovenCistinka(String nazov, EntityPrisera nepriatel, String popisUrovne, String pathToCutPic)
    {
        super(nazov, nepriatel, popisUrovne, pathToCutPic);
    }

    /**
     * Vykonava ucinok pri vstupe na uroven.
     * Pridava hracovi lektvar.
     * 
     * @param entityHrac Hrac vstupujuci na uroven
     */
    @Override
    public void efekt(EntityHrac entityHrac)
    {
        //System.out.println("Gratulujem k porazeniu toho vlka. Mas stastie ze bol vychudnuty, inak by si s tou palicou nemal velku sancu. \nIdes dalej cez les, nasiel si pohodenu kovovu tyc. Zdvihnes ju, pokracujes a vidis, ako sa les zmeni na cistinku. \nZrazu sa nad tebou ztmavilo. Preletel nad tebou obrovsky Havran. \nRuti sa k tebe zobakom a vsimol si si jeho velke cervene oci.\n");
        entityHrac.pridajDoInventara(new Lektvar("Praslicka rolna", 25));
    }


}
