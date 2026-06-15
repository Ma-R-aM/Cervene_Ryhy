import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Zobrazuje spravu o vitazstve a cas trvania hry.
 * Umoznuje ukoncenie aplikacie tlacidlom.
 * 
 * @see GUIMain
 * @see ManagementHry
 * @see StackPane
 */
public class GUIVyhra extends StackPane {
    /** Referencie na management hry */
    private ManagementHry managementHry;
    /** Referencie na hlavne okno */
    private GUIMain GUIMain;

    /**
     * Konstruktor pre okno vyhry.
     * 
     * @param managementHry Spravca hry
     * @param GUIMain Hlavne okno aplikacie
     */
    public GUIVyhra(ManagementHry managementHry, GUIMain GUIMain){
        this.managementHry = managementHry;
        this.GUIMain = GUIMain;

        VBox vbox = new VBox();
        Label lVyhra = new Label("Vyhra");
        lVyhra.setStyle(" -fx-text-fill: green; -fx-font-size: 30; ");
        lVyhra.setAlignment(Pos.CENTER);

        Label lTrvanie = new Label("Hra trvala " + managementHry.minuty + " minut a " + managementHry.sekundy + " sekund.");
        lTrvanie.setStyle("-fx-font-size: 15; ");
        lTrvanie.setAlignment(Pos.CENTER);

        Button btnKoniec = new Button("Koniec hry");
        btnKoniec.setStyle("-fx-font-size: 15; -fx-background-color: #388e3c; -fx-text-fill: white;");
        btnKoniec.setOnAction(e -> {
            managementHry.vypniThreadPool();
            GUIMain.getPrimaryStage().close();
        });

        vbox.getChildren().addAll(lVyhra, lTrvanie, btnKoniec);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        this.getChildren().add(vbox);

    }
}
