import java.time.Instant;
import java.time.Duration;
import java.util.Random;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Trieda ManagementHry spravuje celu hru.
 * Obsahuje:<br>
 * -hraca<br>
 * -aktualnu uroven<br>
 * -logiku boja<br>
 * -ukladanie a nacitavanie hry<br>
 * -vsetky urovne hry<br>
 * 
 * @see EntityHrac
 * @see Uroven
 */
public class ManagementHry
{
    private EntityHrac entityHrac;
    private Uroven aktualnaUroven;
    private Instant zaciatokHry;
    private Duration trvanieHry;
    private Random random = new Random();
    long minuty = 0;
    long sekundy = 0;
    private static final Logger logger = LoggerFactory.getLogger(ManagementHry.class);
    private final ExecutorService threadPool = Executors.newSingleThreadExecutor();

    Uroven lvl0 = new UrovenLes(null, null, null, "");
    Uroven lvl1 = new UrovenLes("Svetly les", new FactoryLesPrisera().vytvorPriseru(), ("Vitaj na zaciatku tvojej vypravy! Nachadzas sa v lesiku. Pocasie je pekne, svieti slnko, je bez mrakov. Zrazu pred sebou vidis svojho prveho nepriatela.\nZdvihol si cerstvo padnutu palicu a pripravil si sa na suboj.\n"), "/pic/lvl1.cut.png");
    Uroven lvl2 = new UrovenCistinka("Cistinka", new FactoryCistinkaPrisera().vytvorPriseru(), ("Ides dalej cez les, nasiel si pohodenu kovovu tyc. Zdvihnes ju, pokracujes a vidis, ako sa les meni na cistinku.\nSpokojne si po suboji pokracujes dalej, ked sa v tom zrazu zjavi daco male.\n. Ides si to s nim vyriadit, nebude ti tu nikto krizovat cestu.\n"),"/pic/lvl2.cut.png");
    Uroven lvl3 = new UrovenPotocik("Potocik", new FactoryPotocikPrisera().vytvorPriseru(), ("Toto bolo celkom jednoduche.\nPokracujes vo svojej vyprave a v dialke zapocujes potocik, citis smad a tak sa vyberies smerom k nemu.\nPo chvili kracania si k nemu dorazil. Ides sa z neho napit, ked v tom uvidis hybat sa nieco vo vode.\nTy sa potrebujes napit, cize beries do ruky svoju zbran a ides si vodu vybojovat.\n"),"/pic/lvl3.cut.png");
    Uroven lvl4 = new UrovenCarovnyLes("Myticky les", new FactoryCarovnyLesPrisera().vytvorPriseru(), "Poriadne si sa napil. Presiel si kus cesty a ocitol si sa v tajomnom magickom lese.\nJe to tu carovne, takze never svojmu zraku, pretoze i stromy vedia klamat.\nDrz si odstup a premysli si dva krat kazdy svoj krok.",  "/pic/lvl4.cut.png");
    Uroven lvl5 = new UrovenPust("Pust", new FactoryPustPrisera().vytvorPriseru(), "Poriadne si sa zapotil, na tento zazitok len tak nezabudnes. Vysiel si z carovneho lesa.\nPozeras sa vokol seba a neveris vlastnym ociam. Zjavil si sa zjavil na pusti.\nNestacis sa divit, avsak blizi sa k tebe tvoj posledny nepriatel.", "/pic/lvl5.cut.png");

    public ManagementHry() {
        lvl0.setNasledujucaUroven(lvl1);
        lvl1.setNasledujucaUroven(lvl2);
        lvl2.setNasledujucaUroven(lvl3);
        lvl3.setNasledujucaUroven(lvl4);
        lvl4.setNasledujucaUroven(lvl5);
        lvl5.setNasledujucaUroven(null);

        this.aktualnaUroven = lvl0;
    }

    /**
     * Prejde na dalsiu uroven hry.
     * Ak nasledujuca uroven existuje, nastavi ju ako aktualnu a aplikuje jej efekt.
     * Ak neexistuje, oznaci koniec hry.
     *
     * @return true ak hra skoncila (nema dalsiu uroven), inak false
     */
    public boolean dalsiaUroven() {
        if (aktualnaUroven.getNasledujucaUroven() != null) {
            aktualnaUroven = aktualnaUroven.getNasledujucaUroven();
            aktualnaUroven.efekt(entityHrac);
            return false;
        }
        else {
            vypocitanieCasuHry();
            return true;
        }
    }

    /**
     * Vykona utok hraca na aktualneho nepriatela.
     */
    public void bojHraca() {
        entityHrac.utoc(aktualnaUroven.getNepriatel());
    }

    /**
     * Vykona utok nepriatela na hraca a aplikuje efekty podla elementu:<br>
     * - Ohnive: 25% sanca na zapalenie hraca<br>
     * - Jedovaty: 20% sanca na otravenie hraca<br>
     */
    public void bojNepriatela() {
        aktualnaUroven.getNepriatel().utoc(entityHrac);

        if(aktualnaUroven.getNepriatel().getElement() == Element.Ohnivy){
            if(random.nextInt(100) < 25) {
                entityHrac.setStav(new stavZapaleny());
                logger.debug("Hrac je zapaleny");
            }
        }

        if(aktualnaUroven.getNepriatel().getElement() == Element.Jedovaty){
            if(!(entityHrac.getStav() instanceof stavOtraveny)){
                if(random.nextInt(100) < 20)
                    entityHrac.setStav(new stavOtraveny());
            }
        }
        if(entityHrac.getStav() instanceof stavOtraveny)
            logger.debug("Hrac je otraveny, trvanie: {}", ((stavOtraveny) entityHrac.getStav()).getTrvanieOtravenia());
    }

