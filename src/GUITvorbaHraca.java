
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;

/**
 * Trieda GUITvorbaHraca reprezentuje uvodnu obrazovku na vytvorenie hraca.
 * Umoznuje zadanie mena hraca, vyber obtiaznosti a nacitanie existujucej hry.
 * Pouziva JavaFX pre graficke rozhranie.
 * 
 * @see GUIMain
 * @see ManagementHry
 * @see VBox
 */
public class GUITvorbaHraca extends VBox
{
    /** Referencie na hlavne okno aplikacie */
    private GUIMain GUIMain;
    /** Referencie na management hry */
    private ManagementHry managementHry;
    /** Logger pre logovanie udalosti */
    private static final Logger logger = LoggerFactory.getLogger(GUITvorbaHraca.class);

    /**
     * Konstruktor pre vytvorenie UI na vytvorenie hraca.
     * Inicializuje textove pole pre meno, slider pre obtiaznost a tlacitka.
     * 
     * @param GUIMain Hlavne okno aplikacie
     * @param managementHry Spravca hry
     */
    public GUITvorbaHraca(GUIMain GUIMain, ManagementHry managementHry)  {
        this.GUIMain = GUIMain;
        this.managementHry = managementHry;

        Label lMeno = new Label("Meno:");
        TextField tMeno = new TextField();
        tMeno.setMaxWidth(200);


        Label vypisObtiaznost = new Label("Stredna");
        Slider sObtiaznost = new Slider(1, 3, 2); //posuvnik pre vyber obtiaznosti
        sObtiaznost.setMaxWidth(200);
        sObtiaznost.setSnapToTicks(true);
        sObtiaznost.setMajorTickUnit(1);
        sObtiaznost.setMinorTickCount(0);
        sObtiaznost.setSnapToTicks(true);
        sObtiaznost.valueProperty().addListener((observableValue, staraHodnota, novaHodnota) ->
        {
            if(novaHodnota.intValue() == 1)
                vypisObtiaznost.setText("Lahka");
            else if(novaHodnota.intValue() == 2)
                vypisObtiaznost.setText("Stredna");
            else if(novaHodnota.intValue() == 3)
                vypisObtiaznost.setText("Tazka");
        });

        Button pokracovat = new Button("Zacat hru");
        Button btnNacitat = new Button("Nacitat hru");

        btnNacitat.setOnAction(event -> {
                    File subor = new File("ulozenaHra.dat");

                    if (subor.exists() && !subor.isDirectory()) {
                        managementHry.nacitajHru("ulozenaHra.dat");
                        GUIMain.zobrazCutscenu();
                    }
                    else {
                        logger.error("Neexistuje subor s ulozenou hrou");
                        throw new ChybaPriNacitavaniSuboru("Subor s ulozenou hrou sa nenasiel!");
                    }
                });

        pokracovat.setOnAction(event ->
        {
            if(tMeno.getText().isEmpty()) //ak je meno po stlaceni tlacitka prazdne, zmeni sa nadpis Meno: na ZADAJTE MENO aby hrac zadal meno, inak nemoze hrat
            {
                logger.error("Hrac nezadal meno, je to po nom pozadovane");
                lMeno.setText("ZADAJTE MENO");
                lMeno.setStyle("-fx-text-fill: red;");
            }

            else
            {
                managementHry.initHraca(tMeno.getText(), (int) sObtiaznost.getValue()); //funkcia pre vytvorenie hraca
                logger.info("Hrac bol uspesne vytvoreny, Meno {}, Obtiaznost {}, Zdravie {}, Sila utoku {}", managementHry.getHrac().getMeno(), sObtiaznost.getValue(), managementHry.getHrac().getZdravie(), managementHry.getHrac().getSilaUtoku());
                managementHry.dalsiaUroven(); //posunutie urovne z lvl0 na lvl1
                GUIMain.zobrazCutscenu(); //prepnutie na snimku ktora nas zobrazuje s prvou urovnou

            }
        });

        this.setSpacing(10); //nastavenie roztiahnutia jednotlivych elementov
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(lMeno, tMeno, sObtiaznost, vypisObtiaznost, pokracovat, btnNacitat);

    }

}
