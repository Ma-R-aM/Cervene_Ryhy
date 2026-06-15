import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * Trieda GUIMain je hlavna trieda aplikacie JavaFX.
 * Spravuje prepinanie medzi scenami hry.
 * 
 * @see GUITvorbaHraca
 * @see GUICutscene
 * @see GUIBoj
 * @see GUIPrehra
 * @see GUIVyhra
 */
public class GUIMain extends Application {
    /** Hlavne okno aplikacie */
    private Stage primaryStage;
    private ManagementHry hra = new ManagementHry();

    /**
     * Spusti JavaFX aplikaciu a inicializuje hlavne okno.
     * Vytvara uvodnu scenu s tvorbou hraca.
     * 
     * @param stage Hlavne okno javaFX aplikacie
     */
    @Override
    public void start(Stage stage) { //pouzivanie kniznice pre vykreslovanie
        this.primaryStage = stage;
        this.primaryStage.setTitle("Cervene Ryhy RPG"); //nastavenie nazvu okna

        GUITvorbaHraca root = new GUITvorbaHraca(this, hra); //vytvaranie sceny ktora sa zobrazi
        Scene scene = new Scene(root, 1920, 1080);
        this.primaryStage.setScene(scene);

        this.primaryStage.show();
    }


    /**
     * Prepne scenu na cutscenu (medziscenu).
     * Zobrazuje pribehovy text pred bojom.
     */
    public void zobrazCutscenu() {
        GUICutscene root = new GUICutscene(this, hra);
        Scene scene = new Scene(root, 1920, 1080);
        primaryStage.setScene(scene);
    }

    /**
     * Prepne scenu na bojove rozhranie.
     * Zobrazuje boj hraca s nepriatelom.
     */
    public void zobrazBoj() {
        GUIBoj root = new GUIBoj(this, hra);
        Scene scene = new Scene(root, 1920, 1080);
        primaryStage.setScene(scene);
    }

    /**
     * Prepne scenu na obrazovku prehry.
     * Zobrazuje po smrti hraca.
     */
    public void zobrazPrehra() {
        GUIPrehra root = new GUIPrehra(hra, this);
        Scene scene = new Scene(root, 1920, 1080);
        primaryStage.setScene(scene);
    }


    /**
     * Prepne scenu na obrazovku vyhry.
     * Zobrazuje po vyhrani poslednej urovne.
     */
    public void zobrazVyhra() {
        GUIVyhra root = new GUIVyhra(hra, this);
        Scene scene = new Scene(root,1920, 1080);
        primaryStage.setScene(scene);
    }

    /**
     * Ziska hlavne okno aplikacie.
     * 
     * @return Hlavne okno
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}