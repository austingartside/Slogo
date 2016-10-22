import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ResourceBundle;
import ViewLogic.DisplayUpdater;
import model.Controller;
/**
 * Created by Bill Xiong on 10/19/16.
 * Runs the program.
 */
public class Driver extends Application{
    public static final int WIDTH = 1000;
    public static final int HEIGHT  = 600;
    public static final String RESOURCE_BUNDLE = "resources.languages.bundle";
    private ResourceBundle myResources;
    public void start(Stage stage){
        DisplayUpdater display = new DisplayUpdater();
        display.setUp();
        Controller control=new Controller();
        control.setUp();
        stage.setScene(display.getGeneratorScene());
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
