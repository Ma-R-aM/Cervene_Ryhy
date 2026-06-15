/**
 * Toto je prva uroven, kde hrac dostane zakladne vybavenie.
 * 
 * @see Uroven
 */
public class UrovenLes extends Uroven
{
    /**
     * Konstruktor pre vytvorenie urovne les.
     * 
     * @param nazov Nazov urovne
     * @param nepriatel Nepriatel na urovni
     * @param popisUrovne Pribehovy text
     * @param pathToCutPic Cesta k obrazku
     */
    public UrovenLes(String nazov, EntityPrisera nepriatel, String popisUrovne, String pathToCutPic)
    {
        super(nazov, nepriatel, popisUrovne, pathToCutPic);
    }

    /**
     * Vykonava ucinok pri vstupe na uroven.
     * Pridava hracovi zakladnu zbran a lektvar.
     * 
     * @param entityHrac Hrac vstupujuci na uroven
     */
    @Override
    public void efekt(EntityHrac entityHrac)
    {
        //System.out.println("Vitaj " + entityHrac.getMeno() + " na zaciatku tvojej vypravy! Nachadzas sa v nie velmi zarastenom lese. Pocasie je pekne, svieti slnko, je bez mrakov. \nPrechadzas sa lesom za dobrodruzstvom, ked v tom zazres, ako k tebe bezi mlady vlk. Uz dlho nejedol, je mu vidno rebra. \nPre teba je to dobra sprava, pretoze je slaby a nema vela energie. \nZdvihol si cerstvo padnutu palicu a pripravil si sa na suboj proti tomuto vlkovi.\n");
        entityHrac.pridajDoInventara(new Zbran("Dlha palica", 1, Material.Drevo));
        entityHrac.pridajDoInventara(new Lektvar("Mysi chvost", 15));
    }


}
