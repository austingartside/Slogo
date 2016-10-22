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
    private DisplayGenerator displayGenerator;
    private ToolBar toolBar;
    
    public SLogoScene(ResourceBundle resource, int h, int w){
        super(resource, h, w);
        displayGenerator = new DisplayGenerator();
        DisplayUpdater display = new DisplayUpdater(displayGenerator);
        display.setUp();
    }
    
    /**
     * This method adds all necessary components to the front end.
     * TODO add a turtle image here. Will do this once Gunhan/Austin makes getter for image.
     */
    public Scene setScene(){
        displayGenerator.setScene();
        mainView = displayGenerator.getGridPane();
        myScene =  new Scene(mainView,width,height);
        return myScene;
    }
    public GridPane getRoot(){
        return mainView;
    }
}
