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
