import java.io.Serializable;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstraktna trieda Entity reprezentuje vsetky entity v hre, ci uz hracov alebo nepriatelov.
 * Tato trieda obsahuje spolocne vlastnosti ako meno, zdravie, sila a stav entity.
 * Implementuje rozhranie Observer pre oznamovanie zmien zdravia a Serializable pre ukladanie hry.
 * 
 * @see Observer
 */
public abstract class Entity implements Observer, Serializable
{
    /** Meno entity */
    final String meno;
    /** Statistika zdravia s minimom a maximom */
    private Stat<Integer> zdravieStat;
    /** Sila utoku entity */
    protected int sila;
    /** Aktualny stav entity (normalny, zapaleny, otraveny, etc.) */
    private Stav aktualnyStav = new stavNormalny();
    /** Zoznam observerov, ktori sleduju zmeny zdravia */
    private transient List<Observer> observerList;
    /** Serial version UID pre serializaciu */
    private static final long serialVersionUID = 1L;

    /**
     * Implementovana metoda pre deserializaciu objektu.
     * Inicializuje observerList po nacitani objektu zo suboru.
     * 
     * @param ois ObjectInputStream pre citanie serializovanych dat
     * @throws Exception ak nastane chyba pri citani
     */
    private void readObject(ObjectInputStream ois) throws Exception {
        ois.defaultReadObject();
        observerList = new ArrayList<>();
    }

    /**
     * Konstruktor pre vytvorenie novej entity.
     * Inicializuje meno, zdravie, silu a observer zoznam.
     * 
     * @param meno Meno entity
     * @param zdravie Pociatocna hodnota zdravia
     * @param sila Sila utoku entity
     */
    public Entity(String meno, int zdravie, int sila)
    {
        this.meno = meno;
        this.zdravieStat = new Stat<>(zdravie, 0, zdravie);
        this.sila = sila;
        this.observerList = new ArrayList<>();
    }

    /**
     * Abstraktna metoda pre ziskanie sily utoku.
     * Kazda podtrieda musi implementovat vlastnu logiku vypoctu sily.
     * 
     * @return Sila utoku entity
     */
    public abstract int getSilaUtoku();

    /**
     * Vykonava utok na cielovu entity.
     * Udeluje poskodenie rovne sile utoku a notifikuje observerov.
     * 
     * @param ciel Cil entity, na ktoru sa utoca
     */
    public void utoc(Entity ciel)
    {
        ciel.prijmiPoskodenie(getSilaUtoku());
        upozorniObserverov();
    }

    /**
     * Spracovanie poskodenia entity.
     * Odcita hodnotu poskodenia zo zdravia a notifikuje observerov.
     * 
     * @param poskodenie Hodnota poskodenia na odpocitanie
     */
    public void prijmiPoskodenie(int poskodenie)
    {
        this.zdravieStat.odcitaj(poskodenie);
        upozorniObserverov();
    }


    /**
     * Pridava noveho observera na sledovanie zmien zdravia.
     * 
     * @param o Observer, ktory ma byt pridany
     */
    public void pridajObserver(Observer o) {
        observerList.add(o);
        o.aktualizuj(this.zdravieStat.getHodnota());
    }

    /**
     * Notifikuje vsetkych observerov o zmene zdravia.
     */
    protected void upozorniObserverov() {
        for(Observer o : observerList)
            o.aktualizuj(this.zdravieStat.getHodnota());
    }

    public String getMeno() { return meno; }
    public int getZdravie() { return zdravieStat.getHodnota(); }
    public void setZdravie(int zdravie) { this.zdravieStat.setHodnota(zdravie); }
    public int getMaxZdravie() { return zdravieStat.getMaxHodnota(); }
    public void setMaxZdravie(int maxZdravie) { this.zdravieStat = new Stat<>(this.zdravieStat.getHodnota(), 0, maxZdravie); }
    public Stav getStav() { return this.aktualnyStav; }
    public void setStav(Stav novyStav) { this.aktualnyStav = novyStav; }


}
