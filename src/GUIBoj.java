import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Trieda GUIBoj reprezentuje bojove rozhranie hry.
 * Zobrazuje hraca a nepriatela, ich zdravie a umoznuje utocne akcie.
 * Pouziva JavaFX pre graficke rozhranie a obsahuje:<br>
 * - Zobrazenie obrazkov nepriatelov<br>
 * - zobrazenie HP a akcii<br>
 * - Inventar a tlacitka na akcie<br>
 * - Postupnost kola (po hracovi bojuje nepriatel) a prechod na dalsiu uroven<br>
 * 
 * @see GUIMain
 * @see ManagementHry
 * @see StackPane
 */
public class GUIBoj extends StackPane
{
    /** Referencie na hlavne okno */
    private GUIMain GUIMain; //inicializovanie jednotlivych predmetov s ktorymi potrebujeme narabat v priebehu hry, napr menit text mimo funkcie
    /** Referencie na management hry */
    private ManagementHry managementHry;
    /** Label pre zobrazenie zdravia hraca */
    private Label lHpHraca;
    /** Label pre zobrazenie zdravia nepriatela */
    private Label lHpEnemy;
    /** Label pre akciu hraca */
    private Label lAkciaHraca;
    /** Label pre akciu nepriatela */
    private Label lAkciaEnemy;
    /** Panel inventara */
    private HBox inventar;
    /** Spodny panel s tlacitkami */
    private VBox spodnyPanel;
    /** Tlacitko utoku */
    private Button btnUtok;
    /** Logger pre logovanie */
    private static final Logger logger = LoggerFactory.getLogger(GUIBoj.class);


    /**
     * Konstruktor bojoveho rozhrania.
     * Inicializuje graficke prvky a nastavi akcie tlacidiel.
     * 
     * @param GUIMain Hlavne okno aplikacie
     * @param managementHry Spravca hry
     */
    public GUIBoj(GUIMain GUIMain, ManagementHry managementHry) {
        this.GUIMain = GUIMain;
        this.managementHry = managementHry;

        String cesta = managementHry.getAktualnaUroven().getNepriatel().getCestaKObrazku(); //cesta ku obrazku ktory bude ako pozadie boja

        ImageView imageView = new ImageView();

        if (cesta == null) {
            imageView.setImage(new Image(getClass().getResourceAsStream("/pic/Error.png")));
            logger.error("Path pre scenu boja je null");
            throw new ChybaNeplatnaCesta("!!!ERROR Cesta je null!!!");
        }

        try (var is = getClass().getResourceAsStream(cesta)) {
            if (is == null)
                throw new ChybaNeplatnaCesta("Subor na ceste '" + cesta + "' sa nenasiel!");

            imageView.setImage(new Image(is));
        }

        catch (Exception e) {
            imageView.setImage(new Image(getClass().getResourceAsStream("/pic/Error.png")));
            logger.error("Nepodarilo sa nacitat prostredie boja: ", e);
        }

        imageView.setPreserveRatio(true);
        imageView.fitHeightProperty().bind(this.heightProperty());
        imageView.fitWidthProperty().bind(this.widthProperty());

        BorderPane uiLayout = new BorderPane();

        HBox hpbar = new HBox(50);
        hpbar.setAlignment(Pos.CENTER);
        hpbar.setPadding(new Insets(15));
        hpbar.setStyle("-fx-background-color: white;");
        this.lHpHraca = new Label();
        this.lHpEnemy = new Label();
        this.lAkciaHraca = new Label();
        this.lAkciaEnemy = new Label();

        lAkciaHraca.setText("Utoci " + managementHry.getHrac().getSilaUtoku());lAkciaHraca.setVisible(false);
        lHpHraca.setText("");
        lHpEnemy.setText("");
        lAkciaEnemy.setText("Udeluje poskodenie " + managementHry.getAktualnaUroven().getNepriatel().getSilaUtoku()); lAkciaEnemy.setVisible(false);
        lAkciaHraca.setStyle("-fx-font-size: 15");
        lAkciaEnemy.setStyle("-fx-font-size: 15");
        lHpHraca.setStyle("-fx-font-size: 15");
        lHpEnemy.setStyle("-fx-font-size: 15");

        hpbar.getChildren().addAll(lAkciaHraca, lHpHraca, lHpEnemy, lAkciaEnemy);
        hpbar.setSpacing(40);
        uiLayout.setTop(hpbar);


        this.spodnyPanel = new VBox(15);
        this.spodnyPanel.setAlignment(Pos.CENTER);
        this.spodnyPanel.setPadding(new Insets(20));
        this.spodnyPanel.setStyle("-fx-background-color: white;");

        HBox akcie = new HBox(20);
        akcie.setAlignment(Pos.CENTER);

        btnUtok = new Button("Pouzit " + managementHry.getHrac().getVybavenaZbran().getNazov());

        Button btnUlozit = new Button("Ulozit hru");
        btnUlozit.setOnAction(event -> {
            managementHry.ulozHru("ulozenaHra.dat");
            lAkciaHraca.setText("Hra bola ulozena!");
            lAkciaHraca.setVisible(true);
        });

        btnUtok.setPrefHeight(40);
        btnUtok.setStyle("-fx-font-size: 18");
        btnUlozit.setStyle("-fx-font-size: 15");

        logger.info("Bol spusteny boj Hrac HP: {}, {} HP: {}", managementHry.getHrac().getZdravie(), managementHry.getAktualnaUroven().getNepriatel().getMeno(), managementHry.getAktualnaUroven().getNepriatel().getZdravie());

        managementHry.logikaKola();



        btnUtok.setOnAction(event -> { tahHraca(); } );

        akcie.getChildren().addAll(btnUtok, btnUlozit);

        this.inventar = new HBox(10);
        this.inventar.setAlignment(Pos.CENTER);

        spodnyPanel.getChildren().addAll(akcie, inventar);
        uiLayout.setBottom(spodnyPanel);

        this.getChildren().addAll(imageView, uiLayout); //pridavanie prvkov do grafickeho uzivatelskeho rozhrania

        initObserverov();
        vykresliInventar();

    } //aby sme vedeli narabat s hernou logikou a hlavnou castou grafickych prvkov

