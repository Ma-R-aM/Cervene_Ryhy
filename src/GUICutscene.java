import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

/**
 * Trieda GUICutscene reprezentuje zobrazovanie cutscen (medziscen) pred bojom.
 * Zobrazuje obrazok a pribehovy text urovne pred samotnym bojom.
 * Hrac moze pokracovat po stlaceni tlacitka.
 * 
 * @see GUIMain
 * @see Uroven
 * @see StackPane
 */
public class GUICutscene extends StackPane
{
    /** Referencie na hlavne okno */
    private GUIMain GUIMain;
    /** Referencie na management hry */
    private ManagementHry managementHry;

    /**
     * Konstruktor pre vytvorenie cutsceny.
     * Nacitava obrazok a text urovne z aktualnej urovne.
     * 
     * @param GUIMain Hlavne okno aplikacie
     * @param managementHry Management hry
     */
    public GUICutscene(GUIMain GUIMain, ManagementHry managementHry)
    {
        this.GUIMain = GUIMain;
        this.managementHry = managementHry;


        String cesta = managementHry.getAktualnaUroven().getPathToCutPic(); //cesta ku suboru zobrazujuceho snimku pred bojom

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(cesta)));
        imageView.setPreserveRatio(true);
        imageView.fitHeightProperty().bind(this.heightProperty());
        imageView.fitWidthProperty().bind(this.widthProperty());


        VBox text = new VBox(30);
        text.setAlignment(Pos.CENTER);
        text.setPadding(new Insets(50));



        Label lPribeh = new Label(managementHry.getAktualnaUroven().getPopisUrovne()); //popis urovne, pise sa text pri zakladani urovne
        lPribeh.setWrapText(true);
        lPribeh.setTextAlignment(TextAlignment.CENTER);
        lPribeh.setStyle("-fx-background-color: rgba(0,0,0,0.5);-fx-text-fill: ivory ; -fx-font-size: 25 ; -fx-font-family: Papyrus");


        Button button = new Button("Do boja!");
        button.setPrefSize(50, 50);
        button.prefWidthProperty().bind(lPribeh.widthProperty().subtract(20));
        button.setStyle(
                "-fx-background-color: rgba(50,50,50, 0.7);" +
                "-fx-border-color: white; " +
                "-fx-border-width: 1px;" +
                        "-fx-text-fill: ivory;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;"
        );
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: rgba(100, 100, 100, 0.9); -fx-text-fill: white;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: rgba(50,50,50,0.7); -fx-text-fill: ivory;"));

        button.setOnAction(event -> {
            GUIMain.zobrazBoj();
        });

        text.getChildren().addAll(lPribeh, button);

        this.getChildren().addAll(imageView, text);


        StackPane.setMargin(text, new Insets(500,0,0,0));

    }
}
