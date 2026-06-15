import java.util.ArrayList; //potrebujeme importovat kniznicu kvoli praci s dynamickym polom

/**
 * Trieda EntityHrac predstavuje hraca v hre.
 * Dedi z triedy Entity a pridava funkcionalitu pre inventar, vybavenie a lektvary.
 * Hrac ma schopnost bojovat, pouzivat vybavenie a regenerovat zdravie.
 * 
 * @see Entity
 * @see Vybavenie
 * @see Zbran
 * @see Lektvar
 */
public class EntityHrac extends Entity {
    /** Serial version UID pre serializaciu */
    private static final long serialVersionUID = 1L;
    /** Zoznam vybavenia hraca */
    private ArrayList<Vybavenie> inventar;
    /** Aktualne vybavena zbran */
    private Zbran vybavenaZbran; // vieme si takto rovno vybrat zbran, s ktorou mozeme bojovat
    /** Zakladna sila hraca bez zbrane */
    private int sila;
    /** Pocet kol, pocas ktorych trva regeneracia */
    private int zostavajuceKolaPreRegen = 0;
    /** Sila regeneracie na kolo */
    private int silaRegen;


    /**
     * Konstruktor pre vytvorenie hraca.
     * Inicializuje meno, zdravie, silu a prazdny inventar.
     * 
     * @param meno Meno hraca
     * @param zdravie Pociatocne zdravie hraca
     * @param sila Zakladna sila utoku hraca
     */
    public EntityHrac(String meno, int zdravie, int sila) {
        super(meno, zdravie, sila);
        this.inventar = new ArrayList<>();
        this.sila = sila;
    }


    /**
     * Pouzije lektvar na hraca a odstrani ho z inventara.
     * 
     * @param lektvar Lektvar na pouzitie
     */
    public void pouziLektvar(Lektvar lektvar) {
        lektvar.pouzi(this);
        //System.out.println(lektvar.getNazov() + " bol spotrebovany.");
        odstranZInventara(lektvar);
        upozorniObserverov();
    }

    /**
     * Pretazena metoda na pouzitie lektvaru s priamym poctom HP.
     * Namiesto objektu Lektvar sa pouzije len hodnota zdravia na pridanie.
     * 
     * @param HP Pocet HP na pridanie
     */
    public void pouziLektvar(int HP) {//pretazenie, ked chceme hracovi pridat urcity pocet zdravia
        Lektvar.pouzi(this, HP);
        upozorniObserverov();
    }

    /**
     * Prida predmet do inventara hraca.
     * Ak je predmet zbran, automaticky sa stane vybavenou zbranou.
     * 
     * @param predmet Predmet na pridanie do inventara
     */
    public void pridajDoInventara(Vybavenie predmet) {
        this.inventar.add(predmet);
        //System.out.println(this.getMeno() + " ziskal " + predmet.getNazov());
        if(predmet instanceof Zbran)
            vybavenaZbran = (Zbran) predmet;
    }

    /**
     * Pouzije predmet z inventara podla indexu.
     * Vracia 1 ak sa jedna o zbran, 2 ak sa jedna o lektvar, -1 ak doslo k chybe.
     * 
     * @param index Index predmetu v inventari
     * @return Typ pouziteho predmetu (1=zbran, 2=lektvar, -1=chyba)
     */
    public int pouziZInventara(int index) {
        if(index >= 0 && index < inventar.size())
        {

            Vybavenie predmet = inventar.get(index);
            //System.out.println("Vybral si z inventara " + predmet.getNazov());

            if(predmet instanceof Zbran)
            {
                vybavenaZbran = (Zbran) predmet;
                return 1;
            }

            else if (predmet instanceof Lektvar)
            {
                pouziLektvar((Lektvar) predmet);
                upozorniObserverov();
                return 2;
            }

            else
            {
                //System.out.println("Nieco je tu velmi zle!!! zly typ predmetu a to by sa fakt ze nemalo stat, kontaktujte spravcu projektu (mna) a asi zacnem plakat");
                return -1;
            }
        }
        return 0;
    }

    /**
     * Odstrani predmet z inventara hraca.
     * 
     * @param predmet Predmet na odstranenie
     */
    public void odstranZInventara(Vybavenie predmet) {
        this.inventar.remove(predmet);
        //System.out.println("Uz nemas v inventari " + predmet.getNazov());
    }


    /**
     * Pretazena metoda na prijatie poskodenia.
     * Notifikuje observerov po aplikacii poskodenia.
     * 
     * @param poskodenie Hodnota poskodenia
     */
    @Override
    public void prijmiPoskodenie(int poskodenie) {
        super.prijmiPoskodenie(poskodenie);
        upozorniObserverov();
    }

    public Zbran getVybavenaZbran() { return vybavenaZbran; }
    public void setVybavenaZbran(Zbran vybavenaZbran) { this.vybavenaZbran = vybavenaZbran; }

    @Override
    public int getSilaUtoku() {
        if(vybavenaZbran == null)
            return (this.sila);
        else
            return (this.sila + vybavenaZbran.getBonusovePoskodenie());
    }
    public void setSilaUtoku(int sila) { this.sila = sila; }
    public ArrayList<Vybavenie> getInventar() { return inventar; }
    public void setInventar(ArrayList<Vybavenie> inventar) { this.inventar = inventar; }

    public void setRegen(int kola, int sila) {
        this.zostavajuceKolaPreRegen = kola;
        this.silaRegen = sila;
    }
    public int getZostavajuceKolaPreRegen() { return zostavajuceKolaPreRegen; }
    public int getSilaRegen() { return silaRegen; }
    public void znizRegenKolo() { this.zostavajuceKolaPreRegen--; }
    @Override
    public void aktualizuj(int aktualneHP) { }
}