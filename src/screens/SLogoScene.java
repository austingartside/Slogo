package screens;

import java.util.ResourceBundle;
import View.DisplayGenerator;
import ViewLogic.DisplayUpdater;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;

public class SLogoScene extends ActionScene{
    
    private GridPane mainView;
    private Scene myScene;
    private Canvas turtleCanvas;
    private Canvas backgroundCanvas;
    private TextField commandLine;
    private DisplayUpdater updater;
    private ToolBar toolBar;
    
    public SLogoScene(Scene scene, ResourceBundle resource, int height, int width){
        super(scene, resource, height, width);
        mainView = new GridPane();
        mainView.setAlignment(Pos.CENTER);
        mainView.setHgap(10);
        mainView.setVgap(10);
        mainView.setPadding(new Insets(25, 25, 25, 25));
        updater = new DisplayUpdater(new DisplayGenerator());
        updater.setUp();
        myScene = updater.getGeneratorScene();
        //setScene();
    }
    public DisplayUpdater getUpdater(){
        return updater;
    }
    
    /**
     * This method adds all necessary components to the front end.
     * TODO add a turtle image here. Will do this once Gunhan/Austin makes getter for image.
     */
    /*public void setScene(){
        myScene.setRoot(displayGenerator.setScene());
    }*/
}