    /**
     * Vykresluje aktualny inventar hraca.
     * Vytvara tlacidla pre kazdy predmet v inventari.
     * Spracovava pouzitie zbrani aj lektvarov.
     */
    private void vykresliInventar() { //osobitna funkcia kvoli zlozitosti kodu a obnovovani inventaru po pouziti lektvaru


        inventar.getChildren().clear(); //vynulovanie GUI
        inventar.getChildren().add(new Label("Inventar: ")); //budovanie na novo


        int counter = 0;

        for (Vybavenie v : managementHry.getHrac().getInventar()) {

            Button btn = new Button(v.getNazov());

            btn.setPrefSize(100, 30);

            final int index = counter; //musi byt final kvoli indexovaniu pri pouzivani

            btn.setOnAction(event ->
            {
                switch (managementHry.getHrac().pouziZInventara(index)) { //tento switch pozera ci je pod tlacitkom zbran alebo lektvar, navratova hodnota je 1 ak sa jedna o zbran, 2 ak sa jedna o lektvar a -1 ak sa nejedna o ani jedno a nastala chyba
                    case 1 -> { //totozna logika ako v hlavnom tlacitku utoku s tym rozdielom, ze tu sa aj meni aktualne pouzivana zbran (funkcia pouziZInventara) a prepisuje sa obsah tlacitka hlavneho utoku
                        btnUtok.setText("Pouzit " + managementHry.getHrac().getVybavenaZbran().getNazov());
                        tahHraca();
                    }

                    case 2 -> { //ak bolo vybrane tlacitko s lektvarom

                        Lektvar lekt = (Lektvar) v;
                        logger.debug("Hrac pouzil lektvar {} a dostal {} HP", lekt.getNazov(), lekt.getSilaLiecenia() );
                        if(lekt instanceof LektvarRegen) //zistuje sa, ci sa nejedna o lektvar s ucinkom regeneracie, ak ano tak sa pouzi funkcia v Hrac .setRegen
                        {
                            managementHry.getHrac().setRegen(((LektvarRegen) lekt).getTrvanie(), ((LektvarRegen) lekt).getRegenLiecenie());
                            lAkciaHraca.setText("Aktivovana regeneracia na\n" + managementHry.getHrac().getZostavajuceKolaPreRegen() + " kola!");
                        }

                        spodnyPanel.setDisable(true);
                        btn.setText("Pouzite");
                        lAkciaHraca.setText(managementHry.getHrac().getMeno() + " ziskal " + ((Lektvar) v).getSilaLiecenia() + " HP");
                        lAkciaHraca.setVisible(true);

                        PauseTransition cakaniePoHracovi = new PauseTransition(Duration.millis(1500));

                        cakaniePoHracovi.setOnFinished(e ->
                        {
                            lAkciaHraca.setVisible(false);
                            lAkciaEnemy.setText("Udeluje poskodenie " + managementHry.getAktualnaUroven().getNepriatel().getSilaUtoku());
                            lAkciaEnemy.setVisible(true);

                            logger.debug("Nepriatel utoci, Hrac HP {}, {} HP {}, sila utoku {}", managementHry.getHrac().getZdravie(), managementHry.getAktualnaUroven().getNepriatel().getMeno() ,managementHry.getAktualnaUroven().getNepriatel().getZdravie(), managementHry.getAktualnaUroven().getNepriatel().getSilaUtoku() );
                            managementHry.bojNepriatela();
                            if(managementHry.getHrac().getStav() instanceof stavZapaleny)
                                lAkciaHraca.setText("Horis, \nstratil si " + ((stavZapaleny) managementHry.getHrac().getStav()).getPopalenie() + "HP");

                            if(managementHry.KoniecSuboja() == 2) //pozeranie ci hrac stale zije, nemiesame vykreslovanie s logikou hry a preto si tuto informaciu pytame od managementHry
                            {
                                PauseTransition prehra = new PauseTransition(Duration.millis(1500));
                                logger.info("Hrac zomrel");
                                prehra.setOnFinished(ePrehra -> GUIMain.zobrazPrehra());prehra.play();
                            }

                            PauseTransition cakanieNaEnemy = new PauseTransition(Duration.millis(1500));
                            cakanieNaEnemy.setOnFinished(eve ->
                            {
                                spodnyPanel.setDisable(false);
                                lAkciaEnemy.setVisible(false);
                                lAkciaHraca.setVisible(false);
                                managementHry.logikaKola();

                                if(managementHry.KoniecSuboja() == 2)
                                {
                                    logger.info("Hrac zomrel");
                                    GUIMain.zobrazPrehra();
                                }

                            });
                            cakanieNaEnemy.play();


                        });
                        cakaniePoHracovi.play();
                        vykresliInventar();
                    }

                    case -1 -> logger.error("Vybavenie, ktore nie je ani zbran ani lektvar");
                }

            });

            inventar.getChildren().add(btn); //pridanie tlacidla do dolneho panela
            counter++; //zvysenie indexu
        }
    }

