/**
 * Hrac ziska kovovu zbran s vyssim poskodenim.
 * 
 * @see Uroven
 */
public class UrovenPotocik extends Uroven
{
    /**
     * Konstruktor pre vytvorenie urovne potocik.
     * 
     * @param nazov Nazov urovne
     * @param nepriatel Nepriatel na urovni
     * @param popisUrovne Pribehovy text
     * @param pathToCutPic Cesta k obrazku
     */
    public UrovenPotocik(String nazov, EntityPrisera nepriatel, String popisUrovne, String pathToCutPic)
    {
        super(nazov, nepriatel, popisUrovne, pathToCutPic);
    }

    /**
     * Vykonava ucinok pri vstupe na uroven.
     * Pridava hracovi kovovu zbran.
     * 
     * @param entityHrac Hrac vstupujuci na uroven
     */
    @Override
    public void efekt(EntityHrac entityHrac)
    {
        //System.out.println("Ten havran ta poriadne prekvapil. Nastatie si si zachoval chladnu hlavu a podarilo sa ti ho porazit.\nV dialke zapocujes potocik, citis smad tak sa vyberies smerom k nemu.\nPo chvili kracania si k nemu dorazil. Ides sa z neho napit ked v tom uvidis nieco dlhe hybat sa vo vode.\nZapozeral si sa a zistil si, ze je to elektricky uhor, ktory sa na teba pripravuje.\n Ty sa potrebujes napit cize ti neostava nic ine, nez si to s nim vyriadit.\n");
        entityHrac.pridajDoInventara(new Zbran("Hrdzava tyc", 6, Material.Kov));
    }
}