    /**
     * Spracuje logiku na konci kola.
     * Vykona efekty aktualneho stavu hraca, regeneraciu a odstrani expirovane stavy.
     */
    public void logikaKola() {
        entityHrac.getStav().vykonajEfekty(entityHrac);

        if(entityHrac.getStav() instanceof stavZapaleny)
            entityHrac.setStav(new stavNormalny());

        if(entityHrac.getStav() instanceof stavOtraveny && ((stavOtraveny) entityHrac.getStav()).getTrvanieOtravenia() == 0)
            entityHrac.setStav(new stavNormalny());

        if(entityHrac.getZostavajuceKolaPreRegen() > 0) {
            entityHrac.pouziLektvar(entityHrac.getSilaRegen());
            entityHrac.znizRegenKolo();
            logger.debug("Hracovi bolo pridanych {} HP z regeneracneho lektvaru", entityHrac.getSilaRegen() );
        }
    }

    /**
     * Skontroluje koniec suboja.
     * Vracia:<br>
     * - 2: hrac prehral<br>
     * - 1: nepriatel bol porazeny<br>
     * - 0: suboj pokracuje<br>
     *
     * @return Vysledok suboja
     */
    public int KoniecSuboja() {
        if(entityHrac.getZdravie() <= 0){
            vypocitanieCasuHry();
            return 2;
        }

        else if (aktualnaUroven.getNepriatel().getZdravie() <= 0) {
            entityHrac.pouziLektvar(10);
            return 1;
        }

        else
            return 0;
    }

    /**
     * Skontroluje a aplikuje elektrizaciu.
     * Ak ma nepriatel elektricky element a hrac ma kovovu zbran,
     * hraca zelektrizuje - nepriatel ziska silu rovnu HP hraca.
     */
    public void skontrolujZelektrizovanie() {
        if (aktualnaUroven.getNepriatel().getElement() == Element.Elektricky && entityHrac.getVybavenaZbran().getMaterial() == Material.Kov){
            entityHrac.setStav(new stavZelektrizovany());
            aktualnaUroven.getNepriatel().setSilaUtoku(this.getHrac().getZdravie());
        }
    }

    /**
     * Ziska aktualnu uroven.
     *
     * @return Aktualna uroven
     */
    public Uroven getAktualnaUroven() { return aktualnaUroven; }

    /**
     * Inicializuje hraca s danym menom a obtiaznostou.
     *
     * @param meno Meno hraca
     * @param obtiaznost Obtiaznost (0-lahka, 1-stredna, 2-tazka)
     */
    public void initHraca(String meno, int obtiaznost) {
        this.entityHrac = new EntityHrac(meno, 100 - (obtiaznost)*5, 10 - (obtiaznost)*2);
        this.zaciatokHry = Instant.now();
        this.trvanieHry = Duration.ofMillis(0);
    }

    /**
     * Vypocita celkovy cas hry.
     * Prida uplynuty cas od posledneho vypoctu k celkovemu trvaniu.
     */
    public void vypocitanieCasuHry(){
        long novaTrvanie = trvanieHry.toMillis() + Duration.between(zaciatokHry, Instant.now()).toMillis();
        trvanieHry = Duration.ofMillis(novaTrvanie);
        zaciatokHry = Instant.now();
        minuty = trvanieHry.toMinutes();
        sekundy = trvanieHry.minusMinutes(minuty).getSeconds();
    }

    /**
     * Ziska ulozeny cas v milisekundach.
     *
     * @return cas v ms
     */
    public long getUlozeneMillisekundy() { return trvanieHry.toMillis(); }

    /**
     * Ziska hraca.
     *
     * @return Hrac
     */
    public EntityHrac getHrac() { return this.entityHrac; }

    /**
     * Ulozi hru do suboru.
     * Ukladanie prebieha asynchronne na pozadi vlakna.
     *
     * @param subor Cesta k suboru pre ulozenie
     */
    public void ulozHru(String subor) {
        vypocitanieCasuHry();
        HernyStav stav = new HernyStav(entityHrac, aktualnaUroven);
        stav.setTrvanie(trvanieHry);

        threadPool.submit(() -> {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(subor))) {
                oos.writeObject(stav);
                logger.info("Hra bola ulozena do suboru: {}", subor);
            } catch (IOException e) {
                logger.error("Chyba pri ukladani hry: {}", e.getMessage());
            }
        });
    }

    /**
     * Nacita hru zo suboru.
     *
     * @param subor Cesta k suboru s ulozenou hrou
     */
    public void nacitajHru(String subor) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(subor))) {
            HernyStav stav = (HernyStav) ois.readObject();
            this.entityHrac = stav.getEntityHrac();
            this.aktualnaUroven = stav.getAktualnaUroven();
            this.trvanieHry = Duration.ofMillis(stav.getUlozeneMillisekundy());
            this.zaciatokHry = Instant.now();
            minuty = trvanieHry.toMinutes();
            sekundy = trvanieHry.minusMinutes(minuty).getSeconds();

            logger.info("Hra bola nacitana zo suboru: {}", subor);
        } catch (IOException | ClassNotFoundException | ChybaPriNacitavaniSuboru e) {
            logger.error("Chyba pri nacitavani hry: {}", e.getMessage());
        }
    }

    /**
     * Vypne thread pool pre ukladanie.
     */
    public void vypniThreadPool() {
        threadPool.shutdown();
    }
}