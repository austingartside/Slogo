import java.util.ResourceBundle;
import javafx.application.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import screens.MainMenu;
import screens.SLogoScene;

public class GrantDriver extends Application {
    public static final int WIDTH = 1000;
    public static final int HEIGHT  = 600;
    public static final String RESOURCE_BUNDLE = "bundle";
    
    private ResourceBundle myResources;
    
    public void start(Stage stage){
        //myResources = ResourceBundle.getBundle(RESOURCE_BUNDLE);
        SLogoScene ss = new SLogoScene(new Scene(new Group(),WIDTH,HEIGHT),myResources,WIDTH,HEIGHT);
        stage.setScene(ss.getUpdater().getGeneratorScene());
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
