import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Trieda GUIPrehra reprezentuje obrazovku po prehre hraca.
 * Zobrazuje spravu o smrti a cas trvania hry.
 * Umoznuje ukoncenie hry tlacidlom.
 * 
 * @see GUIMain
 * @see ManagementHry
 * @see StackPane
 */
public class GUIPrehra extends StackPane
{
    /** Referencie na management hry */
    private ManagementHry managementHry;
    /** Referencie na hlavne okno */
    private GUIMain GUIMain;

    /**
     * Konstruktor pre obrazovku prehry.
     * 
     * @param managementHry Spravca hry
     * @param GUIMain Hlavne okno aplikacie
     */
    public GUIPrehra(ManagementHry managementHry, GUIMain GUIMain) {
        this.managementHry = managementHry;
        this.GUIMain = GUIMain;

        VBox vText = new VBox();
        Label lText = new Label("Zomrel si");
        lText.setStyle("-fx-text-fill: red; -fx-font-size: 30;");
        lText.setAlignment(Pos.CENTER);
        Label lTrvanie = new Label("Hra trvala " + managementHry.minuty + " minut a " + managementHry.sekundy + " sekund.");
        lTrvanie.setStyle("-fx-font-size: 15; ");
        lTrvanie.setAlignment(Pos.CENTER);

        Button btnKoniec = new Button("Koniec hry");
        btnKoniec.setStyle("-fx-font-size: 15; -fx-background-color: #d32f2f; -fx-text-fill: white;");
        btnKoniec.setOnAction(e -> {
            managementHry.vypniThreadPool();
            GUIMain.getPrimaryStage().close();
        });

        vText.getChildren().add(lText);
        vText.getChildren().add(lTrvanie);
        vText.getChildren().add(btnKoniec);
        vText.setSpacing(20);
        vText.setAlignment(Pos.CENTER);

        this.getChildren().add(vText);
    }
}