    /**
     * Spracuva tah hraca v boji.
     * Obsahuje utok Hraca, nepriatela, kontrolu stavu a prechod na dalsiu uroven.
     */
    private void tahHraca() {
        spodnyPanel.setDisable(true); //vypinanie tlacidiel aby hrac nemohol spravit viacero akcii naraz v jednom tahu

        if(managementHry.getHrac().getStav().mozeUtocit()) {
            lAkciaHraca.setText("Utoci " + managementHry.getHrac().getSilaUtoku());
            lAkciaHraca.setVisible(true);

            logger.debug("Hrac utoci,      Hrac HP {}, {} HP {}, sila utoku {}", managementHry.getHrac().getZdravie(), managementHry.getAktualnaUroven().getNepriatel().getMeno(), managementHry.getAktualnaUroven().getNepriatel().getZdravie(), managementHry.getHrac().getSilaUtoku() );
            managementHry.bojHraca();
        }

        int stavHry = managementHry.KoniecSuboja();

        switch (stavHry) { //funkcia koniecSuboja() ma navratovu hodnotu 0 ak boj pokracuje, 1 ak hrac vyhral a teda nepriatel zomrel a navratovu hodnotu 2 ak zomrel hrac
            case (0) -> {
                PauseTransition cakaniePoHracovi = new PauseTransition(Duration.millis(1500));

                cakaniePoHracovi.setOnFinished(e -> //pomocou PauseTransition funguje cakanie realneho casu pre hraca, aby si stihol precitat co sa deje
                {
                    managementHry.skontrolujZelektrizovanie();

                    logger.debug("Nepriatel utoci, Hrac HP {}, {} HP {}, sila utoku {}", managementHry.getHrac().getZdravie(), managementHry.getAktualnaUroven().getNepriatel().getMeno() ,managementHry.getAktualnaUroven().getNepriatel().getZdravie(), managementHry.getAktualnaUroven().getNepriatel().getSilaUtoku() );
                    managementHry.bojNepriatela();


                    lAkciaHraca.setVisible(false);
                    lAkciaEnemy.setText("Udeluje poskodenie " + managementHry.getAktualnaUroven().getNepriatel().getSilaUtoku());
                    lAkciaEnemy.setVisible(true);
                    if(managementHry.getHrac().getStav() instanceof stavZapaleny) {
                        lAkciaHraca.setText("Horis, \nstratil si " + ((stavZapaleny) managementHry.getHrac().getStav()).getPopalenie() + "HP");
                        lAkciaHraca.setVisible(true);
                    }

                    if(managementHry.KoniecSuboja() == 2) //pozeranie ci hrac stale zije, nemiesame vykreslovanie s logikou hry a preto si tuto informaciu pytame od managementHry
                    {
                        PauseTransition prehra = new PauseTransition(Duration.millis(1500));
                        logger.info("Hrac zomrel");
                        prehra.setOnFinished(ePrehra -> GUIMain.zobrazPrehra());prehra.play();
                    }
                    else {

                        PauseTransition cakanieNaEnemy = new PauseTransition(Duration.millis(1500));
                        cakanieNaEnemy.setOnFinished(eve -> {
                            spodnyPanel.setDisable(false); //opatovne zapnutie tlacidiel po vykonani utoku nepriatela
                            lAkciaEnemy.setVisible(false);
                            lAkciaHraca.setVisible(false);
                            managementHry.logikaKola();

                            if(managementHry.KoniecSuboja() == 2)
                            {
                                logger.info("Hrac zomrel");
                                GUIMain.zobrazPrehra();
                            }

                            if (!managementHry.getHrac().getStav().mozeUtocit()) {
                                lAkciaHraca.setVisible(true);
                                if(managementHry.getHrac().getStav() instanceof stavOtraveny)
                                    lAkciaHraca.setText("Si otraveny, \notrava ti ubrala " + ((stavOtraveny) managementHry.getHrac().getStav()).getPoskodenie() + "HP");

                                tahHraca();
                            }

                        });cakanieNaEnemy.play();
                    }

                }); cakaniePoHracovi.play();

                if(managementHry.KoniecSuboja() == 2 ) {
                    logger.info("Hrac zomrel");
                    GUIMain.zobrazPrehra();
                }

            }

            case (1) -> { //navratova hodnota 1 znamena zabitie nepriatela tj. posunutie sa na dalsiu uroven
                logger.info("Hrac vyhral kolo - odmena +10HP");
                lAkciaHraca.setText(("PORAZIL SI NEPRIATELA!\nDostal si 10 HP!")); //po porazeni nepriatela sa vo funkcii koniecSuboja zvysi hracovo zdravie o 10 ako bonus.
                lAkciaHraca.setVisible(true);
                PauseTransition pauza = new PauseTransition(Duration.millis(1500));
                pauza.setOnFinished(e -> {
                    if(managementHry.dalsiaUroven()) //ak uz nie je ziadna dalsia uroven, funkcia vrati true a podmienka sa vyhodnoti
                        GUIMain.zobrazVyhra();

                    else
                        GUIMain.zobrazCutscenu();
                });pauza.play();
            }


            case(2) -> { GUIMain.zobrazPrehra(); logger.info("Hrac zomrel"); } // ak hrac zomrel tak vykresli okno s prehrou

        }
    }

    /**
     * Inicializuje observerov pre sledovanie zmien zdravia.
     * Pridava lambdy na aktualizaciu HP labelov.
     */
    public void initObserverov() {
        managementHry.getHrac().pridajObserver(noveZdravie -> {
            Platform.runLater(() -> {
                lHpHraca.setText(managementHry.getHrac().getMeno() + " HP: " + noveZdravie + " / " + managementHry.getHrac().getMaxZdravie());
            });
        } );

        managementHry.getAktualnaUroven().getNepriatel().pridajObserver(noveZdravie -> {
            Platform.runLater(() -> {
                lHpEnemy.setText(managementHry.getAktualnaUroven().getNepriatel().getMeno() + " HP: " + noveZdravie + " / " + managementHry.getAktualnaUroven().getNepriatel().getMaxZdravie());
            });
        } );
    }

}