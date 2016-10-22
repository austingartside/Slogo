import javafx.application.Application;
import javafx.stage.Stage;
import screens.MainMenu;
import java.util.ResourceBundle;
import ViewLogic.DisplayUpdater;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Controller;
import View.DisplayGenerator;
/**
 * Created by Bill Xiong on 10/19/16.
 * Runs the program.
 */
public class Driver extends Application{
    public static final int WIDTH = 1000;
    public static final int HEIGHT  = 600;
    public static final String RESOURCE_BUNDLE = "bundle";
    
    private ResourceBundle myResources;
    
    public void start(Stage stage){
        //myResources = ResourceBundle.getBundle(RESOURCE_BUNDLE);
        MainMenu menu = new MainMenu();
        stage.setScene(menu.init(WIDTH,HEIGHT,myResources));
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
